
public abstract class Beverage {
    public enum Size{TALL, GRANDE, VENTI}
    Size size = Size.TALL;
    String description = "Unknown Beverage";

    protected String getDescription() {
        System.out.println("===================");
        return description;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    protected abstract double cost();
}
