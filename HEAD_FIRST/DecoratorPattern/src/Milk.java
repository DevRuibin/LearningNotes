public class Milk extends CondimentDecorator{
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    protected double cost() {
        return .10 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }
}
