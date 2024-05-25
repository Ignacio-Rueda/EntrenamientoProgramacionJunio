package Ejercicio_12_ZooHerenciasEstructurasDeDatosYlecturaEntradaEnArchivos;


import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {

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

    public static void introducir(Zoo zoo) throws IllegalArgumentException {

        boolean estado = false;
        boolean animalCorrecto = false;
        int posEspecie = 0;
        List<String> especiesDisponibles = new ArrayList<>(Arrays.asList("Lobo Gris", "Águila", "Oso Ibérico"));

        Scanner teclado = new Scanner(System.in);

        while (!estado) {
            String tipoAnimal = "";
            while (!animalCorrecto) {

                System.out.println("Indique el tipo de especie");
                for (int i = 0; i < especiesDisponibles.size(); i++) {
                    System.out.printf("%d-> %s%n", i + 1, especiesDisponibles.get(i));
                }

                String posEspecieStr = teclado.nextLine();
                animalCorrecto = Test.comprobarNumero(posEspecieStr);
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
            switch (posEspecie) {
                case 1:
                    try {
                    estado = zoo.introducirAnimal(Integer.valueOf(numRecinto), new LoboGris(nombre, fecha, lugarProcedencia));

                } catch (DateTimeParseException ex) {
                    System.out.println(ex.getMessage());
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                case 2:
                    try {
                    estado = zoo.introducirAnimal(Integer.valueOf(numRecinto), new Aguila(nombre, fecha, lugarProcedencia));

                } catch (DateTimeParseException ex) {
                    System.out.println(ex.getMessage());
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                case 3:
                      try {
                    estado = zoo.introducirAnimal(Integer.valueOf(numRecinto), new OsoIberico(nombre, fecha, lugarProcedencia));

                } catch (DateTimeParseException ex) {
                    System.out.println(ex.getMessage());
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            }
        }
    }

    public static void mostrarCantidades(Zoo zoo) {
        zoo.mostrarDatosAlimento(zoo.listarCantidadAlimentos());
    }

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
                        Test.mostrarCantidades(zoo);
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
