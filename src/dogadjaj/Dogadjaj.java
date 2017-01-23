/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogadjaj;

import osoba.Organizator;
import osoba.Ucesnik;
import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author raka
 */
public class Dogadjaj implements Serializable, Comparable<Dogadjaj> {

    private String nazivDogadjaja;
    private Calendar datumPocetkaDogadjaja;
    private Calendar vrijemePocetkaDogadjaja;
    private Calendar vrijemeKrajaDogadjaja;
    private String opisDogadjaja;
    private Organizator organizatorDogadjaja;
    private File fajlUzDogadjaj;
    private ArrayList<Ucesnik> ucesniciDogadjaja;
    private String vrstaDogadjaja = "";
    private ArrayList<Dogadjaj> povezaniDogadjaji;

    public Dogadjaj() {
    }

    public Dogadjaj(String nazivDogadjaja, Calendar datumPocetkaDogadjaja, Calendar vrijemePocetkaDogadjaja, Calendar vrijemeKrajaDogadjaja, String opisDogadjaja, Organizator organizatorDogadjaja, File fajlUzDogadjaj, ArrayList<Ucesnik> ucesniciDogadjaja, String vrstaDogadjaja, ArrayList<Dogadjaj> povezaniDogadjaji) {
        this.nazivDogadjaja = nazivDogadjaja;
        this.datumPocetkaDogadjaja = datumPocetkaDogadjaja;
        this.vrijemePocetkaDogadjaja = vrijemePocetkaDogadjaja;
        this.vrijemeKrajaDogadjaja = vrijemeKrajaDogadjaja;
        this.opisDogadjaja = opisDogadjaja;
        this.organizatorDogadjaja = organizatorDogadjaja;
        this.fajlUzDogadjaj = fajlUzDogadjaj;
        this.ucesniciDogadjaja = ucesniciDogadjaja;
        this.vrstaDogadjaja = vrstaDogadjaja;
        this.povezaniDogadjaji = povezaniDogadjaji;
    }

    public String getNazivDogadjaja() {
        return nazivDogadjaja;
    }

    public void setNazivDogadjaja(String nazivDogadjaja) {
        this.nazivDogadjaja = nazivDogadjaja;
    }

    public File getFajlUzDogadjaj() {
        return fajlUzDogadjaj;
    }

    public void setFajlUzDogadjaj(File fajlUzDogadjaj) {
        this.fajlUzDogadjaj = fajlUzDogadjaj;
    }

    public Calendar getDatumPocetkaDogadjaja() {
        return datumPocetkaDogadjaja;
    }

    public void setDatumPocetkaDogadjaja(Calendar datumPocetkaDogadjaja) {
        this.datumPocetkaDogadjaja = datumPocetkaDogadjaja;
    }

    public Calendar getVrijemePocetkaDogadjaja() {
        return vrijemePocetkaDogadjaja;
    }

    public void setVrijemePocetkaDogadjaja(Calendar vrijemePocetkaDogadjaja) {
        this.vrijemePocetkaDogadjaja = vrijemePocetkaDogadjaja;
    }

    public Calendar getVrijemeKrajaDogadjaja() {
        return vrijemeKrajaDogadjaja;
    }

    public void setVrijemeKrajaDogadjaja(Calendar vrijemeKrajaDogadjaja) {
        this.vrijemeKrajaDogadjaja = vrijemeKrajaDogadjaja;
    }

    public String getOpisDogadjaja() {
        return opisDogadjaja;
    }

    public void setOpisDogadjaja(String opisDogadjaja) {
        this.opisDogadjaja = opisDogadjaja;
    }

    public Organizator getOrganizatorDogadjaja() {
        return organizatorDogadjaja;
    }

    public void setOrganizatorDogadjaja(Organizator organizatorDogadjaja) {
        this.organizatorDogadjaja = organizatorDogadjaja;
    }

    public ArrayList<Ucesnik> getUcesniciDogadjaja() {
        return ucesniciDogadjaja;
    }

    public void setUcesniciDogadjaja(ArrayList<Ucesnik> ucesniciDogadjaja) {
        this.ucesniciDogadjaja = ucesniciDogadjaja;
    }

    public String getVrstaDogadjaja() {
        return vrstaDogadjaja;
    }

    public ArrayList<Dogadjaj> getPovezaniDogadjaji() {
        return povezaniDogadjaji;
    }

    public void setPovezaniDogadjaji(ArrayList<Dogadjaj> povezaniDogadjaji) {
        this.povezaniDogadjaji = povezaniDogadjaji;
    }
    
    @Override
    public String toString(){
        return this.getNazivDogadjaja();
    }
    
    @Override
    public int compareTo(Dogadjaj o) {
        return this.getDatumPocetkaDogadjaja().compareTo(o.getDatumPocetkaDogadjaja());
    }
    
    public String toStringZaUpisUFajlDogadjaja(){
        String dogadjaj;
        Calendar kalendar = Calendar.getInstance();
        Calendar kalendarVrijemeKraja = Calendar.getInstance();
        Calendar kalendarVrijemePocetka = Calendar.getInstance();
        SimpleDateFormat formatDatuma = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat formatVremena = new SimpleDateFormat("HH:mm");
        
        kalendar = this.getDatumPocetkaDogadjaja();
        kalendarVrijemePocetka = this.getVrijemePocetkaDogadjaja();
        kalendarVrijemeKraja = this.getVrijemeKrajaDogadjaja();
        
        String formatiranDatum = formatDatuma.format(kalendar.getTime());
        String formatiranoVrijemePocetka = formatVremena.format(kalendarVrijemePocetka.getTime());
        String formatiranoVrijemeKraja = formatVremena.format(kalendarVrijemeKraja.getTime());
        
        dogadjaj = this.vrstaDogadjaja + "," + this.nazivDogadjaja + "," + formatiranDatum + "," + formatiranoVrijemePocetka + "," + formatiranoVrijemeKraja + "," + this.opisDogadjaja;
        System.out.println("Fotmatiran  dogadjaj za upis u fajl" + dogadjaj);
        return dogadjaj;
    }

}
