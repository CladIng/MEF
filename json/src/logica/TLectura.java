package logica;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author cesar
 */
public class TLectura {
    
    
    public int statusTest( String test, String parm1, String parm2 ) throws IOException{
        /*File archivo = new File("data.xml");
        BufferedWriter bw = new BufferedWriter(new FileWriter("data .xml"));*/
        int flag=0;
        try{
            File xml = new File(test);
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(xml);
            //System.out.println("Root element :" + document.getRootElement().getName());
            
            Element classElement = document.getRootElement();
            
            List<Element> Pruebas = classElement.getChildren("Prueba");
            
            for( int index = 0; index < Pruebas.size() ; index++ ){
                Element Prueba = Pruebas.get(index);
                if( Prueba.getChildText(parm1).equals(parm2) ){
                    flag++;
                }
                //System.out.println("Ciclos de la prueba "+index+" es: "+Prueba.getChildText("Ciclos"));
            }
            return flag;
        }catch( JDOMException e ){
            e.printStackTrace();
            return 0;
        }
        
    }

    /**
     *
     * @param test
     * @param parm1
     * @param parm2
     * @return
     * @throws IOException
     */
    public String dataObjet( String test, String objet) throws IOException{
        /*File archivo = new File("data.xml");
        BufferedWriter bw = new BufferedWriter(new FileWriter("data .xml"));*/
        String data = "";
        try{
            File xml = new File(test);
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(xml);
            //System.out.println("Root element :" + document.getRootElement().getName());
            
            Element classElement = document.getRootElement();
            
            List<Element> Pruebas = classElement.getChildren("Prueba");
            
            for( int index = 0; index < Pruebas.size() ; index++ ){
                Element Prueba = Pruebas.get(index);
                data = Prueba.getChild(objet).getText();
                //System.out.println("Ciclos de la prueba "+index+" es: "+Prueba.getChildText("Ciclos"));
            }
            return data;
        }catch( JDOMException e ){
            e.printStackTrace();
            return data;
        }
        
    }
    
    public ArrayList  allTests(){
        // Aquí la carpeta que queremos explorar
        String path = "data/"; 
        String file;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles(); 
        ArrayList files = new ArrayList();
        for (int i = 0; i < listOfFiles.length; i++) 
        {
            if (listOfFiles[i].isFile()) 
            {
                file = listOfFiles[i].getName();
                if (file.endsWith(".xml") || file.endsWith(".XML"))
                {
                    files.add(file);
                }
            }
        }
        return files;
    }
    
    public ArrayList  ciclosYFuerzas( String name ) throws IOException{
        // Aquí la carpeta que queremos explorar
        String path = "ensayos/"; 
        String Dir;
        String file;
        File tests = new File(path);
        File[] listOfTests = tests.listFiles();
        ArrayList<ArrayList> files = new ArrayList();
        ArrayList<String> ciclos = new ArrayList();
        ArrayList<String> fuerzas = new ArrayList();
        for (int i = 0; i < listOfTests.length; i++) 
        {
            if (listOfTests[i].isDirectory())
            {
                Dir = listOfTests[i].getName();
                if (Dir.equals(name)) {
                    File pruebas = new File(path+Dir);
                    File[] listaDePruebas = pruebas.listFiles();
                    for (int j = 0; j < listaDePruebas.length; j++) {
                        if (listaDePruebas[j].isFile()) {
                            file = listaDePruebas[j].getName();
                            if (file.endsWith(".xml") || file.endsWith(".XML")){
                                ciclos.add(dataObjet(path+Dir+"/"+file,"Ciclos"));
                                fuerzas.add(dataObjet(path+Dir+"/"+file,"Fuerza"));
                            }
                        }
                    }
                }
            }
        }
        files.add(ciclos);
        files.add(fuerzas);
        for (int i = 0; i < files.size(); i++) {
            for (int j = 0; j < files.get(i).size(); j++) {
                System.out.println("datos array " + i + " : " + files.get(i).get(j));
            }
        }
        return files;
    }
    
    public ArrayList  allTestsNF(  ) throws IOException{
        // Aquí la carpeta que queremos explorar
        String path = "ensayos/"; 
        String Dir;
        String file;
        File tests = new File(path);
        File[] listOfTests = tests.listFiles();
        ArrayList<String> files2 = new ArrayList();
        if (listOfTests.length>0) {
            ArrayList<String> files = new ArrayList();
            for (int i = 0; i < listOfTests.length; i++) 
            {
                if (listOfTests[i].isDirectory()) 
                {
                    Dir = listOfTests[i].getName();
                    File pruebas = new File(path+Dir);
                    File[] listaDePruebas = pruebas.listFiles();

                    for (int j = 0; j < listaDePruebas.length; j++) {
                        if (listaDePruebas[j].isFile()) {
                            file = listaDePruebas[j].getName();
                            if (file.endsWith(".xml") || file.endsWith(".XML")){
                                if (statusTest(path+Dir+"/"+file,"Estado","Pendiente")>0) {
                                    files.add(Dir);        
                                }
                            }
                        }
                    }


                }
            }
            
            files2.add(files.get(0));
            for (int i = 0; i < files.size(); i++) {
                for (int j = 0; j < files2.size(); j++) {
                    if ( !files2.get(j).equals(files.get(i)) ) {
                        files2.add(files.get(i));
                    }
                }
            }
        }
        
        return files2;
    }
   
    public ArrayList ReadXML( String file ) throws IOException{
        
        ArrayList<ArrayList> data  = new ArrayList<ArrayList>();
        try {
         File inputFile = new File(file);

         SAXBuilder saxBuilder = new SAXBuilder();

         Document document = saxBuilder.build(inputFile);

         Element classElement = document.getRootElement();

         /**
          * Empezar a leer el xml apartir del root
          */        
        ArrayList<String> meta  = new ArrayList<String>();
         
         List<Element> testList = classElement.getChildren();
        /**
         * Obteniendo los valores del meta
         */
         Element metaXML = testList.get(0);
         Attribute name =  classElement.getAttribute("Nombre");
         meta.add(name.getValue());
         meta.add(metaXML.getChild("Fecha").getText());
         meta.add(metaXML.getChild("Lotes").getText());
         meta.add(metaXML.getChild("Pruebas").getText());
         data.add(meta);
         for (int temp = 1; temp < testList.size(); temp++) {
            ArrayList<String> test  = new ArrayList<>();
            Element tests = testList.get(temp);
            Attribute idLote =  tests.getAttribute("IdLote");
            Attribute idPrueba =  tests.getAttribute("IdPrueba");
            test.add(idLote.getValue());
            test.add(idPrueba.getValue());
            test.add(tests.getChild("Fuerza").getText());
            test.add(tests.getChild("Diametro").getText());
            test.add(tests.getChild("Momento").getText());
            test.add(tests.getChild("Esfuerzo").getText());
            test.add(tests.getChild("Ciclos").getText());
            test.add(tests.getChild("Tiempo").getText());
            test.add(tests.getChild("Estado").getText());
            data.add(test);
         }
//        for( int i = 0; i < data.size(); i++ ){
//            for( int j = 0; j < data.get(i).size(); j++ ){
//                System.out.println("datos: " + data.get(i).get(j));
//            }
//        }
        return data;
      }catch( Exception e ){
            System.out.println("Ocurrio un error: " + e.getMessage() + " OK.");
            return data;
      }
        
    }
    
}
