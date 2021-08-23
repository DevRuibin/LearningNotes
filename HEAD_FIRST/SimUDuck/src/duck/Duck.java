package duck;

import duck.fly.FlyBehavior;
import duck.quack.QuackBehavior;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior){
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }
    public void swim(){
        System.out.println("I can swim");
    }
    public abstract void display();
    public void performQuack(){
        quackBehavior.quack();
    }
    public   void performFly(){
        flyBehavior.fly();
    }
}

