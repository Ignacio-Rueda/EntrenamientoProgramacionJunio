package Ejercicio_6_RecuentoDePalabras;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test {
    public static void main(String args[]){
        Scanner teclado = new Scanner (System.in);
        String rutaFichero = System.getProperty("user.dir")+File.separator+"src"+File.separator+"Ejercicio6_RecuentoDePalabras";
        String nombreFichero="";
        String arrayCadena[];
        boolean entradaCorrecta = false;
        Map<String,Integer> mapaRecuento = new TreeMap<>();
        Map<String,Integer> mapaDeserializado;
        final String patron = "( {0,}[a-z]{1,} {0,}){1,}";
        final String patronSeparacion = " {1,}";
        String cadena ="";
        //cadena="uno dos uno dos tres cuatro cinco seis siete uno uno dos uno";
        
        //Entrada de datos
       while(!entradaCorrecta){
            System.out.println("Introduce un texto sólo con palabras (caracteres alfabéticos en minúsculas de al menos longitud uno) separadas por espacios: ");
            cadena = teclado.nextLine();
            if(cadena.matches(patron)){
                System.out.println("Introduce el nombre del archivo donde deseas almacenar el recuento: ");
                nombreFichero = teclado.nextLine();
                rutaFichero+=File.separator+nombreFichero;
                entradaCorrecta = true;
            }
        }
        
        //Procesamiento
        arrayCadena = cadena.split(patronSeparacion);
        for(int n=0;n<arrayCadena.length;n++){
            String clave = arrayCadena[n];
            if(!mapaRecuento.containsKey(clave)){
                mapaRecuento.put(clave, 0);
            }
            mapaRecuento.put(clave, mapaRecuento.get(clave)+1);
        }
    
        //Almacenar valores en fichero binario (Serializar)
        File fichero = new File(rutaFichero);
        try(ObjectOutputStream guardarFichero = new ObjectOutputStream(new FileOutputStream(rutaFichero))){
            guardarFichero.writeObject(mapaRecuento);
            guardarFichero.flush();
            System.out.printf("Recuento volcado en archivo %s%n",nombreFichero);
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        //Mostrar valores del fichero (Deserializar)
        
        try(ObjectInputStream leerFichero = new ObjectInputStream(new FileInputStream(fichero))){
            mapaDeserializado = (Map<String,Integer>)leerFichero.readObject();
            System.out.println("Mostrar datos, tras deserializar el fichero...");
            for(Map.Entry<String,Integer> claveValor:mapaDeserializado.entrySet()){
                System.out.printf("El término: %-6s Se repite-> %d %s%n",claveValor.getKey(),claveValor.getValue(),claveValor.getValue()>1?"veces":"vez");
            }
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    
    }
    
}
