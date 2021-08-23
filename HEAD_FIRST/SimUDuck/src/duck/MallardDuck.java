package duck;

import duck.fly.FlyBehavior;
import duck.quack.QuackBehavior;

public class MallardDuck extends Duck  {
    public MallardDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("I am a duck.fly.MallardDuck");
    }

}
