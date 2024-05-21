
package Ejercicio_8_ArchivoDeFinDeSemana;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class Test {
    
    
    public static void main(String args[]){
        String separador = File.separator;
        String rutaFichero = System.getProperty("user.dir")+separador+"src"+separador+"Ejercicio_8_ArchivoDeFinDeSemana"+separador+"DiasLibres.txt";
        final int NUMERO_DIAS = 30;
        final String SABADO = "sábado";
        final String DOMINGO = "domingo";
        Map<LocalDate,String> mapaFechas = new TreeMap<>();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        LocalDate fechaActual = LocalDate.of(2022, 06, 1);
        //Insertamos datos
        for(int n=0;n<NUMERO_DIAS;n++){
            mapaFechas.put(fechaActual.plusDays(n),fechaActual.plusDays(n).getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es","ES")) );
        }
        //Escribimos en fichero
        try(PrintWriter pw = new PrintWriter(new FileWriter(rutaFichero))){
            for(Map.Entry<LocalDate,String> pareja : mapaFechas.entrySet()){
                String dia = pareja.getValue();
                if(dia.equals(SABADO) || dia.equals(DOMINGO)){
                    pw.println(pareja.getKey().format(formatoFecha));
                }
                pw.flush();
            }
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
             
        
    }
}
