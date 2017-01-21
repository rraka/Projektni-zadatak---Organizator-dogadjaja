/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osoba;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author raka
 */
public class NapomenaOrganizator implements Serializable{
    
    private Calendar datumKreiranja;
    private String tekstualniSadrzaj;

    public NapomenaOrganizator(Calendar datumKreiranja, String tekstualniSadrzaj) {
        this.datumKreiranja = datumKreiranja;
        this.tekstualniSadrzaj = tekstualniSadrzaj;
    }

    public Calendar getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Calendar datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public String getTekstualniSadrzaj() {
        return tekstualniSadrzaj;
    }

    public void setTekstualniSadrzaj(String tekstualniSadrzaj) {
        this.tekstualniSadrzaj = tekstualniSadrzaj;
    }

   
    
    
    
    
}
