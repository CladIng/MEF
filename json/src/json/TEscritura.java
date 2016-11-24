
package json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
        File directorio=new File("ensayos"); 
        directorio.mkdir();
        File ensayo = new File("ensayos/"+name+"/"); 
        ensayo.mkdirs();
        int lotes = Integer.parseInt(Lotes);
        int pruebas = Integer.parseInt(Pruebas);
        for (int i = 1; i < lotes+1; i++) {
            for (int j = 1; j < pruebas+1; j++) {
                File prueba = new File("ensayos/"+name+"/"+i+"_"+j+".xml"); 
                bw = new BufferedWriter(new FileWriter(prueba));
                ArrayList<ArrayList> index  = new ArrayList();
                ArrayList<String> meta  = new ArrayList();
                ArrayList<String> test  = new ArrayList();
                java.util.Date fecha = new Date();
                meta.add(name);
                meta.add(fecha.toString());
                meta.add(Lotes);
                meta.add(Pruebas);

                index.add(meta);
                test.add(i+"");
                test.add(j+"");
                test.add("");
                test.add("");
                test.add("");
                test.add("");
                test.add("");
                test.add("");
                test.add("Pendiente");
                index.add(test);
                te.add(index);
                te.GuardarXml(bw);
            }
        }
        /*file = new File("data/"+name+".xml");
        bw = new BufferedWriter(new FileWriter("data/"+name+".xml"));
        ArrayList<ArrayList> index  = new ArrayList();
        ArrayList<String> meta  = new ArrayList();
        ArrayList<String> test  = new ArrayList();
        java.util.Date fecha = new Date();
        meta.add(name);
        meta.add(fecha.toString());
        meta.add(Lotes);
        meta.add(Pruebas);
        
        index.add(meta);
        test.add("1");
        test.add("1");
        test.add("");
        test.add("");
        test.add("");
        test.add("");
        test.add("");
        test.add("");
        test.add("Pendiente");
        index.add(test);
        te.add(index);
        te.GuardarXml(bw);*/
    }
    
    public void newTest( String name ,String Lotes, String Pruebas ) throws IOException{
        
        for (int i = 0; i < 3; i++) {
            FileWriter folder = new FileWriter("ensayos/file"+i+".xml");
        }
        bw = new BufferedWriter(new FileWriter("data/"+name+".xml"));
        ArrayList<ArrayList> index  = new ArrayList();
        ArrayList<String> meta  = new ArrayList();
        ArrayList<String> test  = new ArrayList();
        java.util.Date fecha = new Date();
        meta.add(name);
        meta.add(fecha.toString());
        meta.add(Lotes);
        meta.add(Pruebas);
        
        index.add(meta);
        test.add("1");
        test.add("1");
        test.add("");
        test.add("");
        test.add("");
        test.add("");
        test.add("");
        test.add("");
        test.add("Pendiente");
        index.add(test);
        te.add(index);
        te.GuardarXml(bw);
    }
    
    public int[] position(int L, int P,int cL,int cP){
       int[] v={0,0};
       if(P<cP && L<cL){
        v[0] = L;
        v[1] = P+1;
       }
       if(cP==P && L<cL){
           v[0]=L+1;
           v[1]=1;
       }
       if(P<cP && L==cL){
           v[0] = L;
           v[1] = P+1;
       }
       if(P==cP && cL==L){
           v[0]=cL;
           v[1]=cP;
       }
       return v;
   }
    
    public boolean endTest( String name, String lote, String prueba ,String lote_i, String prueba_i ) throws IOException{
        ArrayList<ArrayList> dataReaded = new ArrayList<>();
        String file = "ensayos/"+name+"/"+lote_i+"_"+prueba_i+".xml";
        dataReaded = tl.ReadXML(file);
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(file));
        
        // VERIFICAR SI EL ENSAYO LLEGO A SU FIN
        int lote_inicial = Integer.parseInt(lote_i);
        int prueba_inicial = Integer.parseInt(prueba_i);
        int lotes = Integer.parseInt(lote);
        int pruebas = Integer.parseInt(prueba);
        dataReaded.get(dataReaded.size()-1).set(8, "Terminado");
        te.add(dataReaded);
        te.GuardarXml(bw2);
        if ( (lote_inicial*prueba_inicial) != (lotes*pruebas)) {
            return false;
        }else{
            JOptionPane.showMessageDialog(null, "¡Ensayo Terminado!");
            return true;
        }
    }
    
    public void  saveTest( ArrayList data ) throws IOException{
        
        ArrayList<ArrayList> dataReaded = new ArrayList<>();
        ArrayList<String> test = new ArrayList<>();
        dataReaded = tl.ReadXML("ensayos/"+data.get(0)+"/"+data.get(3)+"_"+data.get(4)+".xml");
        
        test.add( data.get( 3).toString() );
        test.add( data.get( 4).toString() );
        test.add( data.get( 5).toString() );
        test.add( data.get( 6).toString() );
        test.add( data.get( 7).toString() );
        test.add( data.get( 8).toString() );
        test.add( data.get( 9).toString() );
        test.add( data.get(10).toString() );
        test.add( data.get(11).toString() );
        
        
        dataReaded.remove(dataReaded.size()-1);
        dataReaded.add(test);
        
        
        
//
//        for (int i = 1; i < dataReaded.size(); i++) {
//            if ( dataReaded.get(i).get(8).equals( "Pendiente" ) ) {
//                System.out.println("Halle el nodo compatible");
//                dataReaded.remove(i);
//                dataReaded.add(test);
//            }else{
//    //                System.err.println("NOOOO son iguales: " + dataReaded.get(i).get(1) + " y " + data.get(3));
//            }
//        }

        BufferedWriter bw2 = new BufferedWriter(new FileWriter("ensayos/"+data.get(0)+"/"+data.get(3)+"_"+data.get(4)+".xml"));
        //newFIle(data.get(0).toString(), data.get(1).toString(), data.get(2).toString());
        te.add(dataReaded);
        te.GuardarXml(bw2);
        
    }
    
    
}