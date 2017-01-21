/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osoba;

/**
 *
 * @author raka
 */
public class Posjetilac extends Osoba{
    
    private String adresaPosjetioca;
    private String telefonPosjetioca;
    private String eMailPosjetioca;
    
    public Posjetilac(){}
    
    public Posjetilac(String adresaPosjetioca, String telefonPosjetioca, String eMailPosjetioca, String imeOsobe, String prezimeOsobe) {
        super(imeOsobe, prezimeOsobe);
        this.adresaPosjetioca = adresaPosjetioca;
        this.telefonPosjetioca = telefonPosjetioca;
        this.eMailPosjetioca = eMailPosjetioca;
    }

    public String getAdresaPosjetioca() {
        return adresaPosjetioca;
    }

    public void setAdresaPosjetioca(String adresaPosjetioca) {
        this.adresaPosjetioca = adresaPosjetioca;
    }

    public String getTelefonPosjetioca() {
        return telefonPosjetioca;
    }

    public void setTelefonPosjetioca(String telefonPosjetioca) {
        this.telefonPosjetioca = telefonPosjetioca;
    }

    public String geteMailPosjetioca() {
        return eMailPosjetioca;
    }

    public void seteMailPosjetioca(String eMailPosjetioca) {
        this.eMailPosjetioca = eMailPosjetioca;
    }
    
     @Override
    public String toString(){
        return super.toString();
    }
    
    
    
}
