package pizza;

public class ThincrustPizza extends Pizza{
    public ThincrustPizza() {
        description = "Thin crust pizza, with tomato sauce";
    }

    @Override
    public double cost() {
        return 8.99;
    }
}
