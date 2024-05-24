package Ejercicio_12_ZooHerenciasEstructurasDeDatosYlecturaEntradaEnArchivos;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public abstract class Animal {

    private String nombrePropio;
    private LocalDate fechaEntrada;
    private String lugarProcedencia;
    private double cantidadAlimento;
    private String tipoAlimento;

    public Animal(String nombrePropio, LocalDate fechaEntrada, String lugarProcedencia,double cantidadAlimento,String tipoAlimento) throws DateTimeParseException{
        try {
            this.fechaEntrada = LocalDate.of(fechaEntrada.getYear(), fechaEntrada.getMonth(), fechaEntrada.getDayOfMonth());
            this.nombrePropio = nombrePropio;
            this.lugarProcedencia = lugarProcedencia;
            this.cantidadAlimento = cantidadAlimento;
            this.tipoAlimento = tipoAlimento;
        } catch (DateTimeParseException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public  double getCantidadAlimento(){
        return this.cantidadAlimento;
    }
    public String getTipoAlimento(){
        return this.tipoAlimento;
    }

}
