package logica;

import java.io.BufferedWriter;

/**
 *
 * @author cesar
 */
public class TPrueba extends TGuardarXml{
 private String IdPrueba;
 private String IdLote;
 private String  Fuerza; 
 private String  Diametro ;
 private String  Momento ;
 private String  Esfuerzo; 
 private String  Ciclos; 
 private String Tiempos ;
 private String Estado; 
 private String Resultado;   

 @Override
 public void GuardarXml(BufferedWriter bw) {
   String Atr1=ValorAtributo("IdPrueba",IdPrueba);
   String Atr2=ValorAtributo("IdLote",IdLote); 
   GuardarLinea(" <Prueba" + Atr1 + Atr2 + ">",bw);
   GuardarEtiqueta("Fuerza", Fuerza, bw);
   GuardarEtiqueta("Diametro", Diametro, bw);
   GuardarEtiqueta("Momento", Momento, bw);
   GuardarEtiqueta("Esfuerzo", Esfuerzo, bw);
   GuardarEtiqueta("Ciclos", Ciclos, bw);
   GuardarEtiqueta("Tiempo", Tiempos, bw);
   GuardarEtiqueta("Estado", Estado, bw);
   GuardarLinea(" </Prueba>",bw);
  }

    public String getIdPrueba() {
        return IdPrueba;
    }

    public void setIdPrueba(String IdPrueba) {
        this.IdPrueba = IdPrueba;
    }

    public String getIdLote() {
        return IdLote;
    }

    public void setIdLote(String IdLote) {
        this.IdLote = IdLote;
    }

    public String getFuerza() {
        return Fuerza;
    }

    public void setFuerza(String Fuerza) {
        this.Fuerza = Fuerza;
    }

    public String getDiametro() {
        return Diametro;
    }

    public void setDiametro(String Diametro) {
        this.Diametro = Diametro;
    }

    public String getMomento() {
        return Momento;
    }

    public void setMomento(String Momento) {
        this.Momento = Momento;
    }

    public String getEsfuerzo() {
        return Esfuerzo;
    }

    public void setEsfuerzo(String Esfuerzo) {
        this.Esfuerzo = Esfuerzo;
    }

    public String getCiclos() {
        return Ciclos;
    }

    public void setCiclos(String Ciclos) {
        this.Ciclos = Ciclos;
    }

    public String getTiempos() {
        return Tiempos;
    }

    public void setTiempos(String Tiempos) {
        this.Tiempos = Tiempos;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }
 
  
 
}
