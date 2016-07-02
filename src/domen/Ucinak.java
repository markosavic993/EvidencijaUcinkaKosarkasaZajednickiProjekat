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
public class Ucinak implements Serializable{

    private Kosarkas kosarkas;
    private Utakmica utakmica;
    private TipUcinka tipUcinka;
    private int vrednost;
    
    public Ucinak() {
    }
    
    public Ucinak(Kosarkas kosarkas, Utakmica utakmica, TipUcinka tipUcinka, int vrednost) {
        this.kosarkas = kosarkas;
        this.utakmica = utakmica;
        this.tipUcinka = tipUcinka;
        this.vrednost = vrednost;
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
    
}
