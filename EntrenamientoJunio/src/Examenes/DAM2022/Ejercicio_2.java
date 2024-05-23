package Examenes.DAM2022;

public class Ejercicio_2 {
    
    public static void main(String args[]){
    
    String[] arrayCadenas = {"xxx", "2019", "23,5", "323.78", "2ab33", "8921.8", "234.8556", "Ea56"} ; 
    
    String patron = "([0-9]{1,}\\.[0-9]{1,}|[0-9]{1,})";
    for(String decimal : arrayCadenas){
        if(decimal.matches(patron)){
            Double num = Double.parseDouble(decimal);
            System.out.println(String.format("Número correcto:%8.2f",num));
        }
    }
    
    }
    
}
