package pizzafm;

public class DependentPizzaStore {

    public Pizza createPizza(String style, String type) {
        PizzaStore pizzaStore;
        Pizza pizza = null;
        if (style.equals("NY")) {
            pizzaStore = new ChicagoPizzaStore();
            pizza = pizzaStore.createPizza(type);
        } else if (style.equals("Chicago")) {
            pizzaStore = new NYPizzaStore();
            pizza = pizzaStore.createPizza(type);
        } else {
            System.out.println("Error: invalid type of pizza");
            return null;
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}