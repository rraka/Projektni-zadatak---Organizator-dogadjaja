/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author raka
 */
public class ObavjestenjeNit {
    
     private Socket soket;
    private  ObjectOutputStream oos;
    private int IDNiti;

    public ObavjestenjeNit(Socket soket, int IDNiti) {
        try {
            this.soket = soket;
            this.IDNiti = IDNiti;
            oos = new ObjectOutputStream(soket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public int getIDNiti() {
        return IDNiti;
    }
    
    
}
