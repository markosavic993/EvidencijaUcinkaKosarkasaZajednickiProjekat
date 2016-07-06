/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Konstante;

/**
 *
 * @author Marko
 */
public class Kosarkas implements Serializable, DomenskiObjekat {

    private String ime;
    private String prezime;
    private String jmbg;
    private Date datumRodjenja;
    private String pozicija;
    private int brojNaDresu;
    private Tim timZaKojiNastupa;
    private int visina;
    private int tezina;

    private int uslov;

    public Kosarkas() {
    }

    public Kosarkas(String ime, String prezime, String jmbg, Date datumRodjenja, String pozicija, int brojNaDresu, Tim timZaKojiNastupa, int visina, int tezina) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.datumRodjenja = datumRodjenja;
        this.pozicija = pozicija;
        this.brojNaDresu = brojNaDresu;
        this.timZaKojiNastupa = timZaKojiNastupa;
        this.visina = visina;
        this.tezina = tezina;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public int getBrojNaDresu() {
        return brojNaDresu;
    }

    public void setBrojNaDresu(int brojNaDresu) {
        this.brojNaDresu = brojNaDresu;
    }

    public Tim getTimZaKojiNastupa() {
        return timZaKojiNastupa;
    }

    public void setTimZaKojiNastupa(Tim timZaKojiNastupa) {
        this.timZaKojiNastupa = timZaKojiNastupa;
    }

    public int getVisina() {
        return visina;
    }

    public void setVisina(int visina) {
        this.visina = visina;
    }

    public int getTezina() {
        return tezina;
    }

    public void setTezina(int tezina) {
        this.tezina = tezina;
    }

    public int getUslov() {
        return uslov;
    }

    public void setUslov(int uslov) {
        this.uslov = uslov;
    }

    @Override
    public String toString() {
        return prezime + " " + ime + ", " + timZaKojiNastupa;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Kosarkas)) {
            return false;
        }

        return ((Kosarkas) obj).getJmbg().equals(this.jmbg);
    }

    @Override
    public String vratiDeoZaINSERT(int i) {
        return "kosarkas(ime, prezime, datumrodjenja, jmbg, pozicija, broj, visina, tezina, sifratima)";
    }

    @Override
    public String vratiVrednostiZaINSERT(int i) {
        return String.format("('%s','%s','%s','%s','%s',%s,%s,%s,%s)", ime, prezime, new java.sql.Date(datumRodjenja.getTime()), jmbg, pozicija, brojNaDresu, visina, tezina, timZaKojiNastupa.getSifraTima());
    }

    @Override
    public String vratiImeTabele() {
        return "kosarkas";
    }

    @Override
    public String vratiVrednostiZaSET() {
        if (uslov == Konstante.AZURIRAJ_KOSARKASE_NAKON_BRISNJA_TIMA) {
            return "sifratima = 1";
        }

        return String.format("ime = '%s', prezime = '%s', datumrodjenja = '%s', pozicija = '%s', broj = %s, visina = %s, tezina = %s, sifratima = %s",
                ime, prezime, new java.sql.Date(datumRodjenja.getTime()), pozicija, brojNaDresu, visina, tezina, timZaKojiNastupa.getSifraTima());
    }

    @Override
    public String vratiVrednostiZaWHERE() {
        if (uslov == Konstante.AZURIRAJ_KOSARKASA || uslov == Konstante.IZBRISI_KOSARKASA) {
            return String.format("jmbg = '%s'", jmbg);
        }

        if(uslov == Konstante.VRATI_KOSARKASE_PREMA_KRITERIJUMU) {
            return String.format("k.sifratima = %s ORDER BY k.prezime", timZaKojiNastupa.getSifraTima());
        }
        return String.format("sifratima = %s", timZaKojiNastupa.getSifraTima());

    }

    @Override
    public String vratiDeoZaSELECT() {
        return "*";
    }

    @Override
    public String vratiDeoZaFROM() {
        if (uslov == Konstante.IZBRISI_KOSARKASA) {
            return "kosarkas";
        }
        
        if(uslov == Konstante.VRATI_KOSARKASE_PREMA_KRITERIJUMU) {
            return "kosarkas k JOIN tim t ON k.sifratima = t.sifratima";
        }
        
        return "kosarkas k JOIN tim t ON k.sifratima = t.sifratima ORDER BY k.prezime";
    }

    @Override
    public List napuniListuObjekata(ResultSet rs) {
        List<Kosarkas> lk = new ArrayList<>();
        try {
            while (rs.next()) {
                Tim t = new Tim(rs.getInt("sifratima"), rs.getString("naziv"), rs.getInt("godinaosnivanja"), rs.getString("grad"), rs.getString("hala"));
                Kosarkas k = new Kosarkas(rs.getString("ime"), rs.getString("prezime"), rs.getString("jmbg"), rs.getDate("datumrodjenja"), rs.getString("pozicija"), rs.getInt("broj"), t, rs.getInt("visina"), rs.getInt("tezina"));
                lk.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Kosarkas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lk;
    }

    @Override
    public DomenskiObjekat vratiObjekat(ResultSet tabela) {
        return null;
    }

    @Override
    public int vratiID(ResultSet tabela) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
