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
public class Korisnik  implements Serializable, DomenskiObjekat {

    private String username;
    private String password;
    private String mail;

    public Korisnik() {
    }

    public Korisnik(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Korisnik(String username, String password, String mail) {
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Korisnik)) {
            return false;
        }
        return ((Korisnik) obj).getUsername().equals(this.getUsername()) && ((Korisnik) obj).getPassword().equals(this.getPassword());
    }

    @Override
    public String vratiDeoZaINSERT(int i) {
        return "korisnik(mail, username, password)";
    }

    @Override
    public String vratiVrednostiZaINSERT(int i) {
        return String.format("('%s', '%s', '%s')", this.mail, this.username, this.password);
    }

    @Override
    public String vratiImeTabele() {
        return "korisnik";
    }

    @Override
    public String vratiVrednostiZaSET() {
        return String.format("password = '%s'", this.password);
    }

    @Override
    public String vratiVrednostiZaWHERE() {
        return String.format("mail = '%s'", this.mail);
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
        List<Korisnik> lk = new ArrayList<>();
        try {
            while (rs.next()) {
                lk.add(new Korisnik(rs.getString("username"), rs.getString("password"), rs.getString("mail")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Korisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lk;
    }

    @Override
    public DomenskiObjekat vratiObjekat(ResultSet tabela) {
        return null;
    }

    @Override
    public int vratiID(ResultSet tabela) {
        return -1;
    }

}
