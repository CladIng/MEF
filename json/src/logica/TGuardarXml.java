
package logica;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author cesar
 */
public abstract class TGuardarXml {
  
 public void GuardarLinea(String Linea,BufferedWriter bw){
  try {
   bw.write(Linea);
   bw.flush();
   bw.newLine();
  }catch(IOException Ex) {
    Ex.printStackTrace();
  }   
 }
 
 public void GuardarEtiqueta(String Nombre,Object Valor,BufferedWriter bw){
  GuardarLinea("<" + Nombre + ">"+Valor + "</" + Nombre + ">",bw);
 }
 
 public String ValorAtributo(String Nombre,Object Valor){
  return " " + Nombre+"=\""+Valor+ "\" ";   
 }
 
 
   
 public abstract void GuardarXml(BufferedWriter bw);
    
}
