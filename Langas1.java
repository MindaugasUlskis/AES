import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Langas1 extends javax.swing.JFrame {

    public Langas1() {
        initComponents();
    }
    public String kodas;

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tekstas = new javax.swing.JTextField();
        uzsifruoti = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        poslinkis = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        UzsifruotasTekstas = new javax.swing.JTextField();
        Desifruoti = new javax.swing.JButton();
        ifaila = new javax.swing.JButton();
        isfailo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Iveskite norima teksta");


        uzsifruoti.setText("Uzsifruoti");
        uzsifruoti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uzsifruotiActionPerformed(evt);
            }
        });

        jLabel2.setText("Iveskite raktą");

        jLabel3.setText("Uzsifruotas tekstas");

        Desifruoti.setText("Desifruoti");
        Desifruoti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesifruotiActionPerformed(evt);
            }
        });

        ifaila.setText("Įšsaugoti užšifruotą žinutę faile");
        ifaila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ifailaActionPerformed(evt);
            }
        });

        isfailo.setText("Dešifruoti iš failo");
        isfailo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isfailoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(229, 229, 229)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tekstas)
                                        .addComponent(UzsifruotasTekstas, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(322, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(346, 346, 346))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(Desifruoti)
                                                .addGap(360, 360, 360))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(poslinkis, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(uzsifruoti))))
                                                .addGap(344, 344, 344))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(ifaila)
                                                .addGap(307, 307, 307))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(isfailo)
                                                .addGap(345, 345, 345))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(67, 67, 67)
                                .addComponent(tekstas, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(uzsifruoti)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(poslinkis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(35, 35, 35)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(UzsifruotasTekstas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Desifruoti)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ifaila)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(isfailo)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    public void uzsifruotiActionPerformed(java.awt.event.ActionEvent evt) {

            AES aes = new AES();
            String encryptedString = aes.encrypt(tekstas.getText(), poslinkis.getText()) ;
            UzsifruotasTekstas.setText(encryptedString);

}
    public void DesifruotiActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            AES aes = new AES();
            String decryptedString = aes.decrypt(UzsifruotasTekstas.getText(), poslinkis.getText()) ;


            tekstas.setText(decryptedString);
        } catch (Exception ignored) {
        }


    }
    private void ifailaActionPerformed(java.awt.event.ActionEvent evt) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("UžšifruotaŽinutė.txt"));
            writer.write(UzsifruotasTekstas.getText());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void isfailoActionPerformed(java.awt.event.ActionEvent evt) {
        AES aes = new AES();
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        try {
            Scanner myReader = new Scanner(file);

                String data = myReader.nextLine();
                String decryptedString = aes.decrypt(data, poslinkis.getText()) ;

            tekstas.setText(decryptedString);
            myReader.close();
        } catch (Exception ignored) {
        }
    }




    private javax.swing.JButton Desifruoti;
    private javax.swing.JTextField UzsifruotasTekstas;
    private javax.swing.JButton ifaila;
    private javax.swing.JButton isfailo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField poslinkis;
    private javax.swing.JTextField tekstas;
    private javax.swing.JButton uzsifruoti;

}
