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
public class Ucesnik extends Osoba{
    
    private String organizacijaUcesnik;

    
    public Ucesnik(){}
    
    public Ucesnik(String organizacijaUcesnik, String imeOsobe, String prezimeOsobe) {
        super(imeOsobe, prezimeOsobe);
        this.organizacijaUcesnik = organizacijaUcesnik;
    }

    public String getOrganizacijaUcesnik() {
        return organizacijaUcesnik;
    }

    public void setOrganizacijaUcesnik(String organizacijaUcesnik) {
        this.organizacijaUcesnik = organizacijaUcesnik;
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
    
    
}
