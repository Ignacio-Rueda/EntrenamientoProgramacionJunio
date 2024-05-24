
package Ejercicio_12_ZooHerenciasEstructurasDeDatosYlecturaEntradaEnArchivos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Zoo {
    //Cada recinto -> Conjunto de animales.Número máximo de jaulas por recinto = 20. 1 animal por jaula
    Map<Integer,List<Animal>> recintos;
    private final int NUM_MAX_RECINTOS = 50;
    private final int NUM_MAX_JAULAS = 20;
    
    public Zoo(){
        recintos = new TreeMap<>();

    }
    
    public boolean introducirAnimal(int numRecinto,Animal animal){
        boolean introPosible = false;
        //Si el tamaño del mapa es inferior a 50 y existen jaulas vacías podemos añadir
        if(recintos.size()<NUM_MAX_RECINTOS && recuentoJaulas()){
            if(!recintos.containsKey(numRecinto)){
                recintos.put(numRecinto, new ArrayList<>());
            }
            //Comprobar si se han alcanzado las 20 jaulas para el número de posición requerido
            if(recintos.get(numRecinto).size()<NUM_MAX_JAULAS){
                recintos.get(numRecinto).add(animal);
                introPosible = true;
            }
        }
        
        return introPosible;
    }
    
    /**
     * Permite conocer si existen jaulas vacías.
     * @return 
     */
    private boolean recuentoJaulas(){
        for(Map.Entry<Integer,List<Animal>> pareja:recintos.entrySet()){
            if(pareja.getValue().size()<NUM_MAX_JAULAS){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Listar la cantidad de cada alimento de cada uno de los recintos
     * @return Mapa relación
     */
    public Map<Integer,Map<String,Double>> listarCantidadAlimentos(){
        Map<Integer,Map<String,Double>> recintoAlimentos = new TreeMap<>();
        Map<String,Double> relacionAlimentos = new TreeMap<>();
        
        for(Map.Entry<Integer,List<Animal>> pareja : recintos.entrySet()){//Recorremos todos los recintos con sus respectivas jaulas
            List<Animal> listaAnimales = pareja.getValue();//Animales en recinto
            double cantidadAlimento;
            String tipoAlimento;
            for(Animal animal : listaAnimales){//Cada animal está en una jaula
                cantidadAlimento = animal.getCantidadAlimento();
                tipoAlimento = animal.getTipoAlimento();
                if(!relacionAlimentos.containsKey(tipoAlimento)){
                    relacionAlimentos.put(tipoAlimento, 0.0);
                }
                relacionAlimentos.put(tipoAlimento, relacionAlimentos.get(tipoAlimento)+cantidadAlimento);
               
            }
            recintoAlimentos.put(pareja.getKey(), relacionAlimentos);
        }
        return recintoAlimentos;
    }
    
}
