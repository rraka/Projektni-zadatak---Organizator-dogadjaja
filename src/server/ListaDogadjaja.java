/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dogadjaj.Dogadjaj;
import dogadjaj.Izlozba;
import dogadjaj.Koncert;
import dogadjaj.OstaliDogadjaji;
import dogadjaj.Predavanje;
import dogadjaj.Promocija;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import osoba.NapomenaOrganizator;
import osoba.Organizator;
import osoba.Posjetilac;
import osoba.Predavac;
import osoba.Ucesnik;

/**
 *
 * @author raka
 */
public class ListaDogadjaja implements Serializable {

    private static ArrayList<Dogadjaj> dogadjaji;
    private  static ArrayList<Posjetilac> sviPosjetioci;
    

    public ListaDogadjaja() {
        
        dogadjaji = new ArrayList<>();
        sviPosjetioci = new ArrayList<>();
    }

    public ArrayList<Dogadjaj> getDogadjaji() {
        return dogadjaji;
    }

    public void setDogadjaji(ArrayList<Dogadjaj> dogadjaji) {
        this.dogadjaji = dogadjaji;
    }
    
    
    
    
    public static void main(String[] args) {
        ListaDogadjaja listaDogadjaja = new ListaDogadjaja();
        //kreirajPosjetioce();
        //sviPosjetioci = deSerijalizacija("posjetioci");
        napraviDogadjaje();//napravi pocetne dogadjaje za popunu tabele i ispitivanje funkcionalnosti
    }
    
    
    //kreiranje posjetioca iz CSV fajla
    public static void kreirajPosjetioce() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("posjetioci.csv"));
            ArrayList<Posjetilac> sviPosjetioci = new ArrayList<>();
            String unos;
            Posjetilac posjetilac;
            
            while ((unos = in.readLine()) != null) {
                String[] unosPosjetilac = unos.split(",");
                String ime = unosPosjetilac[0];
                String prezime = unosPosjetilac[1];
                String adresa = unosPosjetilac[2];
                String telefon = unosPosjetilac[3];
                String email = unosPosjetilac[4];
                
                posjetilac = new Posjetilac(adresa, telefon, email, ime, prezime);
                sviPosjetioci.add(posjetilac);
            }
            
            System.out.println(sviPosjetioci);
            serijalizacija(sviPosjetioci);
            System.out.println(sviPosjetioci.get(0).getPrezimeOsobe() + ", " + sviPosjetioci.get(0).getTelefonPosjetioca());
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void napraviDogadjaje() {
        // Date datum = new Date();
        //datumi i vremena pocetnih dogadjaja
        Calendar kalendar = Calendar.getInstance();
        Calendar kalendarr = Calendar.getInstance();
        Calendar kalendar1 = Calendar.getInstance();
        Calendar kalendar11 = Calendar.getInstance();
        Calendar kalendar2 = Calendar.getInstance();
        Calendar kalendar22 = Calendar.getInstance();
        Calendar kalendar3 = Calendar.getInstance();
        Calendar kalendar33 = Calendar.getInstance();
        Calendar kalendar4 = Calendar.getInstance();
        Calendar kalendar44 = Calendar.getInstance();

        kalendar.set(2017, 5, 2, 13, 30);
        kalendarr.set(2017, 5, 2, 15, 30);//vrijeme kraja dogadjaja
        kalendar1.set(2017, 5, 2, 16, 00);
        kalendar11.set(2017, 5, 2, 18, 30);//vrijeme kraja dogadjaja
        kalendar2.set(2015, 3, 5, 12, 30);
        kalendar22.set(2015, 3, 5, 13, 45);//vrijeme kraja dogadjaja
        kalendar3.set(2012, 2, 8, 14, 30);
        kalendar33.set(2012, 2, 8, 16, 15);//vrijeme kraja dogadjaja
        kalendar4.set(2014, 10, 11, 9, 0);
        kalendar44.set(2014, 10, 11, 10, 30);//vrijeme kraja dogadjaja
        
        //niz napomena
        ArrayList<NapomenaOrganizator> nizNapomena1 = new ArrayList<>();
        ArrayList<NapomenaOrganizator> nizNapomena2 = new ArrayList<>();
        NapomenaOrganizator napomena1 = new NapomenaOrganizator(kalendar1, "tekstualni sadrzaj napomena 1");
        NapomenaOrganizator napomena2 = new NapomenaOrganizator(kalendar2, "tekstualni sadrzaj napomena 2");
        NapomenaOrganizator napomena3 = new NapomenaOrganizator(kalendar3, "tekstualni sadrzaj napomena 3");
        NapomenaOrganizator napomena4 = new NapomenaOrganizator(kalendar4, "tekstualni sadrzaj napomena 4");
        nizNapomena1.add(napomena1);
        nizNapomena1.add(napomena2);
        nizNapomena1.add(napomena3);
        nizNapomena1.add(napomena4);
        nizNapomena2.add(napomena1);
        nizNapomena2.add(napomena2);
        
        //predavaci, ucesnici i orgaizatori
        ArrayList<Predavac> sviPredavaci = new ArrayList<>();
        Predavac predavac1 = new Predavac("Marko", "Dragusic");
        Predavac predavac2 = new Predavac("Dragusa", "Markovic");
        Predavac predavac3 = new Predavac("Zeljko", "Obradovic");
        Predavac predavac4 = new Predavac("Igor", "Kokoskov");
        sviPredavaci.add(predavac1);
        sviPredavaci.add(predavac2);
        sviPredavaci.add(predavac3);
        sviPredavaci.add(predavac4);
        serijalizacija(sviPredavaci);
        
        
        ArrayList<Ucesnik> sviUcesnici = new ArrayList<>();
        Ucesnik ucesnik1 = new Ucesnik("Euroleague", "Nando", "deColo");
        Ucesnik ucesnik2 = new Ucesnik("ABA league", "Novica", "Velickovic");
        Ucesnik ucesnik3 = new Ucesnik("ACB league", "Nemanja", "Nedovic");
        Ucesnik ucesnik4 = new Ucesnik("VTB league", "Stefan", "Markovic");
        sviUcesnici.add(ucesnik1);
        sviUcesnici.add(ucesnik2);
        sviUcesnici.add(ucesnik3);
        sviUcesnici.add(ucesnik4);
        serijalizacija(sviUcesnici);
        
        
        ArrayList<Organizator> sviOrganizatori = new ArrayList<>();
        Organizator organizator1 = new Organizator("051111222", "org1@gmail.com", nizNapomena1,  "Boban", "Marjanovic");
        Organizator organizator2 = new Organizator("051556644", "org2@gmail.com", nizNapomena2, "Nikola", "Jokic");
        sviOrganizatori.add(organizator1);
        sviOrganizatori.add(organizator2);
        serijalizacija(sviOrganizatori);
        
//        Calendar vrijemePocetak = Calendar.getInstance();
//        Calendar vrijemeKraj = Calendar.getInstance();
//        datum.add(Calendar.DATE, 0);
//        
//        vrijemePocetak.set(10, 10, 2010, 10, 20);
//        vrijemeKraj.set(5, 5, 2015, 15, 35);
//        
//        SimpleDateFormat formatDatum = new SimpleDateFormat("dd.MM.yyyy");
//        SimpleDateFormat formatVrijemePocetak = new SimpleDateFormat("HH:mm");
//        SimpleDateFormat formatVrijemeKraj = new SimpleDateFormat("HH:mm");
//        //System.out.println(datum.getTime());
//// Output "Wed Sep 26 14:23:28 EST 2012"
//        String formatiranDatum = formatDatum.format(datum.getTime());
//        String formatiranVrijemePocetka = formatVrijemePocetak.format(vrijemePocetak.getTime());
//        String formatiranVrijemeKraja = formatVrijemeKraj.format(vrijemeKraj.getTime());
//        System.out.println(formatiranDatum + formatiranVrijemePocetka + formatiranVrijemeKraja);
// Output "2012-09-26"
    System.out.println("Prije kreiranja prve izlozbe");
        Izlozba izlozba1 = new Izlozba("TEMA Likovna izlozba", "Marko Markovic", "Izlozba 1", kalendar2, kalendar22,
                kalendar22, "opis dogadjaja 1", organizator1,
                null, null, "Izlozba"); //organizator, fajl, ucesnici = null

        Izlozba izlozba2 = new Izlozba("TEMA Izlozba 2", "Janko Jankovic", "Izlozba 2", kalendar, kalendar,
                kalendarr, "opis dogadjaja 1", organizator1,
                null, null, "Izlozba"); //organizator, fajl, ucesnici = null

        Predavanje predavanje1 = new Predavanje("TEMA predavanja1", predavac1,
                "Sadrzaj predavanja1", "Naziv dogadjaja - predavanje1",
                kalendar, kalendar,
                kalendarr, "opis dogadjaja-predavanje1",
                organizator1, null,
                null, "Predavanje");

        Predavanje predavanje2 = new Predavanje("TEMA predavanja2", predavac2,
                "Sadrzaj predavanja1", "Naziv dogadjaja - predavanje1",
                kalendar1, kalendar1,
                kalendar11, "opis dogadjaja-predavanje1",
                organizator1, null,
                null, "Predavanje");

        OstaliDogadjaji ostaliDogadjaji1 = new OstaliDogadjaji("Naziv ostali dogadjaji1", kalendar3, kalendar3,
                kalendar33, "Opis ostali dogadjaji1", organizator1,
                null, null, "Pstali dogadjaji");

        OstaliDogadjaji ostaliDogadjaji2 = new OstaliDogadjaji("Naziv ostali dogadjaji2", kalendar1, kalendar1,
                kalendar11, "Opis ostali dogadjaji2", organizator2,
                null, null, "Ostali dogadjaji");

        Koncert koncert1 = new Koncert("Izvodjac - Latrell Sprewell", "130", "Naziv dogadjaja - kocert1", kalendar,
                kalendar, kalendarr, "Opis dogadjaja kalendar 1", organizator2,
                null, null, "Koncert");

        Koncert koncert2 = new Koncert("Izvodjac - Panny Hardaway", "90", "Naziv dogadjaja - kocert2", kalendar1,
                kalendar1, kalendar11, "Opis dogadjaja kalendar 2", organizator1,
                null, null, "Koncert");

        Promocija promocija1 = new Promocija("proizvod", "kompanija", "naziv dogadjaja Promocija1", kalendar4, kalendar4,
                kalendar44, "opis dogadjaja promocija1", organizator2,
                null, null, "Promocija");

        Promocija promocija2 = new Promocija("proizvod2", "kompanija2", "naziv dogadjaja Promocija2", kalendar1, kalendar1,
                kalendar11, "opis dogadjaja promocija2", organizator1,
                null, null, "Promocija");

        Promocija promocija3 = new Promocija("proizvod3", "kompanija3", "naziv dogadjaja Promocija3", kalendar4, kalendar4,
                kalendar44, "opis dogadjaja promocija3", organizator1,
                null, null, "Promocija");

        Promocija promocija4 = new Promocija("proizvod4", "kompanija4", "naziv dogadjaja Promocija4", kalendar, kalendar,
                kalendarr, "opis dogadjaja promocija4", organizator1,
                null, null, "Promocija");

        dogadjaji.add(izlozba1);
        dogadjaji.add(izlozba2);
        dogadjaji.add(ostaliDogadjaji1);
        dogadjaji.add(ostaliDogadjaji2);
        dogadjaji.add(koncert1);
        dogadjaji.add(koncert2);
        dogadjaji.add(izlozba1);
        dogadjaji.add(izlozba2);
        dogadjaji.add(predavanje1);
        dogadjaji.add(predavanje2);
        dogadjaji.add(promocija1);
        dogadjaji.add(promocija2);
        dogadjaji.add(promocija3);
        dogadjaji.add(promocija4);

        serijalizacija(dogadjaji); //serijalizujemo napravljenje dogadjaje
        System.out.println("poslije serijalizacije");

        for (int i = 0; i < dogadjaji.size(); i++) {
            System.out.println(dogadjaji.get(i));
        }

    }

    public static <T> void serijalizacija(ArrayList<T> zaSerijalizaciju) {
        try {

            if (zaSerijalizaciju.get(0) instanceof Organizator) {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("organizatori.ser")));
                oos.writeObject(zaSerijalizaciju);
                oos.close();
            } else if (zaSerijalizaciju.get(0) instanceof Posjetilac) {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("posjetioci.ser")));
                oos.writeObject(zaSerijalizaciju);
                oos.close();
            } else if (zaSerijalizaciju.get(0) instanceof Predavac) {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("predavaci.ser")));
                oos.writeObject(zaSerijalizaciju);
                oos.close();
            } else if (zaSerijalizaciju.get(0) instanceof Ucesnik) {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("ucesnici.ser")));
                oos.writeObject(zaSerijalizaciju);
                oos.close();
            } else if (zaSerijalizaciju.get(0) instanceof Dogadjaj) {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("listaDogadjaja.ser")));
                oos.writeObject(zaSerijalizaciju);
                oos.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("ZAVRSENA SERIJALIZACIJA!!!");
    }

    public static <T> ArrayList<T> deSerijalizacija(String objekat) {
        ArrayList<T> deSerijalizovanaLista = null;
        try {
            if (objekat.equals("dogadjaji")) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("listaDogadjaja.ser")));
                deSerijalizovanaLista = (ArrayList<T>) ois.readObject();
                ois.close();
            }
            else if (objekat.equals("ucesnici")) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("ucesnici.ser")));
                deSerijalizovanaLista = (ArrayList<T>) ois.readObject();
                ois.close();
            }
            else if (objekat.equals("predavaci")) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("predavaci.ser")));
                deSerijalizovanaLista = (ArrayList<T>) ois.readObject();
                ois.close();
            }
            if (objekat.equals("posjetioci")) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("posjetioci.ser")));
                deSerijalizovanaLista = (ArrayList<T>) ois.readObject();
                ois.close();
            }
            else if (objekat.equals("organizatori")) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("organizatori.ser")));
                deSerijalizovanaLista = (ArrayList<T>) ois.readObject();
                ois.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return deSerijalizovanaLista;
    }

    
    
    
}
