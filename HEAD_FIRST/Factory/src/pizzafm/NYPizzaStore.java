package pizzafm;

public class NYPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String item) {
        Pizza pizza;
        PizzaIngredientFactory factory = new NYPizzaIngredientFactory();
        if (item.equals("cheese")) {
            pizza = new CheesePizza(factory);
            pizza.setName("New York Style cheese Pizza");
        } else if (item.equals("veggie")) {
            pizza = new CheesePizza(factory);
            pizza.setName("New York Style Veggie Pizza");
        } else if (item.equals("clam")) {
            pizza = new ClamPizza(factory);
            pizza.setName("New York Style Clam Pizza");
        } else if (item.equals("pepperoni")) {
            pizza = new PepperoniPizza(factory);
            pizza.setName("New York Style Pepperoni Pizza");
        } else return null;
        return pizza;
    }
}