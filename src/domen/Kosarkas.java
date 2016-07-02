/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Marko
 */
public class Kosarkas implements Serializable{
    private String ime;
    private String prezime;
    private String jmbg;
    private Date datumRodjenja;
    private String pozicija;
    private int brojNaDresu;
    private Tim timZaKojiNastupa;
    private int visina;
    private int tezina;

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

    @Override
    public String toString() {
        return prezime + " " + ime + ", " + timZaKojiNastupa;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Kosarkas)) return false;
        
        return ((Kosarkas)obj).getJmbg().equals(this.jmbg);
    }
    
}
