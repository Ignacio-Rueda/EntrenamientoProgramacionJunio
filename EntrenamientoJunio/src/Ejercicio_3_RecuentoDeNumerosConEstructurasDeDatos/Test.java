package Ejercicio_3_RecuentoDeNumerosConEstructurasDeDatos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

    public static void main(String args[]) {
        Map<Long,Integer> mapaRecuentos = new HashMap<>();
        boolean cadenaValida = false;
        Scanner teclado = new Scanner(System.in);
        String cadenaIntro = "";
        String patronCadenaEntrada = "( {0,}([1-9][0-9]{0,11}|0) {0,}){1,}";
        String patronSeparacion = " {1,}";
        //cadenaIntro = "100000 1 20 1 1 100 100 101 999999999 999 100 99999999999 999999999   9999999999 999999999 0 ";

        //Introducción cadena caracteres
        while (!cadenaValida) {
            System.out.println("Introduzca un conjunto de números naturales entre 1 y 12 cifras separados por uno o varios espacios en blanco (todos en la misma línea).");
            cadenaIntro = teclado.nextLine();
            if(cadenaIntro.matches(patronCadenaEntrada)){
                cadenaValida = true;
            }
        }
        //Procesar información
        String[] array = cadenaIntro.split(patronSeparacion);
        for (int n = 0; n < array.length; n++) {
            Long clave = Long.valueOf(array[n]);
            if(!mapaRecuentos.containsKey(clave)){
                mapaRecuentos.put(clave,0);
            }
            if(mapaRecuentos.containsKey(clave)){
                mapaRecuentos.put(clave, 1 + mapaRecuentos.get(clave));
            }
        }
        
        //Mostrar resultados
        System.out.println("Recuento de números:");
        for(Map.Entry<Long, Integer> recuentos : mapaRecuentos.entrySet()){
            System.out.printf("Número%15d ->%5d %s%n",recuentos.getKey(),recuentos.getValue(),recuentos.getValue()>1?"veces":"vez");
        }

    }

}
