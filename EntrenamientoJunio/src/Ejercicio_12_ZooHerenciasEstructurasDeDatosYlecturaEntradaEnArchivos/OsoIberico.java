package Ejercicio_12_ZooHerenciasEstructurasDeDatosYlecturaEntradaEnArchivos;

import java.io.Serializable;
import java.time.format.DateTimeParseException;

public class OsoIberico extends Animal implements Serializable {

    private final long SerialVersionUID = 1L;
    public static final String TIPO_ALIMENTO = "Carne";
    public static final double CANTIDAD_ALIMENTO = 4;

    public OsoIberico(String nombrePropio, String fechaEntrada, String lugarProcedencia) throws DateTimeParseException {
        super(nombrePropio, fechaEntrada, lugarProcedencia, OsoIberico.CANTIDAD_ALIMENTO, OsoIberico.TIPO_ALIMENTO);
    }

}
