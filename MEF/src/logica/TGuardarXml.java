
package logica;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Clase para escribir linea a linea en el xml
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
 /**
  * Guarda una linea <Nodo>Valor</Nodo>
  * @param Nombre
  * @param Valor
  * @param bw 
  */
 public void GuardarEtiqueta(String Nombre,Object Valor,BufferedWriter bw){
  GuardarLinea("<" + Nombre + ">"+Valor + "</" + Nombre + ">",bw);
 }
 /**
  * Agrega atributos a nodos <Nodo atributo="valor" >Valor</Nodo>
  * @param Nombre
  * @param Valor
  * @return 
  */
 public String ValorAtributo(String Nombre,Object Valor){
  return " " + Nombre+"=\""+Valor+ "\" ";   
 }
 
 public abstract void GuardarXml(BufferedWriter bw);
    
}
