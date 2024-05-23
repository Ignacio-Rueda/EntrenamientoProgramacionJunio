package Ejercicio_11_Audiolibros;

/**
 *
 * @author profe
 */
public class Ejercicio03 {

    /**
     * Método principal
     *
     * @param args Argumentos de la línea de órdenes.
     */
    public static void main(String[] args) {
        AudioLibro[] audiolibros = {null, null, null, null};

        System.out.println("PRUEBA DE USO DE LA CLASE AUDIOLIBRO");
        System.out.println("----------------------------------");

        // Intento de crear algunos audiolibros con errores
        try {
            audiolibros[0] = new AudioLibro("Vida y otra de Chiquito de la calzada", 15.67, 33, "MP3");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            audiolibros[0] = new AudioLibro("", 120.12, 2, "WAV");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            audiolibros[0] = new AudioLibro("El bajísimo", 2.35, 5, "MP3");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            audiolibros[0] = new AudioLibro("El idiota", 3.47, 7, "MP4");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();

        // Intento de crear algunos audiolibros correctos
        audiolibros[0] = new AudioLibro("Don Quijote de la Mancha", 26.35, 8, "MP3");
        audiolibros[1] = new AudioLibro("Cádiz", 12.95, 6, "WAV");
        audiolibros[2] = new AudioLibro("La isla negra", 9.89, 3, "MP3");
        audiolibros[3] = new AudioLibro("Vida y obra de Chiquito de la calzada", 12.34, 7, "WAV");

        // Mostramos el contenido de los audiolibros y los "reproducimos"
        for (AudioLibro audiolibro : audiolibros) {
            
            System.out.println(audiolibro.toString());
            System.out.print(audiolibro.reproducir());
            System.out.printf("Número de veces reproducido: %d.\n\n", audiolibro.getNumVecesReproducido());
        }

        System.out.println(audiolibros[2].toString());
        System.out.print(audiolibros[2].reproducir());
        System.out.printf("Número de veces reproducido: %d.\n\n", audiolibros[2].getNumVecesReproducido());

    }

}
