package pizzafm;

public class ChicagoPizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory factory = new ChicagoPizzaIngredientFactory();
        if (item.equals("cheese")) {
            pizza = new CheesePizza(factory);
            pizza.setName("Chicago Style cheese Pizza");
        } else if (item.equals("veggie")) {
            pizza = new CheesePizza(factory);
            pizza.setName("Chicago Style Veggie Pizza");
        } else if (item.equals("clam")) {
            pizza = new ClamPizza(factory);
            pizza.setName("Chicago Style Clam Pizza");
        } else if (item.equals("pepperoni")) {
            pizza = new PepperoniPizza(factory);
            pizza.setName("Chicago Style Pepperoni Pizza");
        } else return null;
        return pizza;
    }
}
