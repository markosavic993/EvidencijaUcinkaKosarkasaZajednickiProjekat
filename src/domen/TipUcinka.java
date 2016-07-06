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
public class TipUcinka implements Serializable, DomenskiObjekat {

    private String naziv;
    private String opis;

    public TipUcinka() {
    }

    public TipUcinka(String naziv, String opis) {
        this.naziv = naziv;
        this.opis = opis;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof TipUcinka)) {
            return false;
        }

        return ((TipUcinka) obj).getNaziv().equals(this.getNaziv());
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiDeoZaINSERT(int i) {
        return "tipucinka(naziv, opis)";
    }

    @Override
    public String vratiVrednostiZaINSERT(int i) {
        return String.format("(%s, %s)", "'"+this.naziv+"'", "'"+this.opis+"'");
    }

    @Override
    public String vratiImeTabele() {
        return "tipucinka";
    }

    @Override
    public String vratiVrednostiZaSET() {
        return "";
    }

    @Override
    public String vratiVrednostiZaWHERE() {
        return String.format("naziv = '%s'", this.naziv);
    }

    @Override
    public String vratiDeoZaSELECT() {
        return "*";
    }

    @Override
    public String vratiDeoZaFROM() {
        return vratiImeTabele();
    }

    @Override
    public List napuniListuObjekata(ResultSet rs) {
        List<TipUcinka> ltu = new ArrayList<>();
        try {
            while (rs.next()) {
                ltu.add(new TipUcinka(rs.getString("naziv"), rs.getString("opis")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipUcinka.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ltu;
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
