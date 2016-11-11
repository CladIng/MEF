package logica;

import java.io.BufferedWriter;

/**
 *
 * @author cesar
 */
public class TPrueba extends TGuardarXml{
 private int    IdPrueba;
 private int    IdLote;
 private float  Fuerza; 
 private float  Diametro ;
 private float  Momento ;
 private float  Esfuerzo; 
 private float  Ciclos; 
 private float  Tiempos ;
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
   GuardarEtiqueta("Tiempos", Tiempos, bw);
   GuardarEtiqueta("Estado", Estado, bw);
   GuardarLinea(" </Prueba>",bw);
  }

    public int getIdPrueba() {
        return IdPrueba;
    }

    public void setIdPrueba(int IdPrueba) {
        this.IdPrueba = IdPrueba;
    }

    public int getIdLote() {
        return IdLote;
    }

    public void setIdLote(int IdLote) {
        this.IdLote = IdLote;
    }

    public float getFuerza() {
        return Fuerza;
    }

    public void setFuerza(float Fuerza) {
        this.Fuerza = Fuerza;
    }

    public float getDiametro() {
        return Diametro;
    }

    public void setDiametro(float Diametro) {
        this.Diametro = Diametro;
    }

    public float getMomento() {
        return Momento;
    }

    public void setMomento(float Momento) {
        this.Momento = Momento;
    }

    public float getEsfuerzo() {
        return Esfuerzo;
    }

    public void setEsfuerzo(float Esfuerzo) {
        this.Esfuerzo = Esfuerzo;
    }

    public float getCiclos() {
        return Ciclos;
    }

    public void setCiclos(float Ciclos) {
        this.Ciclos = Ciclos;
    }

    public float getTiempos() {
        return Tiempos;
    }

    public void setTiempos(float Tiempos) {
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
