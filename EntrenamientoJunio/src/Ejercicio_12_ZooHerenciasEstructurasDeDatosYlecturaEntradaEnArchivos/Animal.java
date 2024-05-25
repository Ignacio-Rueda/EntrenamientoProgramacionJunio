package Ejercicio_12_ZooHerenciasEstructurasDeDatosYlecturaEntradaEnArchivos;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Animal implements Serializable {

    private final long SerialVersionUID = 1L;
    private String nombrePropio;
    private LocalDate fechaEntrada;
    private String lugarProcedencia;
    private double cantidadAlimento;
    private String tipoAlimento;

    public Animal(String nombrePropio, String fechaEntrada, String lugarProcedencia, double cantidadAlimento, String tipoAlimento) throws DateTimeParseException {
      
        if (!comprobarFecha(fechaEntrada)) {
            throw new DateTimeParseException("Error en la fecha","",0);
        }
        this.fechaEntrada = LocalDate.parse(fechaEntrada);
        this.nombrePropio = nombrePropio;
        this.lugarProcedencia = lugarProcedencia;
        this.cantidadAlimento = cantidadAlimento;
        this.tipoAlimento = tipoAlimento;

    }


    public double getCantidadAlimento() {
        return this.cantidadAlimento;
    }

    public String getTipoAlimento() {
        return this.tipoAlimento;
    }

    private boolean comprobarFecha(String fecha) {
        try {
            LocalDate.parse(fecha);
            return true;
        } catch (DateTimeParseException ex) {
            return false;
        }
    }

}
