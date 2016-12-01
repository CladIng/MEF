/**
 * Codigo para el sensor de Peso
 */
#include <HX711.h>

#define DOUT  A1
#define CLK  A0

HX711 balanza(DOUT, CLK);

/**
 * Codigo para el sensor de Vueltas
 */
int estadoActual1=0;
int estadoActual2=0;
int estadoUltimo=0;
int contador=0;


/**
 * Codigo extra
 */
int estado;
int timer = 0;
bool flag=false;
bool inicio=true;

 
//HX711 balanza(DOUT, CLK);

void setup() {
  Serial.begin(9600);
  
  /**
   * Codigo para el sensor de Peso
   */
  // Lectura del valor del sensor de peso
  balanza.read();
  //No ponga ningun  objeto sobre la balanza
  // Establecemos la escala
  balanza.set_scale(439430.25);
  //El peso actual es considerado Tara.
  balanza.tare(20);

  /**
   * Codigo para el sensor de vueltas
   */
  pinMode(3,INPUT);
  pinMode(12,OUTPUT);
  digitalWrite(12,HIGH);

  // relay
  pinMode(9,OUTPUT);
  digitalWrite(9,HIGH);
}


void loop() {


  /*
   * sensor2 -> ciclos
   * sensor1 -> fuerza
   */
  if(Serial.available()>0){
    estado = Serial.read();
    //Serial.print(estado);
  }

  
    
  if( estado == '1' ){
    inicio = false;
    // Señal para prender la maquina
    digitalWrite(9,LOW);
    
    estadoActual1=digitalRead(3);
    delay(10);
    estadoActual2=digitalRead(3);
    //Si los estados no son iguales, el sketch no hace nada.
    if (estadoActual1 == estadoActual2) {
      if (estadoActual1 != estadoUltimo){
        if (estadoActual1 == HIGH) {
          //contador = contador + 1;
          // Se manda el numero de vueltas  
        }
      }
    }
    estadoUltimo= estadoActual1;
    timer++;
    if( timer>50 && flag == false ){
      
      //Se manda el valor del peso actual
      Serial.print(balanza.get_units(20),3);
  
      // Se concatenan los dos valores
      Serial.print("&");

      //Se manda el numero de vueltas
      //Serial.println(contador);
      Serial.println(60);

      timer=0;
      flag=true;
    }
    if( timer>300 ){
      //Se manda el valor del peso actual
      Serial.print(balanza.get_units(20),3);
  
      // Se concatenan los dos valores
      Serial.print("&");

      //Se manda el numero de vueltas
      //Serial.println(contador);
      Serial.println(60);
      timer=0;
    }

  }else{
    if( estado == '0'){
      flag = false;
      contador = 0;
      timer=0;
      inicio = true;
      // Señal para apagar la maquina
      digitalWrite(9,HIGH);
    }
    
  }
  if( inicio==true ){
      //Se manda el valor del peso actual
      Serial.print(balanza.get_units(20),3);
  
      // Se concatenan los dos valores
      Serial.print("&");

      //Se manda el numero de vueltas
      //Serial.println(contador);
      Serial.println("null");
      delay(200);
    }

}

