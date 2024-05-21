
package Ejercicio_7_ClasificacionDeNumerosYtextosEnArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    
    public static void main(String args[]){
        final String separador = File.separator;
        final String rutaFichero = System.getProperty("user.dir")+separador+"src"+separador+"Ejercicio_7_ClasificacionDeNumerosYtextosEnArchivos"+separador+"archivoTexto.txt";
        final String rutaFicheroEnteros = System.getProperty("user.dir")+separador+"src"+separador+"Ejercicio_7_ClasificacionDeNumerosYtextosEnArchivos"+separador+"archivoEnteros.txt";
        final String rutaFicheroCadenas = System.getProperty("user.dir")+separador+"src"+separador+"Ejercicio_7_ClasificacionDeNumerosYtextosEnArchivos"+separador+"archivoCadenas.txt";
   
        List<Integer> listaEnteros = new ArrayList<>();
        List<String> listaCadenas = new ArrayList<>();
        //Lectura fichero
        try(BufferedReader br = new BufferedReader(new FileReader(rutaFichero))){
            String cadena = "";
            while((cadena=br.readLine()) != null){
                if(isNumero(cadena)){
                    listaEnteros.add(Integer.parseInt(cadena));
                }else{
                    listaCadenas.add(cadena);
                }
            }
            
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        //Escribir en fichero

        try(PrintWriter pwE = new PrintWriter(rutaFicheroEnteros);PrintWriter pwC = new PrintWriter(rutaFicheroCadenas)){
            Iterator itE = listaEnteros.iterator();
            while(itE.hasNext()){
                pwE.println(itE.next().toString());
            }
            pwE.flush();
            Iterator itC = listaCadenas.iterator();
            while(itC.hasNext()){
                pwC.println(itC.next().toString());
            }
            pwC.flush();
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        
    
    }
    
    public static boolean isNumero(String valor){
        try{
            Integer.parseInt(valor);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }
    
}
