/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
public class Utakmica implements Serializable, DomenskiObjekat{
    private int idUtakmice;
    private Date datumOdigravanja;
    private Tim domacin;
    private Tim gost;
    private int poeniDomacin;
    private int poeniGost;

    private int uslov;
    
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

    public int getUslov() {
        return uslov;
    }

    public void setUslov(int uslov) {
        this.uslov = uslov;
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

    @Override
    public String vratiDeoZaINSERT(int i) {
        return "utakmica(id, datum, domacin, gost, poeni_domacin, poeni_gost)";
    }

    @Override
    public String vratiVrednostiZaINSERT(int i) {
        return String.format("(%s, '%s', %s, %s, %s, %s)", this.idUtakmice, new java.sql.Date(this.getDatumOdigravanja().getTime()), this.getDomacin().getSifraTima(), this.getGost().getSifraTima(), 0, 0);
    }

    @Override
    public String vratiImeTabele() {
        return "utakmica";
    }

    @Override
    public String vratiVrednostiZaSET() {
        return "poeni_domacin = "+this.getPoeniDomacin()+", poeni_gost = "+this.poeniGost;
    }

    @Override
    public String vratiVrednostiZaWHERE() {
        return "id = " + this.getIdUtakmice();
    }

    @Override
    public String vratiDeoZaSELECT() {
        if(uslov == Konstante.VRATI_ID_UTAKMICE) {
            return "MAX(id)";
        } 
        
        if(uslov == Konstante.VRATI_BROJ_POENA_DOMACINA_I_GOSTA) {
            return "poeni_domacin, poeni_gost";
        }
        
        return "u.id, u.datum, t.sifratima, t.naziv, t.godinaosnivanja, t.grad, t.hala, t2.sifratima AS sifra, t2.naziv AS n, t2.godinaosnivanja AS godina, t2.grad AS g, t2.hala AS h, u.poeni_domacin, u.poeni_gost";
    }

    @Override
    public String vratiDeoZaFROM() {
        if(uslov == Konstante.VRATI_ID_UTAKMICE) {
            return "utakmica";
        } 
        
        if(uslov == Konstante.VRATI_BROJ_POENA_DOMACINA_I_GOSTA) {
            return "utakmica";
        }
       return "utakmica u JOIN tim t ON (u.domacin = t.sifratima) JOIN tim t2 ON (u.gost = t2.sifratima)";
    }

    @Override
    public List napuniListuObjekata(ResultSet rs) {
        List<Utakmica> lu = new ArrayList<>();
        try {
            
            while (rs.next()) {
                Tim d = new Tim(rs.getInt("sifratima"), rs.getString("naziv"), rs.getInt("godinaosnivanja"), rs.getString("grad"), rs.getString("hala"));
                Tim g = new Tim(rs.getInt("sifra"), rs.getString("n"), rs.getInt("godina"), rs.getString("g"), rs.getString("h"));
                lu.add(new Utakmica(rs.getInt("id"), rs.getDate("datum"), d, g, rs.getInt("poeni_domacin"), rs.getInt("poeni_gost")));

            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Utakmica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lu;
    }

    @Override
    public DomenskiObjekat vratiObjekat(ResultSet rs) {
        if(uslov == Konstante.VRATI_BROJ_POENA_DOMACINA_I_GOSTA) {
            try {
                return new Utakmica(rs.getInt("id"), rs.getDate("datum"), new Tim(), new Tim(), rs.getInt("poeni_domacin"), rs.getInt("poeni_gost"));
            } catch (SQLException ex) {
                Logger.getLogger(Utakmica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
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
            Logger.getLogger(Utakmica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max;
    }
    
    
}
