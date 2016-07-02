/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Marko
 */
public class TipUcinka implements Serializable{
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
        if(obj == null) return false;
        if(!(obj instanceof TipUcinka)) return false;
        
        return ((TipUcinka)obj).getNaziv().equals(this.getNaziv());
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
}
