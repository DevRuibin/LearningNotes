package simple;

import java.util.ArrayList;
import java.util.List;

public class SimpleSubject implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private int value;

    public SimpleSubject(List<Observer> observers) {
        this.observers = observers;
    }

    public SimpleSubject() {

    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers){
            observer.update(value);
        }
    }
}
