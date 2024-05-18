package Ejercicio_5_Pizzas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pizza {

    private String nombre;
    private List<Ingrediente> ingredientes;

    public final static int NUM_MAX_ING = 3;

    public Pizza(String nombre) throws IllegalArgumentException, NullPointerException {
        if (nombre == null) {
            throw new NullPointerException("El nombre no puede ser nulo");
        }
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre introducido no es válido,la cadena está vacía");
        }
        this.nombre = nombre;
        this.ingredientes = new ArrayList<>();
    }

    public void addIngredientes(Ingrediente[] ings) {
        //Obtenemos el listado de todos los ingredientes
        Ingrediente[] listadoIngredientesEnum = Ingrediente.values();

        for (Ingrediente ingredienteEntrada : ings) {
            //Si en la lista no tenemos el ingrediente lo añadimos.
            if (!this.ingredientes.contains(ingredienteEntrada)) {
                for (int i = 0; i < listadoIngredientesEnum.length; i++) {//Recorremos el listado de los ingredientes que existen en el enum
                    if (ingredienteEntrada.equals(listadoIngredientesEnum[i])) {
                        this.ingredientes.add(listadoIngredientesEnum[i]);
                    }
                }

            } else {//Si ya existe, tenemos que saber qué cantidad tenemos de este tipo de ingrediente
                int contadorIngredientes = 0;
                for (Ingrediente ingredienteExistente : this.ingredientes) {
                    if (ingredienteEntrada.equals(ingredienteExistente)) {
                        contadorIngredientes++;
                    }
                }
                //Si la cantidad de este tipo de ingrediente es inferior a la máxima cantidad permitida, se añade.
                if (contadorIngredientes < Pizza.NUM_MAX_ING) {
                    for (int i = 0; i < listadoIngredientesEnum.length; i++) {//Recorremos el listado de los ingredientes que existen en el enum
                        if (ingredienteEntrada.equals(listadoIngredientesEnum[i])) {
                            this.ingredientes.add(listadoIngredientesEnum[i]);
                        }
                    }
                }
            }

        }
    }//Final método addIngredientes

    public void eliminarIngredienteCompletamente(Ingrediente ing) {
        Iterator it = ingredientes.iterator();
        while (it.hasNext()) {
            if (it.next().equals(ing)) {
                it.remove();
            }
        }
    }

    public String getIngredientes() {
        return String.format("Ingredientes pizza '%s':%s%n",this.nombre, this.ingredientes);
    }

}
