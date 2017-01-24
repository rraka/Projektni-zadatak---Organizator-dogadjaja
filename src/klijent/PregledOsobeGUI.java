/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import osoba.Organizator;
import osoba.Osoba;
import osoba.Predavac;
import osoba.Ucesnik;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 *
 * @author raka
 */
public class PregledOsobeGUI extends javax.swing.JFrame {

   
    private Osoba osobaZaPregled;
    private RadSaOsobamaGUI radSaOsobamaGUI;
    
    public PregledOsobeGUI(RadSaOsobamaGUI radSaOsobamaGUI, Osoba osobaZaPregled) {
        initComponents();
        setVisible(true);
        this.radSaOsobamaGUI = radSaOsobamaGUI;
        this.osobaZaPregled = osobaZaPregled;
        prikaziPodatkeZaOsobu(osobaZaPregled);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dodatnaLabel3 = new javax.swing.JLabel();
        dodatnaLabel2 = new javax.swing.JLabel();
        dodatnaLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        vrstaTekstLabela = new javax.swing.JLabel();
        imeTekstLabela = new javax.swing.JLabel();
        prezimeTekstLabela = new javax.swing.JLabel();
        dodatna1TekstLabela = new javax.swing.JLabel();
        dodatna2TekstLabela = new javax.swing.JLabel();
        dodatna43TekstLabela = new javax.swing.JLabel();
        dodatnaLabel4 = new javax.swing.JLabel();
        dodatnaLabel5 = new javax.swing.JLabel();
        napomeneComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        napomenaTekst = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        dodatnaLabel3.setText("dodatna3");

        dodatnaLabel2.setText("dodatna2");

        dodatnaLabel1.setText("dodatna1");

        jLabel4.setText("Prezime:");

        jLabel3.setText("Ime:");

        jLabel1.setText("PREGLED OSOBE");

        jLabel5.setText("Vrsta:");

        vrstaTekstLabela.setText("525252");

        imeTekstLabela.setText("57");

        prezimeTekstLabela.setText("87");

        dodatna1TekstLabela.setText("78678");

        dodatna2TekstLabela.setText("5552");

        dodatna43TekstLabela.setText("asda");

        dodatnaLabel4.setText("dodatna4");

        dodatnaLabel5.setText("dodatna4");

        napomeneComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                napomeneComboBoxActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        napomenaTekst.setBorder(null);
        jScrollPane1.setViewportView(napomenaTekst);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dodatnaLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vrstaTekstLabela, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(imeTekstLabela, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prezimeTekstLabela, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dodatna1TekstLabela, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dodatna2TekstLabela, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dodatnaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dodatnaLabel3)
                                    .addComponent(dodatnaLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dodatnaLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(napomeneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dodatna43TekstLabela)))
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(vrstaTekstLabela))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(imeTekstLabela))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(prezimeTekstLabela))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dodatnaLabel1)
                    .addComponent(dodatna1TekstLabela))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dodatnaLabel2)
                    .addComponent(dodatna2TekstLabela))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dodatnaLabel3)
                    .addComponent(napomeneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dodatnaLabel4)
                    .addComponent(dodatna43TekstLabela))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dodatnaLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void napomeneComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_napomeneComboBoxActionPerformed
        String odabranaNapomena = (String) napomeneComboBox.getSelectedItem();
        int indeks = Integer.parseInt(odabranaNapomena);
        System.out.println("INDEKS KOD PREGLEDA:::::::::::::::::::::;;" + indeks);
            dodatnaLabel4.setText("Datum:");
            Calendar kalendar = Calendar.getInstance();
            kalendar = ((Organizator) osobaZaPregled).getNapomenaOrganizator().get(indeks-1).getDatumKreiranja();
            SimpleDateFormat formatDatuma = new SimpleDateFormat("dd.MM.yyyy");
            String formatiranDatum = formatDatuma.format(kalendar.getTime());
            dodatna43TekstLabela.setText(formatiranDatum);
            dodatnaLabel5.setText("Napomena");
            napomenaTekst.setText(((Organizator) osobaZaPregled).getNapomenaOrganizator().get(indeks-1).getTekstualniSadrzaj());
    }//GEN-LAST:event_napomeneComboBoxActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
     radSaOsobamaGUI.setVisible(true);
       // setVisible(false);

    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dodatna1TekstLabela;
    private javax.swing.JLabel dodatna2TekstLabela;
    private javax.swing.JLabel dodatna43TekstLabela;
    private javax.swing.JLabel dodatnaLabel1;
    private javax.swing.JLabel dodatnaLabel2;
    private javax.swing.JLabel dodatnaLabel3;
    private javax.swing.JLabel dodatnaLabel4;
    private javax.swing.JLabel dodatnaLabel5;
    private javax.swing.JLabel imeTekstLabela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane napomenaTekst;
    private javax.swing.JComboBox<String> napomeneComboBox;
    private javax.swing.JLabel prezimeTekstLabela;
    private javax.swing.JLabel vrstaTekstLabela;
    // End of variables declaration//GEN-END:variables

    private  void prikaziPodatkeZaOsobu(Osoba osobaZaPregled) {
        if(osobaZaPregled instanceof Organizator){
            dodatnaLabel1.setVisible(true);
            dodatnaLabel2.setVisible(true);
            dodatnaLabel3.setVisible(true);
            dodatnaLabel4.setVisible(true); 
            dodatnaLabel5.setVisible(true);
            dodatna1TekstLabela.setVisible(true);
            dodatna2TekstLabela.setVisible(true);
            dodatna43TekstLabela.setVisible(true);
            napomeneComboBox.setVisible(true);
            napomenaTekst.setVisible(true);
            vrstaTekstLabela.setText("Organizator");
            imeTekstLabela.setText(osobaZaPregled.getImeOsobe());
            prezimeTekstLabela.setText(osobaZaPregled.getPrezimeOsobe());
            dodatnaLabel1.setText("Telefon:");
            dodatna1TekstLabela.setText(((Organizator) osobaZaPregled).getTelefonOrganizator());
            dodatnaLabel2.setText("Email:");
            dodatna2TekstLabela.setText(((Organizator) osobaZaPregled).geteMailOrganizator());
            dodatnaLabel3.setText("Napomena:");
            for(int i=0; i<((Organizator) osobaZaPregled).getNapomenaOrganizator().size(); i++){
                napomeneComboBox.addItem(Integer.toString(i+1));
            }
            dodatnaLabel4.setText("Datum:");
            Calendar kalendar = Calendar.getInstance();
            String odabranaNapomena = (String) napomeneComboBox.getSelectedItem();
            int indeks = Integer.parseInt(odabranaNapomena);
            kalendar = ((Organizator) osobaZaPregled).getNapomenaOrganizator().get(indeks-1).getDatumKreiranja();
            SimpleDateFormat formatDatuma = new SimpleDateFormat("dd.MM.yyyy");
            String formatiranDatum = formatDatuma.format(kalendar.getTime());
            dodatna43TekstLabela.setText(formatiranDatum);
            dodatnaLabel5.setText("Napomena");
            napomenaTekst.setText(((Organizator) osobaZaPregled).getNapomenaOrganizator().get(indeks-1).getTekstualniSadrzaj());
            
        }
        else if (osobaZaPregled instanceof Predavac){
            vrstaTekstLabela.setText("Predavac");
            imeTekstLabela.setText(osobaZaPregled.getImeOsobe());
            prezimeTekstLabela.setText(osobaZaPregled.getPrezimeOsobe());
            dodatnaLabel1.setVisible(false);
            dodatnaLabel2.setVisible(false);
            dodatnaLabel3.setVisible(false);
            dodatnaLabel4.setVisible(false); 
            dodatnaLabel5.setVisible(false);
            dodatna1TekstLabela.setVisible(false);
            dodatna2TekstLabela.setVisible(false);
            dodatna43TekstLabela.setVisible(false);
            napomeneComboBox.setVisible(false);
            napomenaTekst.setVisible(false);
            
             
        }
        else if (osobaZaPregled instanceof Ucesnik){
            vrstaTekstLabela.setText("Ucesnik");
            imeTekstLabela.setText(osobaZaPregled.getImeOsobe());
            prezimeTekstLabela.setText(osobaZaPregled.getPrezimeOsobe());
            dodatnaLabel1.setVisible(true);
            dodatnaLabel1.setText("Organizacija:");
            dodatnaLabel2.setVisible(false);
            dodatnaLabel3.setVisible(false);
            dodatnaLabel4.setVisible(false); 
            dodatnaLabel5.setVisible(false);
            dodatna1TekstLabela.setText(((Ucesnik) osobaZaPregled).getOrganizacijaUcesnik());
            dodatna2TekstLabela.setVisible(false);
            dodatna43TekstLabela.setVisible(false);
            napomeneComboBox.setVisible(false);
            napomenaTekst.setVisible(false);
        }
        
    }
}
