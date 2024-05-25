package Ejercicio_12_ZooHerenciasEstructurasDeDatosYlecturaEntradaEnArchivos;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {

    /**
     * Método que comprueba si el número seleccionado (Cuando seleccionamos una
     * especie determinada) está dentro del rango permitido y que no se ha
     * introducido un caracter no numérico.
     *
     * @param pos
     * @return
     */
    public static boolean comprobarNumero(String pos) {
        boolean resultado = false;
        try {
            int valor = Integer.valueOf(pos);
            resultado = valor < 1 || valor > 3 ? false : true;
        } catch (NumberFormatException ex) {
            resultado = false;
        }
        return resultado;
    }

    /**
     * Método para introducir una especie determinada, junto con los parámetros
     * necesarios para instanciarla.
     *
     * @param zoo
     * @throws IllegalArgumentException
     */
    public static void introducir(Zoo zoo) throws IllegalArgumentException {
        boolean estado = false;
        boolean animalCorrecto = false;
        int posEspecie = 0;//Almacenamos la posición de la especie seleccionada.Dependiendo del número entraremos en un "case" determinado en el switch.
        //Listado de especies disponibles.
        List<String> especiesDisponibles = new ArrayList<>(Arrays.asList("Lobo Gris", "Águila", "Oso Ibérico"));
        Scanner teclado = new Scanner(System.in);
        /**
         * Mostramos un menú para seleccionar el tipo de especie, junto con los
         * parámetros que necesitamos para instanciarla.
         */
        while (!estado) {
            String tipoAnimal = "";
            /**
             * Mientras no seleccionemos un animal de la lista, seguirá
             * pidiéndonos una especie.
             */
            while (!animalCorrecto) {
                System.out.println("Indique el tipo de especie");
                for (int i = 0; i < especiesDisponibles.size(); i++) {
                    System.out.printf("%d-> %s%n", i + 1, especiesDisponibles.get(i));
                }
                String posEspecieStr = teclado.nextLine();//Leemos el número introducido
                animalCorrecto = Test.comprobarNumero(posEspecieStr);//Comprobamos si el número es correcto, en caso afirmativo asignamos a la variable posEspecie.
                if (animalCorrecto) {
                    posEspecie = Integer.valueOf(posEspecieStr);
                }
            }

            System.out.println("Introduzca el nombre propio del animal");
            String nombre = teclado.nextLine();

            System.out.println("Introduzca fecha entrada en formato yyyy-mm-dd");
            String fecha = teclado.nextLine();

            System.out.println("Introduzca lugar de procedencia");
            String lugarProcedencia = teclado.nextLine();

            System.out.println("Existen 50 recintos, indique un recinto del 1 - 50");
            String numRecinto = teclado.nextLine();

            try {
                switch (posEspecie) {
                    case 1:
                        estado = zoo.introducirAnimal(Integer.valueOf(numRecinto), new LoboGris(nombre, fecha, lugarProcedencia));
                        break;
                    case 2:
                        estado = zoo.introducirAnimal(Integer.valueOf(numRecinto), new Aguila(nombre, fecha, lugarProcedencia));
                        break;
                    case 3:
                        estado = zoo.introducirAnimal(Integer.valueOf(numRecinto), new OsoIberico(nombre, fecha, lugarProcedencia));
                        break;
                }

            } catch (DateTimeParseException ex) {
                System.out.println(ex.getMessage());
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    /**
     * Entrada principal del programa.
     *
     * @param args
     */
    public static void main(String args[]) {
        final String SALIR = "salir";
        Scanner teclado = new Scanner(System.in);
        int OPCION_MAX = 3;
        int OPCION_MIN = 1;

        Zoo zoo = new Zoo();
        //1º Leer el estado del zoo desde un archivo binario
        OperacionE_SDatos esDatos = new OperacionE_SDatos();
        System.out.println("Leyendo fichero...");
        if (esDatos.lecturaFichero()) {
            //Muestro los datos que hemos leído del fichero binario
            System.out.println("DATOS REGISTRADOS EN FICHERO BINARIO");
            System.out.println("------------------------------------");
            zoo.mostrarDatosAlimento(esDatos.getEstadoZoo());
        } else {
            System.out.println("El fichero está vacío o existe un problema en el mismo.\n");
        }
        int pos = 0;
        boolean continuar = true;
        while (continuar) {
            System.out.println("Elija una opción");
            System.out.println("1-Añadir animal");
            System.out.println("2-Listar cantidad de alimentos de todos los recintos");
            System.out.println("3-Salir");
            String cadenaEntrada = teclado.nextLine();
            try {
                pos = Integer.parseInt(cadenaEntrada);
                if (pos < OPCION_MIN || pos > OPCION_MAX) {
                    System.out.println("Opción no válida");
                } else {
                    if (pos == 1) {
                        System.out.println("Ha elegido Añadir un animal");
                        Test.introducir(zoo);
                        System.out.println("Operación realizada con éxito");
                    }
                    if (pos == 2) {
                        System.out.println("Ha elegido listar la cantidad de alimentos de todos los recintos");
                        zoo.mostrarDatosAlimento(zoo.listarCantidadAlimentos());
                    }
                    if (pos == 3) {
                        System.out.println("Ha elegido salir");
                        continuar = false;
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("Opción no válida");
                teclado.nextLine();
            }
        }

        //Guardar en el fichero el estado actual del zoo
        esDatos.escribirFichero(zoo.listarCantidadAlimentos());
    }

}
