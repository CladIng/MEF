package logica;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cesar
 */
public class TEnsayo extends TGuardarXml{
  private String Fecha;
  private TMeta Meta;
  private List<TPrueba> Pruebas;

  public TEnsayo() throws IOException{
   Fecha="9/11/2016";  
   Meta=new TMeta();
   Pruebas=new ArrayList<TPrueba>();
  }
  
  public void add( ){
       Meta.setLotes(2);
       Meta.setPruebas(5);
       Meta.setNombre("segunda prueba");
       TPrueba ObjPrueba = new TPrueba();
       ObjPrueba.setCiclos(23);
       ObjPrueba.setDiametro(43);
       ObjPrueba.setEsfuerzo(21);
       ObjPrueba.setEstado("continuara");
       ObjPrueba.setFuerza(344);
       ObjPrueba.setIdLote(2);
       ObjPrueba.setIdPrueba(3);
       ObjPrueba.setMomento(321);
       ObjPrueba.setResultado("Fail");
       ObjPrueba.setTiempos(3000);
       Pruebas.add(ObjPrueba);
       Pruebas.add(ObjPrueba);
       Pruebas.add(ObjPrueba);
  }
  
  
    @Override
    public void GuardarXml(BufferedWriter bw) {
     int i;   
     GuardarLinea("<?xml version=\"1.0\"?>", bw);
     GuardarLinea("<Ensayo " + ValorAtributo("Fecha",Fecha)+ ">",bw);
     Meta.GuardarXml(bw);
     for(i=0;i<Pruebas.size();i++){
      Pruebas.get(i).GuardarXml(bw);
     }
     GuardarLinea("</Ensayo>",bw);
    }
    
}
