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
public class Predavac extends Osoba{
   
    
    private String ime;
    private String prezime;

    
    public Predavac(String ime, String prezime) {
        super(ime, prezime);
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String Prezime) {
        this.prezime = Prezime;
    }
    
     @Override
    public String toString(){
        return super.toString();
    }
    
    
}
