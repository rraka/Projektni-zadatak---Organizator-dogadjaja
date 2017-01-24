/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dogadjaj.Dogadjaj;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import osoba.Posjetilac;

/**
 *
 * @author raka
 */
public class MarketinskaKampanjaServer extends Thread {
    
    private int port;
    private Dogadjaj marketiskaKampanja ;

    public MarketinskaKampanjaServer(int port, Dogadjaj marketiskaKampanja) {
        this.port = port;
        this.marketiskaKampanja = marketiskaKampanja;
        start();
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Server markentiskih kampanja pokrenut...");
            
            ArrayList<Posjetilac> listaPosjetioca = ListaDogadjaja.deSerijalizacija("posjetioci");
            for (int i = 0; i < listaPosjetioca.size(); i++) {
                Socket soket = ss.accept();
                MarketinskaKampanjaServerNit odsn = new MarketinskaKampanjaServerNit(soket, marketiskaKampanja);
            }
            
            OrganizatorDogadjajaServer.posaljiObavjestenjeSvima(marketiskaKampanja);
            
        } catch (IOException ex) {
            Logger.getLogger(MarketinskaKampanjaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
