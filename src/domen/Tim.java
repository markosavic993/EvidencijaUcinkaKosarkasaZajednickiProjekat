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
public class Tim implements Serializable{
    private int sifraTima;
    private String naziv;
    private int godinaOsnivanja;
    private String grad;
    private String nazivHale;

    public Tim() {
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

    @Override
    public String toString() {
        if(this.naziv.startsWith("Slobod")) return naziv;
        return this.naziv + " ( " + this.grad + " )";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Tim)) return false;
        
        return ((Tim)obj).getNaziv().equals(this.getNaziv()) && ((Tim)obj).getGrad().equals(this.grad);
    }
    
    
    
}
