package simpleobservable;

import simple.Display;

import java.util.Observable;
import java.util.Observer;

public class SimpleObserver implements Observer, Display {
    private int value;

    public SimpleObserver(Observable observable){
        observable.addObserver((Observer)this);
    }
    @Override
    public void update(Observable observable, Object arg) {
        System.out.println(arg);
        this.value = (int) arg;
        display();
        if(observable instanceof SimpleSubject){
            SimpleSubject simpleSubject = (SimpleSubject) observable;
            this.value = simpleSubject.getValue();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("value: " + value);
    }
}
