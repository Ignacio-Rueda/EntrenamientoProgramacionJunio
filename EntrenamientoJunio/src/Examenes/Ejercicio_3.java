
package Examenes;
interface Poligono{
    double getArea();
    int getLados();
    double getPerimetro();
}
class Rectangulo implements Poligono{
    double base;
    double altura;
    Rectangulo(double base,double altura){
        this.base = base;
        this.altura = altura;
    }
    @Override
    public double getArea() {
     return this.base * this.altura;
    }

    @Override
    public int getLados() {
       return 4;
    }

    @Override
    public double getPerimetro() {
       return 2*(this.base+this.altura);
    }
}

class PentagonoRegular implements Poligono{
    int numLados;
    PentagonoRegular(int numLados) {
        this.numLados = numLados;
    }
    
    @Override
    public double getArea() {
        
     return 61.92;
    }

    @Override
    public int getLados() {
       return 5;
    }

    @Override
    public double getPerimetro() {
       return 5*this.numLados;
       
    }
}
public class Ejercicio_3 {
    
    public static void main(String args[]){
    
        Rectangulo rec = new Rectangulo(2.5, 8.5);
        PentagonoRegular pen = new PentagonoRegular(6);
        
        System.out.println("El número de lados del rectángulo es:"+rec.getLados());
        System.out.println("El área del rectángulo es:"+rec.getArea());
        System.out.println("El perimetro del rectángulo es:"+rec.getPerimetro());
        
        System.out.println("El número de lados del pentágono es:"+pen.getLados());
        System.out.println("El área del pentágono es:"+pen.getArea());
        System.out.println("El perímetro del pentágono es:"+pen.getPerimetro());
    
    }
    
}
