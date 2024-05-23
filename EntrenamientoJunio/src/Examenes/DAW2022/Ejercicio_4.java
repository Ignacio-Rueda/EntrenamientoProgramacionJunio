
package Examenes.DAW2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Persona{
    private String nombre;
    private int edad;
    public Persona(String nombre,int edad){
        this.nombre=nombre;
        this.edad=edad;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
public class Ejercicio_4 {
    
    public static void main(String args[]){
        String sep = File.separator;
        final int EDAD_LIMITE = 18;
        String rutaJovenicos = System.getProperty("user.dir")+sep+"src"+sep+"Examenes"+sep+"DAW2022"+sep+"jovenicos.txt";
        String rutaAdultos = System.getProperty("user.dir")+sep+"src"+sep+"Examenes"+sep+"DAW2022"+sep+"adultos.txt";
        List<Persona> listaPersonas = new LinkedList<>();
        listaPersonas.add(new Persona("Arturo",25));
        listaPersonas.add(new Persona("Diana",244));
        listaPersonas.add(new Persona("Vicente",7));
        listaPersonas.add(new Persona("Carlos",3));
        listaPersonas.add(new Persona("Ada",49));
        
        try(PrintWriter pwJ = new PrintWriter(new FileWriter(rutaJovenicos));PrintWriter pwA = new PrintWriter(new FileWriter(rutaAdultos))){
           Iterator it = listaPersonas.iterator();
           while(it.hasNext()){
               Persona p = (Persona)it.next();
               if(p.getEdad()>=EDAD_LIMITE){
                   pwA.println(String.format("Nombre: %s, edad: %d",p.getNombre(),p.getEdad()));
               }else{
                   pwJ.println(String.format("Nombre: %s, edad: %d",p.getNombre(),p.getEdad()));
               }
               pwJ.flush();
               pwA.flush();
           }
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
