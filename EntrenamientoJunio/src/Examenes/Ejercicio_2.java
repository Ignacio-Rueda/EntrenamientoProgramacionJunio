
package Examenes;

import java.time.LocalDate;
import java.util.Arrays;



public class Ejercicio_2 {
    
    public static void main(String args[]){
        String[] arrayFechasCadenas = {"2018-10-30", "2019-20-23", "2022-03-17", "2021-11-30", "2022-01-33", "2022-02-29"};
        LocalDate[] arrayResultado = new LocalDate[arrayFechasCadenas.length];
        System.out.println("CONTENIDO INICIAL DEL ARRAY DE FECHAS");
        System.out.println("-------------------------------------");
        System.out.println(Arrays.toString(arrayFechasCadenas));
        //Si la fecha es válida, introducir en el arrayResultado
        for(int i=0;i<arrayFechasCadenas.length;i++){
            try{
                LocalDate conversionFecha = LocalDate.parse(arrayFechasCadenas[i]);
                arrayResultado[i]=conversionFecha;
                
            }catch(Exception ex){
                System.out.println("Error de fecha no válida:"+arrayFechasCadenas[i]);
                arrayResultado[i]=LocalDate.now().plusDays(i);//Si la cadena no es una fecha válida, entonces introducirá la fecha de hoy más el número de días correspondientes al contador del bucle.
            }
        }
        
        System.out.println("CONTENIDO FINAL DEL ARRAY DE FECHAS");
        System.out.println("-----------------------------------");
        System.out.println(Arrays.toString(arrayResultado));
    }
    
}
