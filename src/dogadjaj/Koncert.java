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
public class Koncert extends Dogadjaj{
        
    private String izvodjacKoncert;
    private String trajanjeKoncerta;
  

    
    
    public Koncert() {
    }

    
    public Koncert(String izvodjacKoncert, String trajanjeKoncerta, String nazivDogadjaja, Calendar datumPocetkaDogadjaja, Calendar vrijemePocetkaDogadjaja, Calendar vrijemeKrajaDogadjaja, String opisDogadjaja, Organizator organizatorDogadjaja, File fajlUzDogadjaj, ArrayList<Ucesnik> ucesniciDogadjaja, String vrstaDogadjaja, ArrayList<Dogadjaj> povezaniDogadjaji) {
        super(nazivDogadjaja, datumPocetkaDogadjaja, vrijemePocetkaDogadjaja, vrijemeKrajaDogadjaja, opisDogadjaja, organizatorDogadjaja, fajlUzDogadjaj, ucesniciDogadjaja, vrstaDogadjaja, povezaniDogadjaji);
        this.izvodjacKoncert = izvodjacKoncert;
        this.trajanjeKoncerta = trajanjeKoncerta;
        
    }

  

    public String getIzvodjacKoncert() {
        return izvodjacKoncert;
    }

    public void setIzvodjacKoncert(String izvodjacKoncert) {
        this.izvodjacKoncert = izvodjacKoncert;
    }

    public String getTrajanjeKoncerta() {
        return trajanjeKoncerta;
    }

    public void setTrajanjeKoncerta(String trajanjeKoncerta) {
        this.trajanjeKoncerta = trajanjeKoncerta;
    }

   
    
    
}
