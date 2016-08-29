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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marko
 */
public class Ucinak implements Serializable, DomenskiObjekat {

    private Kosarkas kosarkas;
    private Utakmica utakmica;
    private TipUcinka tipUcinka;
    private int vrednost;
    private Korisnik korisnik;

    public Ucinak() {
    }

    public Ucinak(Kosarkas kosarkas, Utakmica utakmica, TipUcinka tipUcinka, int vrednost) {
        this.kosarkas = kosarkas;
        this.utakmica = utakmica;
        this.tipUcinka = tipUcinka;
        this.vrednost = vrednost;
    }

    public Ucinak(Kosarkas kosarkas, Utakmica utakmica, TipUcinka tipUcinka, int vrednost, Korisnik korisnik) {
        this.kosarkas = kosarkas;
        this.utakmica = utakmica;
        this.tipUcinka = tipUcinka;
        this.vrednost = vrednost;
        this.korisnik = korisnik;
    }

    public TipUcinka getTipUcinka() {
        return tipUcinka;
    }

    public void setTipUcinka(TipUcinka tipUcinka) {
        this.tipUcinka = tipUcinka;
    }

    public int getVrednost() {
        return vrednost;
    }

    public void setVrednost(int vrednost) {
        this.vrednost = vrednost;
    }

    public Kosarkas getKosarkas() {
        return kosarkas;
    }

    public void setKosarkas(Kosarkas kosarkas) {
        this.kosarkas = kosarkas;
    }

    public Utakmica getUtakmica() {
        return utakmica;
    }

    public void setUtakmica(Utakmica utakmica) {
        this.utakmica = utakmica;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Ucinak)) {
            return false;
        }

        return ((Ucinak) obj).getKosarkas().equals(this.kosarkas) && ((Ucinak) obj).getTipUcinka().equals(this.tipUcinka) && ((Ucinak) obj).getUtakmica().equals(this.utakmica);
    }

    @Override
    public String vratiDeoZaINSERT(int i) {
        return "ucinak(kosarkas, utakmica, tip, vrednost, korisnik)";
    }

    @Override
    public String vratiVrednostiZaINSERT(int i) {
        return String.format("('%s', %s, '%s', %s, '%s')", this.kosarkas.getJmbg(), this.utakmica.getIdUtakmice(), this.tipUcinka.getNaziv(), this.vrednost, this.korisnik.getUsername());
    }

    @Override
    public String vratiImeTabele() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaSET() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaWHERE() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiDeoZaSELECT() {
        return "*";
    }

    @Override
    public String vratiDeoZaFROM() {
        return "ucinak u JOIN utakmica ut ON (u.utakmica = ut.id) JOIN kosarkas k ON (u.kosarkas = k.jmbg) JOIN tipucinka t ON (u.tip = t.naziv) JOIN tim tm ON (k.sifratima = tm.sifratima) JOIN korisnik ko ON (ko.username = u.korisnik) HAVING u.utakmica = " + this.getUtakmica().getIdUtakmice();
    }

    @Override
    public List napuniListuObjekata(ResultSet rs) {
        List<Ucinak> lu = new ArrayList<>();
        try {
            while (rs.next()) {
                TipUcinka tip = new TipUcinka(rs.getString("naziv"), rs.getString("opis"));
                Tim t = new Tim(rs.getInt("sifratima"), rs.getString("naziv"), rs.getInt("godinaosnivanja"), rs.getString("grad"), rs.getString("hala"));
                Kosarkas k = new Kosarkas(rs.getString("ime"), rs.getString("prezime"), rs.getString("jmbg"), rs.getDate("datumrodjenja"), rs.getString("pozicija"), rs.getInt("broj"), t, rs.getInt("visina"), rs.getInt("tezina"));
                int v = rs.getInt("vrednost");
                Korisnik ko = new Korisnik(rs.getString("username"), rs.getString("password"), rs.getString("mail"));
                //System.out.println(this.getUtakmica());
                lu.add(new Ucinak(k, this.getUtakmica(), tip, v, ko));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ucinak.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lu;
    }

    @Override
    public DomenskiObjekat vratiObjekat(ResultSet tabela) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int vratiID(ResultSet tabela) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
