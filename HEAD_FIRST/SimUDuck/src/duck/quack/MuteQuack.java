package duck.quack;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("quacks that make no sound at all");
    }
}
