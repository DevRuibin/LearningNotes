package pizzafm;

public interface Cheese {
    String toString();

}

class MozzarellaCheese implements Cheese {

    public String toString() {
        return "Shredded Mozzarella";
    }
}
class ParmesanCheese implements Cheese {

    public String toString() {
        return "Shredded Parmesan";
    }
}
class ReggianoCheese implements Cheese {

    public String toString() {
        return "Reggiano Cheese";
    }
}
