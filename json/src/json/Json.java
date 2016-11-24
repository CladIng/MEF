/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import UpperEssential.UpperEssentialLookAndFeel;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author cesar
 */
public class Json {
    
    
    public static void main(String[] args) throws IOException, UnsupportedLookAndFeelException{
         UIManager.setLookAndFeel(new UpperEssentialLookAndFeel());
        Inicio obj = new Inicio();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }
    
        
}
