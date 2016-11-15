
package json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.TLectura;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**
 * Importar Hashtables para generar el json
 */
import java.util.Hashtable;


/**
 *
 * @author cesar
 */
public class prueba extends javax.swing.JFrame {

    TLectura tl = new TLectura();
    public prueba() throws IOException {
        initComponents();
        getTest();
        ReadXML();
    }
    
    public void ReadXML() throws IOException{
        try {
         File inputFile = new File("data/data.xml");

         SAXBuilder saxBuilder = new SAXBuilder();

         Document document = saxBuilder.build(inputFile);

         System.out.println("Root element :" 
            + document.getRootElement().getName());

         Element classElement = document.getRootElement();

         /**
          * Empezar a leer el xml apartir del root
          */        
        ArrayList<ArrayList> data  = new ArrayList<ArrayList>();
        ArrayList<String> meta  = new ArrayList<String>();
         
         List<Element> testList = classElement.getChildren();
         /**
          * Obteniendo los valores del meta
          */
         
         Element metaXML = testList.get(0);
            //System.out.println("fecha: " + metaXML.getChild("Fecha").getText());
         meta.add(metaXML.getChild("Fecha").getText());
         meta.add(metaXML.getChild("Lotes").getText());
         meta.add(metaXML.getChild("Pruebas").getText());
         data.add(meta);
         //System.out.println("meta: " + data.get(0).get(1));
         for (int temp = 1; temp < testList.size(); temp++) {
            ArrayList<String> test  = new ArrayList<String>();
            Element tests = testList.get(temp);
            Attribute idLote =  tests.getAttribute("IdLote");
            Attribute idPrueba =  tests.getAttribute("IdPrueba");
            String nameTest = idLote.getValue()+"_"+idPrueba.getValue();
            test.add(nameTest);
            test.add(tests.getChild("Fuerza").getText());
            test.add(tests.getChild("Diametro").getText());
            test.add(tests.getChild("Momento").getText());
            test.add(tests.getChild("Esfuerzo").getText());
            test.add(tests.getChild("Ciclos").getText());
            test.add(tests.getChild("Tiempo").getText());
            test.add(tests.getChild("Estado").getText());
            data.add(test);
         }
        for( int i = 0; i < data.size(); i++ ){
            for( int j = 0; j < data.get(i).size(); j++ ){
                System.out.println("datos: " + data.get(i).get(j));
            }
        }

//        
         
      }catch( Exception e ){
            System.out.println("Ocurrio un error: " + e.getMessage());
      }
    }
    
    public void getTest(){
        cb.removeAllItems();
        for(int i = 0; i<tl.allTests().size();i++){
            cb.addItem((String) tl.allTests().get(i));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        cb = new javax.swing.JComboBox<>();
        btn = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn.setText("jButton2");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btn)))
                .addContainerGap(369, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btn)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        String file = cb.getSelectedItem().toString();
        try {
            if(tl.statusTest(file)){
                System.out.println("El ensayo no se ha terminado");
            }else{
                System.out.println("Ensayo terminado");
            }
        } catch (IOException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnActionPerformed

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
            java.util.logging.Logger.getLogger(prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new prueba().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
