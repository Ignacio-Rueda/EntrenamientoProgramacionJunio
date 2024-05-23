package Ejercicio_10_FechasValidasOrdenadas;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test {

    /**
     * Método que comprueba si una fecha es correcta.
     *
     * @param args
     */
    public boolean compruebaFecha(String fecha) {
        try {
            LocalDate compruebaFecha = LocalDate.parse(fecha);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String args[]) {
        //Declaración de variables
        final String FIN_PROGRAMA = "fin";
        Map<LocalDate, Integer> mapFechasOrdenadas = new TreeMap<>();
        Scanner teclado = new Scanner(System.in);
        Test test = new Test();
        int contador = 0;
        //Procesar
        String cadena = "";
        while (!cadena.equals(FIN_PROGRAMA)) {
            System.out.println("Escriba una fecha con el formato aaaa-mm-dd o fin para terminar");
            cadena = teclado.nextLine();
            System.out.printf("Fecha leída: %s%n", cadena);
            
            if (!cadena.equals(FIN_PROGRAMA)) {
                if (test.compruebaFecha(cadena)) {
                    mapFechasOrdenadas.put(LocalDate.parse(cadena), contador++);
                } else {
                    System.out.printf("Error de fecha  no válida: %s%n", cadena);
                }
            }
        }
        //Mostrar resultados
        for(Map.Entry<LocalDate,Integer> resultado : mapFechasOrdenadas.entrySet()){
            System.out.printf("Clave:%s , valor = %d%n",resultado.getKey(),resultado.getValue());
        }

    }

}
