
package Examenes.DAM2022;

public class Ejercicio_1 {
    
    
    public static void main(String args[]){
        String[] arrayMatriculas = {"13", "MU9142BN", "1A", "0", "1", "AB2747T", "AL7347T", "FF", "63", "111", "AB1234YU", "M5723P", "7F"};
        
        String patron = "(AB|MU)[0-9]{4}[A-Z]{1,2}";
        int numMatrValida = 0;
        int numMatrNoValida = 0;
        
        for(String matr:arrayMatriculas){
            if(matr.matches(patron)){
                System.out.println(matr);
                numMatrValida++;
            }else{
                numMatrNoValida++;
            }
        }
        System.out.printf("Total de matriculas válidas:%d%n",numMatrValida);
        System.out.printf("Total de matriculas no válidas:%d%n",numMatrNoValida);
        
    }
    
}
