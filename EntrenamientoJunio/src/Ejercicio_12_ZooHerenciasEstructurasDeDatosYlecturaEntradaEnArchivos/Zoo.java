package Ejercicio_12_ZooHerenciasEstructurasDeDatosYlecturaEntradaEnArchivos;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class Zoo implements Serializable {

    private final long SerialVersionUID = 1L;
    private Map<Integer, Animal[]> recintos;
    private Animal[] jaulas;
    private final int NUM_MAX_RECINTOS = 50;
    private final int NUM_MIN_RECINTOS = 1;
    private final int NUM_MAX_JAULAS = 2;//Se ha partido de la base, de que en cada jaula hay un sólo animal

    public Zoo() {
        recintos = new TreeMap<>();

        for (int i = 0; i < NUM_MAX_RECINTOS; i++) {
            recintos.put(i + 1, new Animal[NUM_MAX_JAULAS]);
        }
    }

    public boolean introducirAnimal(int numRecinto, Animal animal) throws IllegalArgumentException {

        if (numRecinto < NUM_MIN_RECINTOS || numRecinto > NUM_MAX_RECINTOS) {
            throw new IllegalArgumentException("Número de recinto no váido");
        }

        int pos = buscarJaula(numRecinto);
        if(pos == -1){
            throw new IllegalArgumentException("No hay mas espacio en el recinto seleccionado");
        }
        boolean introPosible = false;

        if (pos != -1) {
            Animal[] actualizarJaula = recintos.get(numRecinto);
            actualizarJaula[pos] = animal;
            introPosible = true;
            recintos.put(numRecinto, actualizarJaula);
        }
        return introPosible;
    }

    /**
     * Permite conocer si hay jaulas vacías en el recinto solicitado.
     *
     * @return
     */
    private int buscarJaula(int numRecinto) {
        int pos = -1;

        Animal[] contenidoJaulasActual = recintos.get(numRecinto);
        boolean posible = false;
        for (int i = 0; i < contenidoJaulasActual.length && !posible; i++) {
            if (contenidoJaulasActual[i] == null) {
                pos = i;
                posible = true;
            }
        }
        return pos;
    }

    /**
     * Listar la cantidad de cada alimento de cada uno de los recintos
     *
     * Devolveremos un mapa en el que la clave sea el número de jaulas y el
     * valor esté conformado por otro mapa cuya clave será el tipo de alimento y
     * el valor, la cantidad de este.
     *
     * @return Mapa relación
     */
    public Map<Integer, Map<String, Double>> listarCantidadAlimentos() {
        Map<Integer, Map<String, Double>> listadoAlimentos = new TreeMap<>();//Almacenamos el número de recinto y el tipo - cantidad alimento de cada uno
        Map<String, Double> tipoCantidadAlimento;//Mapa donde vamos a almacenar el tipo de alimento <-> cantidad alimento
        //Obtenemos todas la claves del zoo
        for (Map.Entry<Integer, Animal[]> claveValorRecinto : recintos.entrySet()) {
            Integer numeroRecinto = claveValorRecinto.getKey();

            //Obtenemos todas las jaulas de un recinto determinado
            Animal[] jaulas = recintos.get(numeroRecinto);
            tipoCantidadAlimento = new TreeMap<>();//Inicializamos el mapa donde vamos a almacenar tipo de alimento <-> cantidad alimento

            //Recorremos todas las jaulas obtenidas de un recinto determinado
            for (int i = 0; i < jaulas.length; i++) {
                if (jaulas[i] != null) {//Solo entramos a la jaula si no es nula, de ser nula, estaría vacía
                    Double cantidadAlimento = jaulas[i].getCantidadAlimento();
                    String tipoAlimento = jaulas[i].getTipoAlimento();

                    if (!tipoCantidadAlimento.containsKey(tipoAlimento)) {//Si ese alimento no ha sido introducido, lo creamos con valor 0.0
                        tipoCantidadAlimento.put(tipoAlimento, 0.0);
                    }
                    double cantidadAlimentoActual = tipoCantidadAlimento.get(tipoAlimento);

                    tipoCantidadAlimento.put(tipoAlimento, cantidadAlimentoActual + cantidadAlimento);//Si ya hemos añadido el alimento, sumamos cantidad
                }
            }//Hemos terminado de recorrer todas las jaulas de un recinto determiando
            listadoAlimentos.put(numeroRecinto, tipoCantidadAlimento);
        }
        return listadoAlimentos;

    }

    public void mostrarDatosAlimento(Map<Integer, Map<String, Double>> listadoAlimentos) {
        StringBuilder resultado = new StringBuilder();
        if (listadoAlimentos!=null) {
            for (Map.Entry<Integer, Map<String, Double>> lista : listadoAlimentos.entrySet()) {
                Integer numRecinto = lista.getKey();

                resultado.append(String.format("RECINTO Nº %d --->", numRecinto));
                for (Map.Entry<String, Double> relacion : listadoAlimentos.get(numRecinto).entrySet()) {
                    resultado.append(String.format(" *TIPO ALIMENTO: %s, CANTIDAD: %.2f KG", relacion.getKey(), relacion.getValue()));
                }
                resultado.append("\n");

            }
        }else{
            resultado.append("El fichero no contiene datos");
        }
        System.out.println(resultado);
    }


}
