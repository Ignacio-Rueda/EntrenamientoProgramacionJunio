package Ejercicio_12_ZooHerenciasEstructurasDeDatosYlecturaEntradaEnArchivos;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class OsoIberico extends Animal {    
    public static final String TIPO_ALIMENTO = "Carne";
    public static final double CANTIDAD_ALIMENTO = 4;
    
    public OsoIberico(String nombrePropio, LocalDate fechaEntrada, String lugarProcedencia) throws DateTimeParseException{
        super(nombrePropio,fechaEntrada,lugarProcedencia,OsoIberico.CANTIDAD_ALIMENTO,OsoIberico.TIPO_ALIMENTO);
    }

}
