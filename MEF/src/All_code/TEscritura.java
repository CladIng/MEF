
package All_code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
    
    public void newFIle( String name ,String Lotes, String Pruebas, String Metal ) throws IOException{
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
                meta.add(Metal);
                
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
    }
    /**
     * Indica que Lote o Prueba es la siguiente
     * @param L
     * @param P
     * @param cL
     * @param cP
     * @return 
     */
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
    /**
     * Etiqueta la Prueba como terminada
     * @param name
     * @param lote
     * @param prueba
     * @param lote_i
     * @param prueba_i
     * @return
     * @throws IOException 
     */
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
    /**
     * Guarda la Prueba actual en el .xml correspondiente
     * @param data
     * @throws IOException 
     */
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
        
        BufferedWriter bw2 = new BufferedWriter(new FileWriter("ensayos/"+data.get(0)+"/"+data.get(3)+"_"+data.get(4)+".xml"));
        //newFIle(data.get(0).toString(), data.get(1).toString(), data.get(2).toString());
        te.add(dataReaded);
        te.GuardarXml(bw2);
        
    }
    
    
}
