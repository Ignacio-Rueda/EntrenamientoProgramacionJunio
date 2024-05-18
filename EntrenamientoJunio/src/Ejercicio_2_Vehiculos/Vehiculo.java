package Ejercicio_2_Vehiculos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vehiculo {

    private final String matricula;
    private List<Color> listadoColores;
    private List<LocalDate> listadoFechasHaSidoUsado = new ArrayList<>();

    public static final int MIN_COLORES = 1;
    public static final int MAX_COLORES = 3;
    private final String patronMatricula = "[0-9]{4}[A-Z]{3}";

    public Vehiculo(String matricula, Color... colores) throws IllegalArgumentException {
        if (!(matricula.matches(patronMatricula))) {
            throw new IllegalArgumentException("La matrícula introducida no sigue el patrón correcto.");
        }
        if (colores.length < Vehiculo.MIN_COLORES || colores.length > Vehiculo.MAX_COLORES || colores == null) {
            throw new IllegalArgumentException("La cantidad de colores introducida no es válida.");
        }
        for (Color color : colores) {
            if (!(Color.AMARILLO.equals(color) || Color.BLANCO.equals(color) || Color.NEGRO.equals(color) || Color.AZUL.equals(color) || Color.VERDE.equals(color) || Color.ROJO.equals(color))) {
                throw new IllegalArgumentException("Los colores introducidos no están disponibles.");
            }
        }
        Color[]arrayColoresEnum = Color.values();
        this.listadoColores = new ArrayList<>();
        for (int i = 0; i < colores.length; i++) {
            if (!this.listadoColores.contains(colores[i])) {
                for(Color colorEnum:arrayColoresEnum){
                    if(colores[i].equals(colorEnum)){
                        this.listadoColores.add(colorEnum);
                    }
                }
            } else {
                this.listadoColores.clear();
                throw new IllegalArgumentException("Lo siento, no puedes introducir colores repetidos.");
            }

        }
        this.matricula = matricula;

    }

    /**
     * Método que NO se solicita en el ejercicio. Lo creo con el único objetivo
     * de almacenar fechas anteriores a la actual
     */
    public void rellenarListadoFechas() {
        for (int n = 1; n < 6; n++) {
            this.listadoFechasHaSidoUsado.add(LocalDate.now().minusMonths(n));
            this.listadoFechasHaSidoUsado.add(LocalDate.now().plusMonths(n));
        }
    }

    /**
     * Si la lista aún es inferior al máximo de colores posibles, y mayor o
 igual al mínimo y la lista NO contiene el colorEnum, lo añadimos.
     *
     * @param color
     * @return
     */
    public boolean addColor(Color color) {
        boolean resultado = false;
        if (this.listadoColores.size() < Vehiculo.MAX_COLORES && this.listadoColores.size() >= Vehiculo.MIN_COLORES && (!this.contieneColor(color))) {
            this.listadoColores.add(color);
            resultado = true;
        }
        return resultado;
    }

    public boolean contieneColor(Color color) {
        boolean resultado = this.listadoColores.contains(color);
        return resultado;
    }

    public int utilizar() {
        this.listadoFechasHaSidoUsado.add(LocalDate.now());
        return this.vecesUtilizado();
    }

    public int vecesUtilizado() {
        return this.listadoFechasHaSidoUsado.size();
    }

    public int vecesUtilizadoAntesDe(LocalDate fechaConsulta) {
        int numVeces = 0;
        for (LocalDate fechaUso : this.listadoFechasHaSidoUsado) {
            if (fechaUso.isBefore(fechaConsulta)) {
                numVeces++;
            }
        }
        return numVeces;
    }

    public LocalDate ultimoUso() {
        if (!this.listadoFechasHaSidoUsado.isEmpty()) {
            Collections.sort(this.listadoFechasHaSidoUsado);
            return this.listadoFechasHaSidoUsado.get(this.listadoFechasHaSidoUsado.size() - 1);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return String.format("Matrícula %s, Colores %s,Usos %d:%s%n",
                this.matricula,
                this.listadoColores,
                this.listadoFechasHaSidoUsado.size(),
                this.listadoFechasHaSidoUsado
        );
    }

}
