package duck;

import duck.fly.FlyBehavior;
import duck.quack.QuackBehavior;

public class RedheadDuck extends Duck{
    public RedheadDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("I am Red head duck");
    }

}
