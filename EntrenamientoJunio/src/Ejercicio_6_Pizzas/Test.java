package Ejercicio_6_Pizzas;

public class Test {

    public static void main(String args[]) {
        //Crear pizza con valores no válidos:
        try {
            Pizza pizza = new Pizza(null);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Pizza pizza = new Pizza("");
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        
        //Crear pizza con valores correctos
        try{
            Pizza pizza = new Pizza("Variada");
            System.out.println(pizza.getIngredientes());
            Ingrediente[] arrayIngredientes ={Ingrediente.CEBOLLA,Ingrediente.CHAMPIÑONES,Ingrediente.MOZZARELLA,Ingrediente.MOZZARELLA,Ingrediente.MOZZARELLA,Ingrediente.MOZZARELLA};
            pizza.addIngredientes(arrayIngredientes);
            System.out.println(pizza.getIngredientes());
            pizza.eliminarIngredienteCompletamente(Ingrediente.MOZZARELLA);
            System.out.println(pizza.getIngredientes());
        }catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }

}
