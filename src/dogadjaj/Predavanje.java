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
import osoba.Predavac;

/**
 *
 * @author raka
 */
public class Predavanje extends Dogadjaj{
    
    private String temaPredavanja;
    private Predavac predavacPredavanje;
    private String sadrzajPredavanja;
   

    
    public Predavanje() {
    }

    
    
    public Predavanje(String temaPredavanja, Predavac predavacPredavanje, String sadrzajPredavanja, String nazivDogadjaja, Calendar datumPocetkaDogadjaja, Calendar vrijemePocetkaDogadjaja, Calendar vrijemeKrajaDogadjaja, String opisDogadjaja, Organizator organizatorDogadjaja, File fajlUzDogadjaj, ArrayList<Ucesnik> ucesniciDogadjaja, String vrstaDogadjaja) {
        super(nazivDogadjaja, datumPocetkaDogadjaja, vrijemePocetkaDogadjaja, vrijemeKrajaDogadjaja, opisDogadjaja, organizatorDogadjaja, fajlUzDogadjaj, ucesniciDogadjaja, vrstaDogadjaja);
        this.temaPredavanja = temaPredavanja;
        this.predavacPredavanje = predavacPredavanje;
        this.sadrzajPredavanja = sadrzajPredavanja;
    }

    

    

    public String getTemaPredavanja() {
        return temaPredavanja;
    }

    public void setTemaPredavanja(String temaPredavanja) {
        this.temaPredavanja = temaPredavanja;
    }

    public Predavac getPredavacPredavanje() {
        return predavacPredavanje;
    }

    public void setPredavacPredavanje(Predavac predavacPredavanje) {
        this.predavacPredavanje = predavacPredavanje;
    }

    public String getSadrzajPredavanja() {
        return sadrzajPredavanja;
    }

    public void setSadrzajPredavanja(String sadrzajPredavanja) {
        this.sadrzajPredavanja = sadrzajPredavanja;
    }

    
    
    
    
}
