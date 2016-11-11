/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedWriter;


/**
 *
 * @author cesar
 */
public class TMeta extends TGuardarXml{
 private String Nombre;
 private int Pruebas;
 private int Lotes;
 
 public TMeta(){
  Nombre="";
  Pruebas=0;
  Lotes=0;
 }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPruebas() {
        return Pruebas;
    }

    public void setPruebas(int Pruebas) {
        this.Pruebas = Pruebas;
    }

    public int getLotes() {
        return Lotes;
    }

    public void setLotes(int Lotes) {
        this.Lotes = Lotes;
    }
 
 
 
 public void GuardarXml(BufferedWriter bw){
  GuardarLinea(" <Meta>",bw);
  GuardarEtiqueta("Nombre",Nombre,bw);
  GuardarLinea("  <Lotes>" + Lotes +  "</Lotes>",bw);
  GuardarLinea("  <Pruebas>" + Pruebas + "</Pruebas>",bw);
  GuardarLinea(" </Meta>",bw);
 }
 
}
