/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dogadjaj.Dogadjaj;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import osoba.Organizator;
import osoba.Osoba;
import osoba.Posjetilac;
import osoba.Predavac;
import osoba.Ucesnik;
import poruka.Poruka;

/**
 *
 * @author raka
 */
class OrganizatorDogadjajaServerNit extends Thread {

    private Socket soket;
    private  ObjectInputStream ois;
    private  ObjectOutputStream oos;
    private static ListaDogadjaja ListaDogadjaja;
    private static ArrayList<Dogadjaj> sviDogadjaji;
    private static ArrayList<Posjetilac> sviPosjetioci;
    private static ArrayList<Organizator> sviOrganizatori;
    private static ArrayList<Ucesnik> sviUcesnici;
    private static ArrayList<Predavac> sviPredavaci;
    // private static ArrayList<Osoba> osobe;

    public OrganizatorDogadjajaServerNit(Socket soket) {
        try {
            this.soket = soket;
            ois = new ObjectInputStream(soket.getInputStream());
            oos = new ObjectOutputStream(soket.getOutputStream());
            //sviDogadjaji = OrganizatorDogadjajaServer.getSviDogadjaji();
            start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {

        try {
            sviPosjetioci = ListaDogadjaja.deSerijalizacija("posjetioci");
            sviOrganizatori = ListaDogadjaja.deSerijalizacija("organizatori");
            sviPredavaci = ListaDogadjaja.deSerijalizacija("predavaci");
            sviUcesnici = ListaDogadjaja.deSerijalizacija("ucesnici");

            while (true) {
            
                Poruka poruka = (Poruka) ois.readObject();
                System.out.println("primljena poruka od klijenta" + poruka.getIdPoruke().toString());

                if ((poruka.getIdPoruke().equals(Poruka.IDPoruke.SVI_DOGADJAJI))) {
                    sviDogadjaji = ListaDogadjaja.deSerijalizacija("dogadjaji");
                    sortirajDogadjajePoDatumu(sviDogadjaji);
                    oos.writeObject(new Poruka(Poruka.IDPoruke.OK, sviDogadjaji));//poslana lista dogadjaja
                    ListaDogadjaja.serijalizacija(sviDogadjaji);

                } else if ((poruka.getIdPoruke().equals(Poruka.IDPoruke.BRISANJE_DOGADJAJA))) {
                    sviDogadjaji = ListaDogadjaja.deSerijalizacija("dogadjaji");
                    String nazivDogadjaja = (String) poruka.getDodatak();  //p
                    obrisiDogadjaj(nazivDogadjaja);
                    ListaDogadjaja.serijalizacija(sviDogadjaji);
                    oos.writeObject(new Poruka(Poruka.IDPoruke.OK, sviDogadjaji));  //P R O B L E M!!!!!
                } else if ((poruka.getIdPoruke().equals(Poruka.IDPoruke.BRISANJE_ORGANIZATORA))) {
                    sviOrganizatori = ListaDogadjaja.deSerijalizacija("organizatori");
                    int indeksOrganizatoraZaBrisanje = (int) poruka.getDodatak();  //p
                    sviOrganizatori.remove(indeksOrganizatoraZaBrisanje);
                    ListaDogadjaja.serijalizacija(sviOrganizatori);
                    oos.writeObject(new Poruka(Poruka.IDPoruke.OK, sviOrganizatori));  
                } else if ((poruka.getIdPoruke().equals(Poruka.IDPoruke.BRISANJE_UCESNIKA))) {
                    sviUcesnici = ListaDogadjaja.deSerijalizacija("ucesnici");
                    int indeksUcesnikaZaBrisanje = (int) poruka.getDodatak();  //p
                    sviUcesnici.remove(indeksUcesnikaZaBrisanje);
                    ListaDogadjaja.serijalizacija(sviUcesnici);
                    oos.writeObject(new Poruka(Poruka.IDPoruke.OK, sviUcesnici));  
                } else if ((poruka.getIdPoruke().equals(Poruka.IDPoruke.BRISANJE_PREDAVACA))) {
                    sviPredavaci = ListaDogadjaja.deSerijalizacija("predavaci");
                    int indeksPredavacaZaBrisanje = (int) poruka.getDodatak();  //p
                    sviPredavaci.remove(indeksPredavacaZaBrisanje);
                    ListaDogadjaja.serijalizacija(sviPredavaci);
                    oos.writeObject(new Poruka(Poruka.IDPoruke.OK, sviPredavaci));  
                } else if ((poruka.getIdPoruke().equals(Poruka.IDPoruke.NOVI_DOGADJAJ))) {
                    sviDogadjaji = ListaDogadjaja.deSerijalizacija("dogadjaji");
                    Dogadjaj noviDogadjaj = new Dogadjaj();
                    noviDogadjaj = (Dogadjaj) poruka.getDodatak();
                    sviDogadjaji.add(noviDogadjaj);
                    ListaDogadjaja.serijalizacija(sviDogadjaji);
                    oos.writeObject(new Poruka(Poruka.IDPoruke.OK, sviDogadjaji));  //s
                } else if ((poruka.getIdPoruke().equals(Poruka.IDPoruke.SVI_ORGANIZATORI))) {
                    sviOrganizatori = ListaDogadjaja.deSerijalizacija("organizatori");
                    oos.writeObject(new Poruka(Poruka.IDPoruke.OK, sviOrganizatori));  //s
                } else if ((poruka.getIdPoruke().equals(Poruka.IDPoruke.SVI_UCESNICI))) {
                    sviUcesnici = ListaDogadjaja.deSerijalizacija("ucesnici");
                    oos.writeObject(new Poruka(Poruka.IDPoruke.OK, sviUcesnici));  //s
                } else if ((poruka.getIdPoruke().equals(Poruka.IDPoruke.SVI_PREDAVACI))) {
                    sviPredavaci = ListaDogadjaja.deSerijalizacija("predavaci");
                    oos.writeObject(new Poruka(Poruka.IDPoruke.OK, sviPredavaci));  //s
                } else if ((poruka.getIdPoruke().equals(Poruka.IDPoruke.NOVI_PREDAVAC))) {
                    sviPredavaci = ListaDogadjaja.deSerijalizacija("predavaci");
                    Predavac noviPredavac = (Predavac) poruka.getDodatak();
                    sviPredavaci.add(noviPredavac);
                    ListaDogadjaja.serijalizacija(sviPredavaci);
                    oos.writeObject(new Poruka(Poruka.IDPoruke.OK, sviPredavaci));  //s
                } else if ((poruka.getIdPoruke().equals(Poruka.IDPoruke.NOVI_ORGANIZATOR))) {
                    sviOrganizatori = ListaDogadjaja.deSerijalizacija("organizatori");
                    Organizator noviOrganizator = (Organizator) poruka.getDodatak();
                    sviOrganizatori.add(noviOrganizator);
                    ListaDogadjaja.serijalizacija(sviOrganizatori);
                    oos.writeObject(new Poruka(Poruka.IDPoruke.OK, sviOrganizatori));  //s
                }else if ((poruka.getIdPoruke().equals(Poruka.IDPoruke.NOVI_UCESNIK))) {
                    sviUcesnici = ListaDogadjaja.deSerijalizacija("ucesnici");
                    Ucesnik noviUcesnik = (Ucesnik) poruka.getDodatak();
                    sviUcesnici.add(noviUcesnik);
                    ListaDogadjaja.serijalizacija(sviUcesnici);
                    oos.writeObject(new Poruka(Poruka.IDPoruke.OK, sviUcesnici));  //s
                } else if ((poruka.getIdPoruke().equals(Poruka.IDPoruke.PREUZIMANJE_LISTE_DOGADJAJA))) {
                    sviDogadjaji = ListaDogadjaja.deSerijalizacija("dogadjaji");
                    napraviFajlSaDogadjajima();
                    File listaDogadjaja =  new File(".\\src\\server\\fajlovi\\listaDogadjaja.csv"); 
                    posaljiFajlKlijentu(listaDogadjaja);
                } else if ((poruka.getIdPoruke().equals(Poruka.IDPoruke.PREUZIMANJE_LISTE_ORGANIZATORA))) {
                    sviOrganizatori = ListaDogadjaja.deSerijalizacija("organizatori");
                    napraviFajlSaOrganizatorima();
                    File listaOrganizatora = new File(".\\src\\server\\fajlovi\\listaOrganizatora.csv");
                    posaljiFajlKlijentu(listaOrganizatora);
                } else if ((poruka.getIdPoruke().equals(Poruka.IDPoruke.PREUZIMANJE_LISTE_UCESNIKA))) {
                    sviUcesnici = ListaDogadjaja.deSerijalizacija("ucesnici");
                    napraviFajlSaUcesnicima();
                    File listaUcesnika = new File(".\\src\\server\\fajlovi\\listaUcesnika.csv");
                    posaljiFajlKlijentu(listaUcesnika);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    private static void sortirajDogadjajePoDatumu(ArrayList<Dogadjaj> sviDogadjaji) {
        //ArrayList<Dogadjaj> sortiraniDogadjaji;
        Collections.sort(sviDogadjaji);
    }

    private static void obrisiDogadjaj(String nazivDogadjaja) {
        System.out.println("Broj prije Brisanja" + sviDogadjaji.size());
        for (int i = 0; i < sviDogadjaji.size(); i++) {
            if (sviDogadjaji.get(i).getNazivDogadjaja().equals(nazivDogadjaja)) {
                sviDogadjaji.remove(i);
            }

        }
        ListaDogadjaja.serijalizacija(sviDogadjaji);
        System.out.println("Broj poslije brisanja" + sviDogadjaji.size());
    }
    
    private void posaljiFajlKlijentu(File putanjaDoFajla) {
        try {
            long duzina = putanjaDoFajla.length();
            System.out.println("DUZINA FAJLA: " + duzina);
            oos.writeObject(duzina);
            byte[] buffer = new byte[2 * 1024 * 1024];
            InputStream fajl = new FileInputStream(putanjaDoFajla);
            int length = 0;
            while ((length = fajl.read(buffer)) > 0) {
                oos.write(buffer, 0, length);
            }
            System.out.println("Poslan fajl:  ");
            fajl.close();
            oos.reset();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void napraviFajlSaOrganizatorima() {
        try {
            String organizatorZaUpis;
            PrintWriter upis = new PrintWriter(new BufferedWriter(new FileWriter(".\\src\\server\\fajlovi\\listaOrganizatora.csv")), true);
            for(int i=0; i<sviOrganizatori.size(); i++){
                organizatorZaUpis = sviOrganizatori.get(i).toStringZaUpisUFajlOrganizatora();
                upis.println(organizatorZaUpis);
            }
            upis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void napraviFajlSaDogadjajima() {
        try {
            String dogadjajZaUpis;
            PrintWriter upis = new PrintWriter(new BufferedWriter(new FileWriter(".\\src\\server\\fajlovi\\listaDogadjaja.csv")), true);
            for(int i=0; i<sviDogadjaji.size(); i++){
                dogadjajZaUpis = sviDogadjaji.get(i).toStringZaUpisUFajlDogadjaja();
                System.out.println("DOGADJAJ ZA U P I S ::::" + dogadjajZaUpis);
                upis.println(dogadjajZaUpis);
            }
            upis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void napraviFajlSaUcesnicima() {
       try {
            String ucesniciZaUpis;
            PrintWriter upis = new PrintWriter(new BufferedWriter(new FileWriter(".\\src\\server\\fajlovi\\listaUcesnika.csv")), true);
            for(int i=0; i<sviUcesnici.size(); i++){
                ucesniciZaUpis = sviUcesnici.get(i).toStringZaUpisUFajlUcesnika();
                System.out.println("DOGADJAJ ZA U P I S ::::" + ucesniciZaUpis);
                upis.println(ucesniciZaUpis);
            }
            upis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
}
