
package All_code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.TLectura;

/**
 *
 * @author cesar
 */
public class Hilos_Return_Test extends Thread{
    Inicio inicio;
    TLectura tl;
    ArrayList<ArrayList> data;
    public Hilos_Return_Test( Inicio obj ){
        this.inicio = obj;
        this.data = new ArrayList<>();
        tl = new TLectura();
    }

    /**
     *
     */
    @Override
    public void run(){
        inicio.loading.setVisible(true);
        inicio.btnCrear.setEnabled(false);
        inicio.tfNombre.setEditable(false);
        inicio.tfLotes.setEditable(false);
        inicio.tfPruebas .setEditable(false);
        dashboard dashB = new dashboard();
        try {
            /**
             * Retorna los datos del ultimo ensayo
             */
            data = tl.lastTest(inicio.cbInicio.getSelectedItem().toString());
        } catch (IOException ex) {
            Logger.getLogger(Hilos_Return_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        dashB.jlLotes.setText((String) data.get(0).get(2));
        dashB.jlPruebas.setText((String) data.get(0).get(3));
        dashB.jlNombre.setText((String) data.get(0).get(0));
        dashB.jlLote_i.setText((String) data.get(1).get(0));
        dashB.jlPrueba_i.setText((String) data.get(1).get(1));
        dashB.jlStatus.setText("Retomado");
        inicio.setVisible(false);
        dashB.setVisible(true);
        dashB.setLocationRelativeTo(null);
    }
}
