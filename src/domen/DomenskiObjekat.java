/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Marko
 */
public interface DomenskiObjekat {

    public String vratiDeoZaINSERT(int i);

    public String vratiVrednostiZaINSERT(int i);

    public String vratiImeTabele();

    public String vratiVrednostiZaSET();

    public String vratiVrednostiZaWHERE();

    public String vratiDeoZaSELECT();

    public String vratiDeoZaFROM();

    public List napuniListuObjekata(ResultSet tabela);
    
    public DomenskiObjekat vratiObjekat(ResultSet tabela);
    
    public int vratiID(ResultSet tabela);

}
