package Ejercicio_2_Vehiculos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VehiculosTest {

    public static void main(String args[]) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        try {
            Vehiculo vehiculo = new Vehiculo("196RLC", Color.AMARILLO, Color.AZUL, Color.NEGRO);
            System.out.println("Vehiculo creado con éxito.");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Vehiculo vehiculo = new Vehiculo("1111LLC", Color.BLANCO, Color.AMARILLO, Color.AZUL, Color.NEGRO);
            System.out.println("Vehiculo creado con éxito.");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Vehiculo vehiculo = new Vehiculo("1111LLC", Color.AMARILLO, Color.AMARILLO, Color.NEGRO);
            System.out.println("Vehiculo creado con éxito.");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        //----------------------------------------
        //VEHICULOS CREADOS CON VALORES ADECUADOS:
        //----------------------------------------
        try {
            Vehiculo vehiculo = new Vehiculo("1111LLC", Color.NEGRO);
            System.out.println("Vehiculo creado con éxito.");
            System.out.printf(vehiculo.addColor(Color.ROJO) ? "Color añadido!\n" : "No es posible! Color repetido!\n");
            System.out.printf(vehiculo.addColor(Color.ROJO) ? "Color añadido!\n" : "No es posible! Color repetido!\n");

            System.out.printf(vehiculo.contieneColor(Color.ROJO) ? "Este color ya existe en el listado!\n" : "Este color no existe en el listado!\n");
            System.out.printf(vehiculo.contieneColor(Color.NEGRO) ? "Este color ya existe en el listado!\n" : "Este color no existe en el listado!\n");
            System.out.printf(vehiculo.contieneColor(Color.AMARILLO) ? "Este color ya existe en el listado!\n" : "Este color NO existe en el listado!\n");
            vehiculo.rellenarListadoFechas();
            for(int n=0;n<5;n++){
                System.out.printf("Número de veces que el vehículo ha sido utilizado: %d%n",vehiculo.utilizar());
            }
            System.out.printf("Número de veces totales que el vehículo ha sido utilizado %d%n",vehiculo.vecesUtilizado());
            System.out.printf("Número de veces que el vehículo ha sido utilizado antes de %s: %d%n",LocalDate.now().format(formatoFecha),vehiculo.vecesUtilizadoAntesDe(LocalDate.now().plusDays(1)));
            System.out.printf("Número de veces que el vehículo ha sido utilizado antes de %s: %d%n",LocalDate.now().format(formatoFecha),vehiculo.vecesUtilizadoAntesDe(LocalDate.now()));
            System.out.printf("Fecha del último uso %s%n",vehiculo.ultimoUso().format(formatoFecha));
            System.out.println(vehiculo);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Vehiculo vehiculo = new Vehiculo("0996LHC", Color.AMARILLO, Color.AZUL, Color.NEGRO);
            System.out.println("Vehiculo creado con éxito.");

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
