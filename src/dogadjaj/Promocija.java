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
public class Promocija extends  Dogadjaj{
    
    private String proizvod;
    private String kompanija;
 

    public Promocija() {
    }

    

    public Promocija(String proizvod, String kompanija, String nazivDogadjaja, Calendar datumPocetkaDogadjaja, Calendar vrijemePocetkaDogadjaja, Calendar vrijemeKrajaDogadjaja, String opisDogadjaja, Organizator organizatorDogadjaja, File fajlUzDogadjaj, ArrayList<Ucesnik> ucesniciDogadjaja, String vrstaDogadjaja) {
        super(nazivDogadjaja, datumPocetkaDogadjaja, vrijemePocetkaDogadjaja, vrijemeKrajaDogadjaja, opisDogadjaja, organizatorDogadjaja, fajlUzDogadjaj, ucesniciDogadjaja, vrstaDogadjaja);
        this.proizvod = proizvod;
        this.kompanija = kompanija;
    }

    public String getProizvod() {
        return proizvod;
    }

    public void setProizvod(String proizvod) {
        this.proizvod = proizvod;
    }

    public String getKompanija() {
        return kompanija;
    }

    public void setKompanija(String kompanija) {
        this.kompanija = kompanija;
    }

}

    
