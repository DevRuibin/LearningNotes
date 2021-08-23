package duck.quack;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("quacks that squeak");
    }
}
