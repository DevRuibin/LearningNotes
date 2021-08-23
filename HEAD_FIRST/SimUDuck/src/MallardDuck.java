public class MallardDuck extends Duck implements Flyable, Quackable{
    @Override
    protected void display() {
        System.out.println("I am a MallardDuck");
    }

    @Override
    public void fly() {
        System.out.println("Mallar duck cannot fly");
    }

    @Override
    public void quack() {
        System.out.println("gua gua");
    }
}
