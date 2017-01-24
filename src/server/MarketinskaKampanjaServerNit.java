/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dogadjaj.Dogadjaj;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import osoba.Posjetilac;
import poruka.Poruka;

/**
 *
 * @author raka
 */
public class MarketinskaKampanjaServerNit extends Thread {

    private Socket soket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Dogadjaj marketiskaKampanja;
    
    private static final String putanjaDOLogFajlova = "./src/logFajlovi/";

    public MarketinskaKampanjaServerNit(Socket soket, Dogadjaj marketiskaKampanja) {
        try {
            this.soket = soket;
            this.marketiskaKampanja = marketiskaKampanja;
            ois = new ObjectInputStream(soket.getInputStream());
            oos = new ObjectOutputStream(soket.getOutputStream());
            start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        try {
            
            Poruka poruka = (Poruka) ois.readObject();
            Posjetilac posjetilac = (Posjetilac) poruka.getDodatak();
            
            sacuvajLog(posjetilac);
            
            oos.writeObject(new Poruka(Poruka.IDPoruke.MARKENTISKA_KAMPANJA, marketiskaKampanja.getNazivDogadjaja()));
            sleep(1000);
            oos.writeObject(new Poruka(Poruka.IDPoruke.MARKENTISKA_KAMPANJA, marketiskaKampanja.getDatumPocetkaDogadjaja()));
            sleep(1000);
            
            //for petllja za slanje fajlova posjetiocu

        } catch (IOException ex) {
            Logger.getLogger(MarketinskaKampanjaServerNit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MarketinskaKampanjaServerNit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarketinskaKampanjaServerNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public void sacuvajLog(Posjetilac posjetilac) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(putanjaDOLogFajlova + marketiskaKampanja.getNazivDogadjaja() + ".txt"), true)));
            pw.println(posjetilac.getImeOsobe() + " " + posjetilac.getPrezimeOsobe()+ " " + 
                    marketiskaKampanja.getDatumPocetkaDogadjaja().get(Calendar.YEAR) + " " + 
                    marketiskaKampanja.getNazivDogadjaja() + " " + marketiskaKampanja.getOpisDogadjaja());
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(MarketinskaKampanjaServerNit.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

}
