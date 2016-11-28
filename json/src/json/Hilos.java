
package json;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */
public class Hilos extends Thread{
    Inicio inicio;
    public Hilos( Inicio obj ){
        this.inicio = obj;
    }
    
    @Override
    public void run(){
        inicio.loading.setVisible(true);
        inicio.btnCrear.setEnabled(false);
        inicio.tfNombre.setEditable(false);
        inicio.tfLotes.setEditable(false);
        inicio.tfPruebas .setEditable(false);
        dashboard dashB = new dashboard();
        try {
            inicio.te.newFIle(inicio.tfNombre.getText(),inicio.tfLotes.getText(),inicio.tfPruebas.getText());
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        dashB.jlLotes.setText(inicio.tfLotes.getText());
        dashB.jlPruebas.setText(inicio.tfPruebas.getText());
        dashB.jlNombre.setText(inicio.tfNombre.getText());
        dashB.jlLote_i.setText("1");
        dashB.jlPrueba_i.setText("1");
        dashB.jlStatus.setText("Nuevo");
        inicio.setVisible(false);
        dashB.setVisible(true);
        dashB.setLocationRelativeTo(null);
    }
    
}
