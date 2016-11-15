package logica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.TEnsayo;
import logica.TLectura;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;



/**
 *
 * @author cesar
 */
public class TLectura {
    
    
    public boolean statusTest( String test ) throws IOException{
        /*File archivo = new File("data.xml");
        BufferedWriter bw = new BufferedWriter(new FileWriter("data .xml"));*/
        int flag=0;
        try{
            File xml = new File("data/"+test);
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(xml);
            System.out.println("Root element :" + document.getRootElement().getName());
            
            Element classElement = document.getRootElement();
            
            List<Element> Pruebas = classElement.getChildren("Prueba");
            
            for( int index = 0; index < Pruebas.size() ; index++ ){
                Element Prueba = Pruebas.get(index);
                if( Prueba.getChildText("Estado").equalsIgnoreCase("Pausado") ){
                    flag++;
                }
                //System.out.println("Ciclos de la prueba "+index+" es: "+Prueba.getChildText("Ciclos"));
            }
            
        }catch( JDOMException e ){
            e.printStackTrace();
        }
        if(flag==0){
            return false;
        }else{
            return true;
        }
    }
    
    
    public ArrayList  allTests(){
        // Aquí la carpeta que queremos explorar
        String path = "data/"; 
        String file;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles(); 
        ArrayList files = new ArrayList();
        for (int i = 0; i < listOfFiles.length; i++) 
        {
            if (listOfFiles[i].isFile()) 
            {
                file = listOfFiles[i].getName();
                if (file.endsWith(".xml") || file.endsWith(".XML"))
                {
                    files.add(file);
                }
            }
        }
        return files;
    }
    public ArrayList  allTestsNF() throws IOException{
        // Aquí la carpeta que queremos explorar
        String path = "data/"; 
        String file;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles(); 
        ArrayList files = new ArrayList();
        for (int i = 0; i < listOfFiles.length; i++) 
        {
            if (listOfFiles[i].isFile()) 
            {
                file = listOfFiles[i].getName();
                if (file.endsWith(".xml") || file.endsWith(".XML"))
                {
                    if (statusTest(file)) {
                        files.add(file);
                    }
                    
                }
            }
        }
        return files;
    }
}
