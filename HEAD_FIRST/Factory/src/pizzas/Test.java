package pizzas;

class Test {


    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore(new simplePizzaFactory());
        Pizza pizza = pizzaStore.orderPizza("cheese");
//        System.out.println(pizza.getName());
//        System.out.println(pizza);
    }
}
