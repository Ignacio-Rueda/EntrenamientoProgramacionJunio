package Ejercicio_12_ZooHerenciasEstructurasDeDatosYlecturaEntradaEnArchivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.TreeMap;

public class OperacionE_SDatos {

    private final String sep = File.separator;
    private final String rutaFichero = System.getProperty("user.dir") + sep + "src" + sep + "Ejercicio_12_ZooHerenciasEstructurasDeDatosYlecturaEntradaEnArchivos" + sep + "zoo.dat";
    Map<Integer, Map<String, Double>> listadoAlimentos;

    public boolean lecturaFichero() {
        boolean resultado = false;
        try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(rutaFichero))) {
            if (lectura != null) {
                listadoAlimentos = (Map<Integer, Map<String, Double>>) lectura.readObject();
            }
            resultado = true;
        } catch (ClassNotFoundException ex) {
            resultado = false;
        } catch (FileNotFoundException ex) {
            resultado = false;
        } catch (IOException ex) {
            resultado = false;
        }
        return resultado;
    }

    public void escribirFichero(Map<Integer, Map<String, Double>> listadoAlimentos) {
        try (ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream(rutaFichero))) {
            escribir.writeObject(listadoAlimentos);
            escribir.flush();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Map<Integer, Map<String, Double>> getEstadoZoo() {
        return listadoAlimentos;
    }

}
