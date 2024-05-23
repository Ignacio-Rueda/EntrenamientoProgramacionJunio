
package Examenes.DAM2022;
abstract class Vehiculo{
     private int codigo;
    private String nombre;
    private int numRuedas;
    
    Vehiculo(int codigo,String nombre,int numRuedas){
        this.codigo = codigo;
        this.nombre = nombre;
        this.numRuedas = numRuedas;
    }
 
    abstract float getVelocidadMaxima();
    
    
    @Override
    public String toString(){
        return String.format("Código: %d Nombre: %s Número de ruedas: %d",this.codigo,this.nombre,this.numRuedas);
    }
}
class Coche extends Vehiculo{
    private int numCilindros;
    
    Coche(int codigo,String nombre,int cilindros){
        super(codigo,nombre,4);
        this.numCilindros = cilindros;
    }
    
    @Override
    float getVelocidadMaxima() {
       return (this.numCilindros*100)/1.85f;
    }
    @Override
    public String toString(){
        return String.format("%s con %d cilindros%n",super.toString(),this.numCilindros);
    }
   
}
class Bicicleta extends Vehiculo{
    private int numRadios;
    Bicicleta(int codigo,String nombre,int ruedas,int numRadios){
        super(codigo,nombre,ruedas);
        this.numRadios = numRadios;
    }
    @Override
    public String toString(){
        return String.format("%s número de radios:%d%n",super.toString(),this.numRadios);
    }
    @Override
    float getVelocidadMaxima() {
       return this.numRadios*1.75f;
    }
    
}

public class Ejercicio_3 {
    
    public static void main(String args[]){
        System.out.println("Crear un coche");
        Vehiculo coche = new Coche(1, "Seat Fura", 4);
        System.out.print(coche);
        System.out.printf("Y tiene una velocidad máxima de:"+coche.getVelocidadMaxima()+" kms. por hora%n");
        System.out.println("\n");
        
        System.out.println("Crear una bicicleta");
        Vehiculo bici = new Bicicleta(4,"Bicicleta BH", 2, 28);
        System.out.println(bici);
        System.out.println("Y tiene una velocidad máxima de : "+bici.getVelocidadMaxima()+" kms. por hora");
        
        
    }
    
}
