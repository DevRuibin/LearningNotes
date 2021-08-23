interface Flyable{
    void fly();
}

interface Quackable{
    void quack();
}

public abstract class Duck {
//    protected void quack(){
//        System.out.println("I can quack");
//    }
    protected void swim(){
        System.out.println("I can swim");
    }
    protected abstract void display();
}

