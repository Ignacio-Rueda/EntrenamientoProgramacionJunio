package Ejercicio_1_Terrenos;

abstract class Propiedad {

    private double precio;
    final private static double PRECIO_MAXIMO = 99000000;
    final private static double PRECIO_MINIMO = 900;
    private String localidad;

    public Propiedad(double precio, String localidad) throws IllegalArgumentException {
        if (precio < Propiedad.PRECIO_MINIMO || precio > Propiedad.PRECIO_MAXIMO) {
            throw new IllegalArgumentException(String.format("Los valores del precio %.2f introducidos no son válidos%n", precio));
        }
        if (localidad == null || localidad.isEmpty()) {
            throw new IllegalArgumentException(String.format("Los valores de la localidad %s introducidos no son válidos%n", localidad));
        }
        this.precio = precio;
        this.localidad = localidad;
    }

    abstract double calcularPrecioConIva();

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getLocalidad() {
        return this.localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return String.format("Precio:%.2f - Localidad:%s",
                this.precio,
                this.localidad
        );
    }
}//Final clase abstracta

interface Representable {

    public String representar();
}//Final interfaz

/**
 * Los objetos de esta clase representarán un rectángulo en un plano.
 */
class Terreno extends Propiedad implements Representable {

    private double base; //En kilómetros
    private double altura; //En kilómetros
    private double iva;

    final private static double IVA_MINIMO = 0;
    final private static double IVA_MAXIMO = 21;
    final private static double BASE_MINIMA = 0.010;
    final private static double BASE_MAXIMA = 10.0;
    final private static double ALTURA_MINIMA = 0.010;
    final private static double ALTURA_MAXIMA = 10.0;

    public Terreno(double precio, String localidad, double base, double altura, double iva) throws IllegalArgumentException {
        super(precio, localidad);
        if (base < Terreno.BASE_MINIMA || base > Terreno.BASE_MAXIMA) {
            throw new IllegalArgumentException(String.format("Los valores de base: %.2f introducidos no son correctos%n", base));
        }
        if (altura < Terreno.ALTURA_MINIMA || altura > Terreno.ALTURA_MAXIMA) {
            throw new IllegalArgumentException(String.format("Los valores de altura: %.2f introducidos no son correctos%n", altura));
        }
        if (iva < Terreno.IVA_MINIMO || iva > Terreno.IVA_MAXIMO) {
            throw new IllegalArgumentException(String.format("Los valores de iva: %.2f introducidos no son correctos%n", iva));
        }
        this.base = base;
        this.altura = altura;
        this.iva = iva;
    }

    public double getExtension() {
        return this.base * this.altura;
    }

    public double getBase() {
        return this.base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getIva() {
        return this.iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    @Override
    double calcularPrecioConIva() {
        double precioSinIva = getExtension() * super.getPrecio();
        return (precioSinIva * (this.iva / 100) + precioSinIva);
    }

    /**
     * Muestra una caja (su contorno, no su interior) dibujada usando un
     * asterisco por cada kilómetro de redondeoBase o redondeoAltura, realiar un
     * redondeo para cada unidad kilométrica, salvo que el redondeo sea 0, en
     * tal caso se consdierará 1.
     *
     * @return
     */
    @Override
    public String representar() {
        //Redondeo
        int redondeoAltura = (int) Math.round(this.altura);
        redondeoAltura = redondeoAltura == 0 ? 1 : redondeoAltura;
        int redondeoBase = (int) Math.round(this.base);
        redondeoBase = redondeoBase == 0 ? 1 : redondeoBase;
        StringBuilder representacion = new StringBuilder();
        for (int n = 0; n < redondeoAltura; n++) {//Altura
            for (int i = 0; i < redondeoBase; i++) {//Base
                if ((n == 0 || n == redondeoAltura - 1) || (n > 0 && n < redondeoAltura) && (i == 0 || i == redondeoBase - 1)) {
                    representacion.append("*");
                } else if ((n > 0 && n < redondeoAltura) && (i > 0 || i < redondeoBase)) {
                    representacion.append(" ");
                }
            }
            representacion.append("\n");
        }
        return representacion.toString();
    }

    @Override
    public String toString() {
        return String.format("%s Base: %.2f Altura: %.2f Extensión: %.2f%n",
                super.toString(),
                this.base,
                this.altura,
                this.getExtension()
        );
    }

}//Final clase Terreno

public class TerrenosTest {

    public static void main(String args[]) {
        //Capturar error en precio mínimo
        try {
            Terreno terreno = new Terreno(889, "Alcala La Real", 0.010, 10.0, 21);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        //Capturar error en precio máximo
        try {
            Terreno terreno = new Terreno(99000001, "Alcala La Real", 0.010, 10.0, 21);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        //Capturar error en localidad null
        try {
            Terreno terreno = new Terreno(999, null, 0.010, 10.0, 21);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        //Capturar error en base fuera de rango
        try {
            Terreno terreno = new Terreno(999, "Alcala La Real", 0.009, 10.0, 21);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        //Capturar error en altura fuera de rango
        try {
            Terreno terreno = new Terreno(999, "Alcala La Real", 0.010, 10.1, 21);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("CASOS CORRECTOS");
        System.out.println("---------------");
        //Datos correctos
        try {
            Terreno terreno = new Terreno(999, "Alcala La Real", 6.2, 2.9, 21);
            System.out.println(terreno);
            System.out.println(terreno.representar());
            System.out.printf("%.2f Euros%n", terreno.calcularPrecioConIva());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Terreno terreno = new Terreno(1500, "Jaén", 0.3, 3.41, 21);
            System.out.println(terreno);
            System.out.println(terreno.representar());
            System.out.printf("%.2f Euros%n", terreno.calcularPrecioConIva());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Terreno terreno = new Terreno(1200, "Albolote", 0.20, 0.05, 21);
            System.out.println(terreno);
            System.out.println(terreno.representar());
            System.out.printf("%.2f Euros%n", terreno.calcularPrecioConIva());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
