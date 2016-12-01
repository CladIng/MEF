
package All_code;

import UpperEssential.UpperEssentialLookAndFeel;
import javax.swing.UIManager;
import java.io.IOException;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author cesar
 */
public class Json {
    
    
    public static void main(String[] args) throws IOException, UnsupportedLookAndFeelException{
        //Iniciar Libreria para mejorar la interface
        UIManager.setLookAndFeel(new UpperEssentialLookAndFeel());
        Inicio obj = new Inicio();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }
    
        
}
