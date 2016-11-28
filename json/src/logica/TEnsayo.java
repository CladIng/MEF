package logica;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cesar
 */
public class TEnsayo extends TGuardarXml{
  private String Nombre;
  private TMeta Meta;
  private List<TPrueba> Pruebas;

  public TEnsayo(){
   Nombre  = "9/11/2016";  
   Meta    = new TMeta();
   Pruebas = new ArrayList();
  }
    
    public void add( ArrayList<ArrayList> data ){
        Nombre = data.get(0).get(0).toString();
        Meta.setFecha(data.get(0).get(1).toString());
        Meta.setLotes((String) data.get(0).get(2));
        Meta.setPruebas((String) data.get(0).get(3));
        Meta.setMetal((String) data.get(0).get(4));
        TPrueba ObjPrueba = new TPrueba();
        for (int i = 1; i < data.size(); i++) {
            ObjPrueba.setIdLote(data.get(i).get(0).toString());
            ObjPrueba.setIdPrueba(data.get(i).get(1).toString());
            ObjPrueba.setFuerza( data.get(i).get(2).toString());
            ObjPrueba.setDiametro( data.get(i).get(3).toString());
            ObjPrueba.setMomento( data.get(i).get(4).toString());
            ObjPrueba.setEsfuerzo( data.get(i).get(5).toString());
            ObjPrueba.setCiclos( data.get(i).get(6).toString());
            ObjPrueba.setTiempos(data.get(i).get(7).toString());
            ObjPrueba.setEstado(data.get(i).get(8).toString());
            Pruebas.add(ObjPrueba);
        }
        ObjPrueba = null;
    }
  
  
    @Override
    public void GuardarXml(BufferedWriter bw) {
     int i;   
     GuardarLinea("<?xml version=\"1.0\"?>", bw);
     GuardarLinea("<Ensayo " + ValorAtributo("Nombre",Nombre)+ ">",bw);
     Meta.GuardarXml(bw);
     for(i=0;i<Pruebas.size();i++){
      Pruebas.get(i).GuardarXml(bw);
     }
     GuardarLinea("</Ensayo>",bw);
     Pruebas.clear();
    }
    
}
