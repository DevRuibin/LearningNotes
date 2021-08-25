package pizza;

public class Olives extends ToppingDecorator{
    public Olives(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.description + ", olives";
    }

    @Override
    public double cost(){
        return pizza.cost() + .40;
    }
}
