package Examenes;

public class Ejercicio_1 {

    public static void main(String args[]) {
        /**
         * El sistema binario es un sistema que solo utiliza dos cifras para
         * representar todos sus números y en el caso del código binario estas
         * dos cifras son el 0 y el 1.
         */
        String[] arrayNumeros = {"13", "01011101", "1A", "0", "1", "003", "1011", "FF", "63", "111", "10", "57", "7F"};
        String patronBinario = "[0-1]{1,}";
        int contadorBinario = 0;
        int contadorNoBinario = 0;
        
        for(String pos:arrayNumeros){
            if(pos.matches(patronBinario)){
                System.out.printf("El número: %s es binario%n",pos);
                contadorBinario++;
            }else{
                System.out.printf("El número: %s no es binario%n",pos);
                contadorNoBinario++;
            }
        }
        
        System.out.println("Total de números binarios: "+contadorBinario);
        System.out.println("Total de números no binarios: "+contadorNoBinario);
        

    }

}
