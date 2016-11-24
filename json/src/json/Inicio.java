/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.TLectura;

/**
 *
 * @author cesar
 */
public class Inicio extends javax.swing.JFrame {

    TLectura tl = new TLectura();
    TEscritura te = new TEscritura();
    public Inicio() throws IOException {
        initComponents();
        getTestNF();
        JOptionPane.showMessageDialog(null, "Asegúrese de haber conectado el Arduino.");
    }
    
    public void getTestNF() throws IOException{
        cbInicio.removeAllItems();
        if (tl.allTestsNF().size()>0) {
            for(int i = 0; i<tl.allTestsNF().size();i++){
                cbInicio.addItem((String) tl.allTestsNF().get(i));
            }
        }else{
            btnRetomar.setEnabled(false);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfLotes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfPruebas = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        cbInicio = new javax.swing.JComboBox<>();
        btnRetomar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btnConectar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nuevo Ensayo");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Lotes");

        tfLotes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfLotesKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfLotesKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Pruebas");

        tfPruebas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPruebasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPruebasKeyTyped(evt);
            }
        });

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        btnCrear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCrearKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Nuevo Ensayo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(61, 61, 61))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfLotes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfPruebas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfLotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPruebas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 210));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 540, 10));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInicioActionPerformed(evt);
            }
        });

        btnRetomar.setText("Retomar");
        btnRetomar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetomarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Ensayos sin terminar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnRetomar)
                                .addGap(38, 38, 38)))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cbInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnRetomar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 190, 160));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 10, 210));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 10, 230));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Conectar con Arduino");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(36, 36, 36))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addGap(33, 33, 33)
                .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 240, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        if ( tfLotes.getText().equals("") || tfNombre.getText().equals("") || tfPruebas.getText().equals("") ) {
            JOptionPane.showMessageDialog(null, "Debe ingresar Nombre, Lotes y Pruebas.");
        }else{
            dashboard dashB = new dashboard();
            try {
            te.newFIle(tfNombre.getText(),tfLotes.getText(),tfPruebas.getText());
            } catch (IOException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            dashB.jlLotes.setText(tfLotes.getText());
            dashB.jlPruebas.setText(tfPruebas.getText());
            dashB.jlNombre.setText(tfNombre.getText());
            dashB.jlLote_i.setText("1");
            dashB.jlPrueba_i.setText("1");
            dashB.jlStatus.setText("Nuevo");
            this.setVisible(false);
            dashB.setVisible(true);
            dashB.setLocationRelativeTo(null);
        }
        
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnRetomarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetomarActionPerformed
        dashboard dashB = new dashboard();
        try {
            ArrayList<ArrayList> data  = new ArrayList<>();
            data = tl.ReadXML(cbInicio.getSelectedItem().toString());
            dashB.jlNombre.setText( data.get(0).get(0).toString() );
            dashB.jlLote_i.setText(data.get(data.size()-1).get(2).toString());
            dashB.jlPrueba_i.setText(data.get(data.size()-1).get(3).toString());
            dashB.jlLotes.setText(data.get(0).get(2).toString());
            dashB.jlPruebas.setText(data.get(0).get(3).toString());
            this.setVisible(false);
            dashB.setVisible(true);
            dashB.setLocationRelativeTo(null);
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRetomarActionPerformed

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
//        try{
//            dashB = new dashboard();
//            tfNombre.setEnabled(true);
//            tfLotes.setEnabled(true);
//            tfPruebas.setEnabled(true);
//            btnCrear.setEnabled(true);
//            cbInicio.setEnabled(true);
//            btnConectar.setText("Desconectar");
//            btnRetomar.setEnabled(true);
//        }catch(Exception ex){
//            JOptionPane.showMessageDialog(null, "Debe conectar el Arduino");
//        }
    }//GEN-LAST:event_btnConectarActionPerformed

    private void tfLotesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLotesKeyTyped
        int c = evt.getKeyChar();

        if ( c > 48 && c < 58 ) {
            System.err.println("valor de c: " + c);
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_tfLotesKeyTyped

    private void tfPruebasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPruebasKeyPressed
//        int code = evt.getKeyCode();
//        if (code == 10) {
//            if ( tfLotes.getText().equals("") && tfNombre.getText().equals("") && tfPruebas.getText().equals("") ) {
//                JOptionPane.showMessageDialog(null, "Debe ingresar Nombre, Lotes y Pruebas.");
//            }else{
//                try {
//                te.newFIle(tfNombre.getText(),tfLotes.getText(),tfPruebas.getText());
//                } catch (IOException ex) {
//                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                dashB.jlLotes.setText(tfLotes.getText());
//                dashB.jlPruebas.setText(tfPruebas.getText());
//                dashB.jlNombre.setText(tfNombre.getText());
//                dashB.jlLote_i.setText("1");
//                dashB.jlPrueba_i.setText("1");
//                dashB.jlStatus.setText("Nuevo");
//                this.setVisible(false);
//                dashB.setVisible(true);
//                dashB.setLocationRelativeTo(null);
//            }
//        }
        
    }//GEN-LAST:event_tfPruebasKeyPressed

    private void btnCrearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCrearKeyPressed
//        int code = evt.getKeyCode();
//        if (code == 10) {
//            if ( tfLotes.getText().equals("") && tfNombre.getText().equals("") && tfPruebas.getText().equals("") ) {
//                JOptionPane.showMessageDialog(null, "Debe ingresar Nombre, Lotes y Pruebas.");
//            }else{
//                try {
//                te.newFIle(tfNombre.getText(),tfLotes.getText(),tfPruebas.getText());
//                } catch (IOException ex) {
//                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                dashB.jlLotes.setText(tfLotes.getText());
//                dashB.jlPruebas.setText(tfPruebas.getText());
//                dashB.jlNombre.setText(tfNombre.getText());
//                dashB.jlLote_i.setText("1");
//                dashB.jlPrueba_i.setText("1");
//                dashB.jlStatus.setText("Nuevo");
//                this.setVisible(false);
//                dashB.setVisible(true);
//                dashB.setLocationRelativeTo(null);
//            }
//        }
    }//GEN-LAST:event_btnCrearKeyPressed

    private void tfLotesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLotesKeyPressed
//        int c = evt.getKeyChar();
//
//        if ( c > 48 && c < 58 ) {
//            System.err.println("valor de c: " + c);
//        }else{
//            evt.consume();
//        }
    }//GEN-LAST:event_tfLotesKeyPressed

    private void tfPruebasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPruebasKeyTyped
        int c = evt.getKeyChar();

        if ( c > 48 && c < 58 ) {
            System.err.println("valor de c: " + c);
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_tfPruebasKeyTyped

    private void cbInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbInicioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Inicio().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    public javax.swing.JButton btnCrear;
    private javax.swing.JButton btnRetomar;
    private javax.swing.JComboBox<String> cbInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JTextField tfLotes;
    public javax.swing.JTextField tfNombre;
    public javax.swing.JTextField tfPruebas;
    // End of variables declaration//GEN-END:variables
}
