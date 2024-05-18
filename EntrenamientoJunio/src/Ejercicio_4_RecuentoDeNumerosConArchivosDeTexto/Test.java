package Ejercicio_4_RecuentoDeNumerosConArchivosDeTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test {

    public static void main(String args[]) {
        Map<Integer, String> mapaResultados = new TreeMap<>();
        String rutaFichero = System.getProperty("user.dir") + File.separator + "src" + File.separator + "RecuentoDeNumerosConArchivosDeTexto" + File.separator + "archivoDeTexto.txt";
        File fichero = new File(rutaFichero);
        boolean entradaCorrecta = false;
        String cadenaEntrada = "";
        Scanner teclado = new Scanner(System.in);
        String patronEntrada = "( {1,}(0|[1-9]|[1-9][0-9])|(0|[1-9]|[1-9][0-9]))(( {1,}(0|[1-9]|[1-9][0-9])){0,}|( {1,}(0|[1-9]|[1-9][0-9]) {1,}){0,})";
        String patronSeparador = " {1,}";
        //String entrada = "     1  2          3 4 10 20 10 10 10 20 30   99 50 51  50 99 1 99";

        //Solicitar datos
        while(!entradaCorrecta){
            System.out.println("Introduce una cadena de texto sólo con números entre 0 y 99 separados por espacios en blanco:");
            cadenaEntrada = teclado.nextLine();
            if(cadenaEntrada.matches(patronEntrada)){
                entradaCorrecta=true;
            }
        }
        String[] arraySplit = cadenaEntrada.trim().split(patronSeparador);

        //Recorremos el array con los números obtenidos de la entrada
        for (String numero : arraySplit) {
            int clave = Integer.valueOf(numero);
            if (!mapaResultados.containsKey(clave)) {
                mapaResultados.put(clave, "");
            }
            mapaResultados.put(clave, mapaResultados.get(clave).concat("*"));

        }

        //Introducimos datos en fichero
        try (PrintWriter pw = new PrintWriter(new FileWriter(fichero,false))) {//Podría poner solo el fichero, pero utlizando FileWriter, podemos indicar si seguimo añadiendo datos en el fichero o borra e inserta datos en cada ejecución
            pw.write("Recuento de números:\n");
            pw.write("Lista:"+cadenaEntrada+"\n");
            for(Map.Entry<Integer,String> claveValor : mapaResultados.entrySet()){
                pw.write(String.format("Número %d: %s%n",
                        claveValor.getKey(),
                            claveValor.getValue()
                        ));
            }
            pw.flush();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }

}
