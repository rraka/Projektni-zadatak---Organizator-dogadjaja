/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;
import osoba.Posjetilac;

/**
 *
 * @author raka
 */
public class SimulacijaDolaskaPosjetilaca {

    public SimulacijaDolaskaPosjetilaca(int port) {
        ArrayList<Posjetilac> listaPosjetioca = ListaDogadjaja.deSerijalizacija("posjetioci");
        for (int i = 0; i < listaPosjetioca.size(); i++) {
            new DolazakJednogPosjetiocaNit(port, listaPosjetioca.get(i));
        }
    }

}
