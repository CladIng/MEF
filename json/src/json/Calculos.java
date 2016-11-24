
package json;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author cesar
 */
public class Calculos {
    
    
    
    int hora;
    int minutos;
    int segundos;
    float fuerza;
    float diametro;
    
    public Calculos( ){
        fuerza   = 0;
        diametro = 0;
        hora     = 0;
        minutos  = 0;
        segundos = 0;
    }
    
    public void timeStart(){
        Calendar calendario = new GregorianCalendar();
        hora     = calendario.get(Calendar.HOUR_OF_DAY);
        minutos  = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        calendario.clear();
    }
    public String getTiempo(){
        Calendar calendario2 = new GregorianCalendar();
        int hora_f     = calendario2.get(Calendar.HOUR_OF_DAY);
        int minutos_f  = calendario2.get(Calendar.MINUTE);
        int segundos_f = calendario2.get(Calendar.SECOND);
        int Hora_i     = (hora*3600)+(minutos*60)+segundos;
        int Hora_f     = (hora_f*3600)+(minutos_f*60)+segundos_f;
        int time_s     = Hora_f-Hora_i;
        int h,m,s;
        h=time_s/3600;
        m=(time_s-(3600*h))/60;
        s=time_s-((h*3600)+(m*60));
        calendario2.clear();
        return h+":"+m+":"+s;
        //return "Hora final: "+Hora_f+" Hora inicial: " + Hora_i + " Resta: " + time_s;
    }
    
    
    
    public float getFuerza() {
        return fuerza;
    }

    public void setFuerza(float fuerza) {
        this.fuerza = fuerza;
    }

    public float getDiametro() {
        return diametro;
    }

    public void setDiametro(float diametro) {
        this.diametro = diametro;
    }
    
    public float getMomento(){
        return fuerza+diametro;
    }
    public float getEsfuerzo(){
        return fuerza*diametro;
    }
    
}
