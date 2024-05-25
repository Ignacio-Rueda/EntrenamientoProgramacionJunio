package Ejercicio_12_ZooHerenciasEstructurasDeDatosYlecturaEntradaEnArchivos;

import java.io.Serializable;
import java.time.format.DateTimeParseException;

public class Aguila extends Animal implements Serializable {

    private final long SerialVersionUID = 1L;
    public static final String TIPO_ALIMENTO = "Pienso de Ave";
    public static final double CANTIDAD_ALIMENTO = 0.3;
  
    public Aguila(String nombrePropio, String fechaEntrada, String lugarProcedencia) throws DateTimeParseException {
        super(nombrePropio, fechaEntrada, lugarProcedencia, Aguila.CANTIDAD_ALIMENTO, Aguila.TIPO_ALIMENTO);
    }


}
