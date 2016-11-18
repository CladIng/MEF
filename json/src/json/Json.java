/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.io.IOException;

/**
 *
 * @author cesar
 */
public class Json {
    
    
    public static void main(String[] args) throws IOException{
        Inicio obj = new Inicio();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);


//TLectura obj = new TLectura();
        //JOptionPane.showMessageDialog(null, "Numero de ensayos: " + obj.allTests());
//        
//        File archivo = new File("data3.xml");
//        BufferedWriter bw = new BufferedWriter(new FileWriter("data3.xml"));
//        TEnsayo obj = new TEnsayo();
//        //obj.add();
//        obj.GuardarXml(bw);
        
        /*try{
            File xml = new File("data .xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(xml);
            System.out.println("Root element :" + document.getRootElement().getName());
            
            Element classElement = document.getRootElement();
            
            List<Element> Pruebas = classElement.getChildren("Prueba");
            String name = classElement.getChild("Meta").getChildText("Nombre");
            System.out.println("Nombre del ensayo: " + name);
            classElement.getChild("Meta").getChild("Nombre").setText("Tercer prueba");
            String name2 = classElement.getChild("Meta").getChildText("Nombre");
            System.out.println("Nombre del ensayo: " + name2);
            
            for( int index = 0; index < Pruebas.size() ; index++ ){
                Element Prueba = Pruebas.get(index);
                System.out.println("Ciclos de la prueba "+index+" es: "+Prueba.getChildText("Ciclos"));
            }
            
        }catch( JDOMException e ){
            e.printStackTrace();
        }
        
        
        
        
        
        */
        
        
        
        
    }
    
        
}
