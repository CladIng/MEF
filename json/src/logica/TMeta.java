
package logica;

import java.io.BufferedWriter;


/**
 *
 * @author cesar
 */
public class TMeta extends TGuardarXml{
 private String Fecha;
 private String Pruebas;
 private String Lotes;
 private String Metal;
 
 public TMeta(){
  Fecha   = "";
  Pruebas = "";
  Lotes   = "";
  Metal   = "";
 }

    public String getMetal() {
        return Metal;
    }

    public void setMetal(String Metal) {
        this.Metal = Metal;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getPruebas() {
        return Pruebas;
    }

    public void setPruebas(String Pruebas) {
        this.Pruebas = Pruebas;
    }

    public String getLotes() {
        return Lotes;
    }

    public void setLotes(String Lotes) {
        this.Lotes = Lotes;
    }
 
 
 
 public void GuardarXml(BufferedWriter bw){
  GuardarLinea(" <Meta>",bw);
  GuardarEtiqueta("Fecha",Fecha,bw);
  GuardarLinea("  <Lotes>" + Lotes +  "</Lotes>",bw);
  GuardarLinea("  <Pruebas>" + Pruebas + "</Pruebas>",bw);
  GuardarLinea("  <Metal>" + Metal + "</Metal>",bw);
  GuardarLinea(" </Meta>",bw);
 }
 
}
