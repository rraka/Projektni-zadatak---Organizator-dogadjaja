/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogadjaj;

import osoba.Organizator;
import osoba.Ucesnik;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author raka
 */
public class Izlozba extends Dogadjaj {
    
    private String temaIzlozbe;
    private String autorIzlozbe;
   

    public Izlozba() {
    }
    
    public Izlozba(String temaIzlozbe, String autorIzlozbe, String nazivDogadjaja, Calendar datumPocetkaDogadjaja, Calendar vrijemePocetkaDogadjaja, Calendar vrijemeKrajaDogadjaja, String opisDogadjaja, Organizator organizatorDogadjaja, File fajlUzDogadjaj, ArrayList<Ucesnik> ucesniciDogadjaja, String vrstaDogadjaja) {
        super(nazivDogadjaja, datumPocetkaDogadjaja, vrijemePocetkaDogadjaja, vrijemeKrajaDogadjaja, opisDogadjaja, organizatorDogadjaja, fajlUzDogadjaj, ucesniciDogadjaja, vrstaDogadjaja);
        this.temaIzlozbe = temaIzlozbe;
        this.autorIzlozbe = autorIzlozbe;
    }

    public String getTemaIzlozbe() {
        return temaIzlozbe;
    }

    public void setTemaIzlozbe(String temaIzlozbe) {
        this.temaIzlozbe = temaIzlozbe;
    }

    public String getAutorIzlozbe() {
        return autorIzlozbe;
    }

    public void setAutorIzlozbe(String autorIzlozbe) {
        this.autorIzlozbe = autorIzlozbe;
    }

    
    
    
    
    
}
