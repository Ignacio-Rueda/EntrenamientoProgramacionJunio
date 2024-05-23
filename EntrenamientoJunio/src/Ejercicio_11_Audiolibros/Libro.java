package Ejercicio_11_Audiolibros;

/**
 * Clase que modela un libro con su título y precio. (El precio es un valore real
 * que está en el rango entre un  mínimo y un máximo).
 * 
 * @author profesor
 */
public abstract class Libro {

    public static final double MAX_PRECIO = 60_000_000.0 ;
    public static final double MIN_PRECIO = 3.0 ;
    
    protected final String titulo ;
    protected final double precio ;
    

    /**
     * Constructor con parámetros.
     * @param precio Precio del libro.
     * @param titulo Título del libro.
     */
    public Libro(String titulo, double precio) throws IllegalArgumentException {
        if (precio <= Libro.MIN_PRECIO || precio >= Libro.MAX_PRECIO) {
            throw new IllegalArgumentException(String.format("El precio (%.2f) no está en el rango permitido", precio));
        } else if (titulo == null || titulo.length() == 0) {
            throw new IllegalArgumentException("El título vacío no es válido");
        } else {
            this.precio = precio ;
            this.titulo = titulo ;
        }
    }


    /**
     * Devuelve el título del libro.     
     * @return Título del libro.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Devuelve el precio del libro.     
     * @return Precio del libro.
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Devuelve una representación textual del libro.     
     * @return Representación textual del libro.
     */
    @Override
    public String toString() {
        return String.format ("%s: Título: %s. Precio:%s.", this.getClass().getSimpleName(), this.titulo, this.precio);
    }

}
