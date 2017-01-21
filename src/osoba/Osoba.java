/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osoba;

import java.io.Serializable;

/**
 *
 * @author raka
 */
public abstract class Osoba implements Serializable{
    
    private String imeOsobe;
    private String prezimeOsobe;

    
    public Osoba() {
    }

    public Osoba(String imeOsobe, String prezimeOsobe) {
        this.imeOsobe = imeOsobe;
        this.prezimeOsobe = prezimeOsobe;
    }

    public String getImeOsobe() {
        return imeOsobe;
    }

    public void setImeOsobe(String imeOsobe) {
        this.imeOsobe = imeOsobe;
    }

    public String getPrezimeOsobe() {
        return prezimeOsobe;
    }

    public void setPrezimeOsobe(String prezimeOsobe) {
        this.prezimeOsobe = prezimeOsobe;
    }
    
    @Override
    public String toString(){
        return imeOsobe + " " + prezimeOsobe;
    }
    
}
