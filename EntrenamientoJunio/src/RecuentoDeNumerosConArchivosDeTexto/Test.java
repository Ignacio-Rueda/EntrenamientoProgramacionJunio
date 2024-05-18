package RecuentoDeNumerosConArchivosDeTexto;

public class Test {
    
    public static void main(String args[]){

        String patron = "( {1,}(0|[1-9]|[1-9][0-9])|(0|[1-9]|[1-9][0-9]))(( {1,}(0|[1-9]|[1-9][0-9])){0,}|( {1,}(0|[1-9]|[1-9][0-9]) {1,}){0,})";
        String entrada = "    1  2          3 4 10 20 10 10 10 20 30   99 50 51  50 99 1 99";
        System.out.println(entrada.matches(patron));
             
    
    }
    
}
