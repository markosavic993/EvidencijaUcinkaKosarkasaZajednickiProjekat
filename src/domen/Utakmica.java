/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Marko
 */
public class Utakmica implements Serializable{
    private int idUtakmice;
    private Date datumOdigravanja;
    private Tim domacin;
    private Tim gost;
    private int poeniDomacin;
    private int poeniGost;

    public Utakmica() {
    }

    public Utakmica(int idUtakmice, Date datumOdigravanja, Tim domacin, Tim gost) {
        this.idUtakmice = idUtakmice;
        this.datumOdigravanja = datumOdigravanja;
        this.domacin = domacin;
        this.gost = gost;
    }

    public Utakmica(int idUtakmice, Date datumOdigravanja, Tim domacin, Tim gost, int poeniDomacin, int poeniGost) {
        this.idUtakmice = idUtakmice;
        this.datumOdigravanja = datumOdigravanja;
        this.domacin = domacin;
        this.gost = gost;
        this.poeniDomacin = poeniDomacin;
        this.poeniGost = poeniGost;
    }

    public int getPoeniDomacin() {
        return poeniDomacin;
    }

    public void setPoeniDomacin(int poeniDomacin) {
        this.poeniDomacin = poeniDomacin;
    }

    public int getPoeniGost() {
        return poeniGost;
    }

    public void setPoeniGost(int poeniGost) {
        this.poeniGost = poeniGost;
    }
    
    

    public int getIdUtakmice() {
        return idUtakmice;
    }

    public void setIdUtakmice(int idUtakmice) {
        this.idUtakmice = idUtakmice;
    }

    public Date getDatumOdigravanja() {
        return datumOdigravanja;
    }

    public void setDatumOdigravanja(Date datumOdigravanja) {
        this.datumOdigravanja = datumOdigravanja;
    }

    public Tim getDomacin() {
        return domacin;
    }

    public void setDomacin(Tim domacin) {
        this.domacin = domacin;
    }

    public Tim getGost() {
        return gost;
    }

    public void setGost(Tim gost) {
        this.gost = gost;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Utakmica)) return false;
        
        return ((Utakmica)obj).getIdUtakmice() == this.getIdUtakmice();
    }

    @Override
    public String toString() {
        //return domacin + " - " + gost;
        return ispisi();
    }
    
    public String ispisi() {
        String datum = new SimpleDateFormat("dd.MM.yyyy.").format(datumOdigravanja);
        return domacin + " - " + gost + " ( " + datum + " )" ;
    }
    
    
}
