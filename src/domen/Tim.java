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
import util.Konstante;

/**
 *
 * @author Marko
 */
public class Tim implements Serializable, DomenskiObjekat {

    private int sifraTima;
    private String naziv;
    private int godinaOsnivanja;
    private String grad;
    private String nazivHale;

    private int uslov;

    public Tim() {
    }

    public Tim(String naziv) {
        this.naziv = naziv;
    }

    public Tim(int sifraTima, String naziv, int godinaOsnivanja, String grad, String nazivHale) {
        this.sifraTima = sifraTima;
        this.naziv = naziv;
        this.godinaOsnivanja = godinaOsnivanja;
        this.grad = grad;
        this.nazivHale = nazivHale;
    }

    public int getSifraTima() {
        return sifraTima;
    }

    public void setSifraTima(int sifraTima) {
        this.sifraTima = sifraTima;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getGodinaOsnivanja() {
        return godinaOsnivanja;
    }

    public void setGodinaOsnivanja(int godinaOsnivanja) {
        this.godinaOsnivanja = godinaOsnivanja;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getNazivHale() {
        return nazivHale;
    }

    public void setNazivHale(String nazivHale) {
        this.nazivHale = nazivHale;
    }

    public int getUslov() {
        return uslov;
    }

    public void setUslov(int uslov) {
        this.uslov = uslov;
    }

    @Override
    public String toString() {
        if (this.naziv.startsWith("Slobodan")) {
            return naziv;
        }
        return this.naziv + " ( " + this.grad + " )";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Tim)) {
            return false;
        }

        return ((Tim) obj).getNaziv().equals(this.getNaziv()) && ((Tim) obj).getGrad().equals(this.grad);
    }

    @Override
    public String vratiDeoZaINSERT(int i) {
        return "tim(sifratima, naziv, godinaosnivanja, grad, hala)";
    }

    @Override
    public String vratiVrednostiZaINSERT(int i) {
        return String.format("(%s, '%s', %s, '%s', '%s')", this.sifraTima, this.naziv, this.godinaOsnivanja, this.grad, this.nazivHale);
    }

    @Override
    public String vratiImeTabele() {
        return "tim";
    }

    @Override
    public String vratiVrednostiZaSET() {
        return String.format("naziv = '%s', godinaosnivanja = %s, grad = '%s', hala = '%s'", this.naziv, this.godinaOsnivanja, this.grad, this.nazivHale);
    }

    @Override
    public String vratiVrednostiZaWHERE() {
        if (uslov == Konstante.AZURIRAJ_TIM || uslov == Konstante.IZBRISI_TIM) {
            return String.format("sifratima = %s", this.sifraTima);
        }

        return String.format("naziv = '%s'", this.naziv);
    }

    @Override
    public String vratiDeoZaSELECT() {
        if (uslov == Konstante.VRATI_ID_TIMA) {
            return "MAX(sifratima)";
        }

        return "*";
    }

    @Override
    public String vratiDeoZaFROM() {
        if (uslov == Konstante.IZBRISI_TIM || uslov == Konstante.VRATI_ID_TIMA || uslov == Konstante.VRATI_TIMOVE_PREMA_KRITERIJUMU) {
            return "tim";
        }

        return "tim ORDER BY naziv";
    }

    @Override
    public List napuniListuObjekata(ResultSet rs) {
        List<Tim> lt = new ArrayList<>();
        try {

            while (rs.next()) {
                if (rs.getInt("sifratima") != 1) {
                    lt.add(new Tim(rs.getInt("sifratima"), rs.getString("naziv"), rs.getInt("godinaosnivanja"), rs.getString("grad"), rs.getString("hala")));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tim.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lt;
    }

    @Override
    public DomenskiObjekat vratiObjekat(ResultSet tabela) {
        return null;
    }


    @Override
    public int vratiID(ResultSet rs) {
        int max = 0;
        try {
            while (rs.next()) {
                max = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tim.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max;
    }

}
