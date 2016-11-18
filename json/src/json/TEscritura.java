
package json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import logica.TEnsayo;
import logica.TLectura;

/**
 *
 * @author cesar
 */
public class TEscritura {
    
    TEnsayo te;
    TLectura tl;
    File file;
    BufferedWriter bw;
    public TEscritura(){
        tl = new TLectura();
        te = new TEnsayo();
    }
    
    public void newFIle( String name ,String Lotes, String Pruebas ) throws IOException{
        file = new File("data/"+name+".xml");
        bw = new BufferedWriter(new FileWriter("data/"+name+".xml"));
        ArrayList<ArrayList> index  = new ArrayList();
        ArrayList<String> meta  = new ArrayList();
        ArrayList<String> test  = new ArrayList();
        java.util.Date fecha = new Date();
        meta.add(name);
        meta.add(fecha.toString());
        meta.add(Lotes);
        meta.add(Pruebas);
        test.add("0");
        test.add("0");
        test.add("0");
        test.add("0");
        test.add("0");
        test.add("0");
        test.add("Iniciar");
        index.add(meta);
        index.add(test);
        te.add(index);
        te.GuardarXml(bw);
    }
    
    public void writeInFile( String data  ) throws IOException{
        ArrayList<ArrayList> datos = new ArrayList<>();
        datos = tl.ReadXML(data);
        System.out.println("tamaño actual: " + datos.size());
        System.out.println("tamaño actual: " + datos.get(1));
    }
    public void  saveTest( ArrayList data ) throws IOException{
        ArrayList<ArrayList> datos = new ArrayList<>();
        datos = tl.ReadXML((String) data.get(0)+".xml");
        
        if ( datos.size() > 1 ) {
            for (int i = 1; i < datos.size(); i++) {
                System.out.println("datos: " + datos.get(i).get(1));
                if ( datos.get(i).get(1).equals( data.get(3) ) ) {
                    
                }
            }
        }else{
            System.out.println("Solo hay " + datos.size() + " nodos");
        }
        
        
        
        
    }
    
    
}
