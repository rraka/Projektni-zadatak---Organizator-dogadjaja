/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dogadjaj.Dogadjaj;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
}
