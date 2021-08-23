package test;

import duck.Duck;
import duck.MallardDuck;
import duck.RedheadDuck;
import duck.fly.FlyBehavior;
import duck.fly.FlyNoWay;
import duck.fly.FlyWithWings;
import duck.quack.Quack;
import duck.quack.QuackBehavior;
import duck.quack.Squeak;

public class TestDuck {


    public static void main(String[] args) {
        QuackBehavior quackBehavior = new Quack();
        QuackBehavior quackBehavior2 = new Squeak();

        FlyBehavior flyBehavior = new FlyNoWay();
        FlyBehavior flyBehavior2 = new FlyWithWings();

        Duck mallardDuck = new MallardDuck(flyBehavior, quackBehavior);
        Duck redheadDuck = new RedheadDuck(flyBehavior2, quackBehavior2);
        mallardDuck.display();
        mallardDuck.performFly();
        mallardDuck.performQuack();
        redheadDuck.performQuack();
        redheadDuck.performFly();
    }
}
