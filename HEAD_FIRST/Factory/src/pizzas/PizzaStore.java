package pizzas;

class PizzaStore {
    simplePizzaFactory factory;

    public PizzaStore(simplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type){
        Pizza pizza = null;
        pizza =factory.creatPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
