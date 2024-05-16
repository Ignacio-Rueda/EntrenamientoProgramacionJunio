
package Ejercicio_2_Vehiculos;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vehiculo {
    private final String matricula;
    private final List<Color>listadoColores = new ArrayList<>();
    private LocalDate []fechas;
    
    private static final int MIN_COLORES = 1;
    private static final int MAX_COLORES = 3;
    private final String patronMatricula = "[0-9]{4}[A-Z]{3}";
    
    public Vehiculo(String matricula,Color...colores)throws IllegalArgumentException{
        if(!(matricula.matches(patronMatricula))){
            throw new IllegalArgumentException("La matrícula introducida no sigue el patrón correcto");
        }
        if(colores.length < Vehiculo.MIN_COLORES || colores.length>Vehiculo.MAX_COLORES || colores==null){
            throw new IllegalArgumentException("La cantidad de colores introducida no es válida");
        }
        for (Color color : colores) {
            if (!(Color.AMARILLO.equals(color) || Color.BLANCO.equals(color) || Color.NEGRO.equals(color) || Color.AZUL.equals(color) || Color.VERDE.equals(color) || Color.ROJO.equals(color))) {
                throw new IllegalArgumentException("Los colores introducidos no están disponibles");
            }
        }
        this.matricula = matricula;
       
        for(int i=0;i<colores.length;i++){
            Color color = colores[i];
            this.listadoColores.add(color);
        }
    }
    
    public boolean addColor(Color color){
        boolean resultado = false;
        if(this.listadoColores.size()<Vehiculo.MAX_COLORES && this.listadoColores.size()>=Vehiculo.MIN_COLORES&& (!this.listadoColores.contains(color))){
            this.listadoColores.add(color);
            resultado = true;
        }
        return resultado;
    }
    
}
