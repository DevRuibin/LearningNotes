public class RedheadDuck extends Duck implements Flyable, Quackable{
    @Override
    protected void display() {
        System.out.println("I am Red head duck");
    }

    @Override
    public void fly() {
        System.out.println("Red head duck fly");
    }

    @Override
    public void quack() {
        System.out.println("gua gua");
    }
}
