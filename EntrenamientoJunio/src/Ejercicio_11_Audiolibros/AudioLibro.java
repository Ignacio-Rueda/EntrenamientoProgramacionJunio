package Ejercicio_11_Audiolibros;

public class AudioLibro extends Libro implements Reproducible {

    private final int numeroPistas;
    private final String formato;

    public final int NUM_MIN_PISTAS = 1;
    public final int NUM_MAX_PISTAS = 20;
    public String FORMATO_MP3 = "MP3";
    public String FORMATO_WAV = "WAV";

    private int contadorReproducciones;

    public AudioLibro(String titulo, double precio, int numeroPistas, String formato) throws IllegalArgumentException {
        super(titulo, precio);
        if (numeroPistas < NUM_MIN_PISTAS || numeroPistas > NUM_MAX_PISTAS) {
            throw new IllegalArgumentException("El número de pistas no está en el rango permitido");
        }
        if (!formato.equals(FORMATO_MP3) && !formato.equals(FORMATO_WAV)) {
            throw new IllegalArgumentException(String.format("El formato no es correcto: sólo puede ser %s o %s%n", FORMATO_MP3, FORMATO_WAV));
        }
        this.numeroPistas = numeroPistas;
        this.formato = formato;
        contadorReproducciones = 0;
    }

    public int getNumeroPistas() {
        return this.numeroPistas;
    }

    public String getFormato() {
        return this.formato;
    }

    @Override
    public String toString() {
        return String.format("%s Formato: %s Núm de pistas: %d Núm. veces reproducido:%d%n",
                super.toString(),
                getFormato(),
                getNumeroPistas(),
                getNumVecesReproducido()
        );
    }

    @Override
    public String reproducir() {
        StringBuilder reproduccion = new StringBuilder();
        for (int n = 0; n < getNumeroPistas(); n++) {
            reproduccion.append(String.format("#Aquí sonaría la pista número:%d#%n", n + 1));
        }
        contadorReproducciones++;
        return reproduccion.toString();
    }

    @Override
    public int getNumVecesReproducido() {
        return this.contadorReproducciones;
    }
}
