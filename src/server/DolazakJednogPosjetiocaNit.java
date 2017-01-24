/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import osoba.Posjetilac;
import poruka.Poruka;

/**
 *
 * @author raka
 */
public class DolazakJednogPosjetiocaNit extends Thread {

    private int port;
    private Socket soket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Posjetilac posjetilac;
    
    public DolazakJednogPosjetiocaNit(int port, Posjetilac posjetilac) {
        try {
            this.posjetilac = posjetilac;
            InetAddress adresa = InetAddress.getByName("127.0.0.1");
            soket = new Socket(adresa, port);
            oos = new ObjectOutputStream(soket.getOutputStream());
            ois = new ObjectInputStream(soket.getInputStream());
            start();
        } catch (IOException ex) {
            Logger.getLogger(DolazakJednogPosjetiocaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public void run() {
        try {
            oos.writeObject(new Poruka(Poruka.IDPoruke.MARKENTISKA_KAMPANJA, posjetilac));
            
            Poruka poruka = (Poruka) ois.readObject();
            String naziv = (String) poruka.getDodatak();
            System.out.println(naziv);
            
            poruka = (Poruka) ois.readObject();
            Calendar datum = (Calendar) poruka.getDodatak();
            System.out.println(datum);
            
        } catch (IOException ex) {
            Logger.getLogger(DolazakJednogPosjetiocaNit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DolazakJednogPosjetiocaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
