/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osoba;

import java.util.ArrayList;

/**
 *
 * @author raka
 */
public class Organizator extends Osoba{
    
    private String telefonOrganizator;
    private String eMailOrganizator;
    private ArrayList<NapomenaOrganizator> napomenaOrganizator;

    public Organizator(String telefonOrganizator, String eMailOrganizator, ArrayList<NapomenaOrganizator> napomenaOrganizator, String imeOsobe, String prezimeOsobe) {
        super(imeOsobe, prezimeOsobe);
        this.telefonOrganizator = telefonOrganizator;
        this.eMailOrganizator = eMailOrganizator;
        this.napomenaOrganizator = napomenaOrganizator;
    }

    

    public String getTelefonOrganizator() {
        return telefonOrganizator;
    }

    public void setTelefonOrganizator(String telefonOrganizator) {
        this.telefonOrganizator = telefonOrganizator;
    }

    public String geteMailOrganizator() {
        return eMailOrganizator;
    }

    public void seteMailOrganizator(String eMailOrganizator) {
        this.eMailOrganizator = eMailOrganizator;
    }

    public ArrayList<NapomenaOrganizator> getNapomenaOrganizator() {
        return napomenaOrganizator;
    }

    public void setNapomenaOrganizator(ArrayList<NapomenaOrganizator> napomenaOrganizator) {
        this.napomenaOrganizator = napomenaOrganizator;
    }

    @Override
    
    public String toString(){
        return super.toString();
    }
    
    
}
