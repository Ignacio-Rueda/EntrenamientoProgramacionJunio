package Ejercicio_12_ZooHerenciasEstructurasDeDatosYlecturaEntradaEnArchivos;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class LoboGris extends Animal {    
    public static final String TIPO_ALIMENTO = "Carne";
    public static final double CANTIDAD_ALIMENTO = 2;
    
    public LoboGris(String nombrePropio, LocalDate fechaEntrada, String lugarProcedencia) throws DateTimeParseException{
        super(nombrePropio,fechaEntrada,lugarProcedencia,LoboGris.CANTIDAD_ALIMENTO,LoboGris.TIPO_ALIMENTO);
    }
}
