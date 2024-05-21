
package Ejercicio_9_PatronesOctalYhexadecimal;

import java.util.Arrays;


public class Test {
    
    public static void main(String args[]){
    // El sistema octal usa 8 dígitos (0, 1, 2, 3, 4, 5, 6, 7) y cada dígito tiene el mismo valor que en el sistema de numeración decimal
    // El sistema hexadecimal usa los números 0 - 9 y las letras A, B, C, D, E y F. 
    String[] arrayEntrada = {"AF", "AB2345G", "0123456789", "BXA31969", "YHK969", "XQ-1970","FFH", "YV-2021", "007", "9A", "77A", "YH", "XB", "00776"};
    String patronOctal = "[0-7]{1,}";
    int contadorOctal = 0;
    int contadorHexadecimal = 0;
    String patronHexadecimal = "[0-9]{1,}|[0-9]{1,}[A-F]{1,}|[A-F]{1,}[0-9]{1,}|[A-F]{1,}[0-9]{1,}[A-F]{1,}|[A-F]{1,}";
    System.out.println("VALIDADOR DE NÚMEROS octales y hexadecimales");
        System.out.println("----------------------------------------------");
        System.out.println("Lista de números de prueba:");
        System.out.println(Arrays.toString(arrayEntrada));
    for(String pos:arrayEntrada){
        String cadena = pos;
        if(cadena.matches(patronOctal)){
            System.out.println("Cadena octal:"+cadena);
            contadorOctal++;
        }else if(cadena.matches(patronHexadecimal)){
            System.out.println("Cadena hexadecimal:"+cadena);
            contadorHexadecimal++;
        }
    }
        System.out.println("\nTotales");
        System.out.println("-------");
        System.out.println("Total números octales: "+contadorOctal);
        System.out.println("Total números hexadecimales: "+contadorHexadecimal);
        
    
    }
    
}
