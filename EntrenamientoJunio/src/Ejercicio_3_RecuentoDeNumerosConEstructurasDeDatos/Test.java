
package Ejercicio_3_RecuentoDeNumerosConEstructurasDeDatos;



public class Test {
    public static void main(String args[]){
        //100000 1 20 1 1 100 100 101 999999999 999 100 99999999999 999999999   9999999999 999999999
        //String patron = "( {0,}[0-9]{1,12} {0,}){1,}";
        String patron = "( {0,}([1-9][0-9]{0,11}|0) {0,}){1,}";
        String cadenaEntrada ="100000 1 20 1 1 100 100 101 999999999 999 100 99999999999 999999999   9999999999 999999999 0 ";
        System.out.println(cadenaEntrada.matches(patron));
    
    
    }
    
}
