package simple;

public class SimpleObserver implements Observer, Display{
    private int value;

    public SimpleObserver(Subject simpleSubject) {
        simpleSubject.registerObserver(this);
    }

    @Override
    public void update(int value) {
        this.value = value;
        display();
    }

    @Override
    public void display() {
        System.out.println("Value: " + value);
    }
}
