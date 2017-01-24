/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent;

import dogadjaj.Dogadjaj;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import poruka.Poruka;

/**
 *
 * @author raka
 */
public class ObavjestenjeKlijentNit extends Thread {

    private final int PORT2 = 9001;
    private Socket soket2;
    private ObjectInputStream ois2;

    public ObavjestenjeKlijentNit() {
        try {
            InetAddress adresa = InetAddress.getByName("127.0.0.1");
            soket2 = new Socket(adresa, PORT2);
            ois2 = new ObjectInputStream(soket2.getInputStream());
            start();
        } catch (IOException ex) {
            Logger.getLogger(ObavjestenjeKlijentNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            boolean beskonacnaPetlja = true;
            while (beskonacnaPetlja) {
                Poruka poruka = (Poruka) ois2.readObject();
                if(poruka.getIdPoruke() == Poruka.IDPoruke.OBAVJESTENJE) {
                    Dogadjaj dogadjaj = (dogadjaj.Dogadjaj) poruka.getDodatak();
                    JOptionPane.showMessageDialog(null, "Ucesnik: - " + dogadjaj.getNazivDogadjaja() );
                }
                else if(poruka.getIdPoruke() == Poruka.IDPoruke.ZATVARANJE_KONEKCIJE) {
                    beskonacnaPetlja = false;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ObavjestenjeKlijentNit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObavjestenjeKlijentNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
