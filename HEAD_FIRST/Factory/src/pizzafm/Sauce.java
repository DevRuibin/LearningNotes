package pizzafm;

public interface Sauce {
    public String toString();
}

class MarinaraSauce implements Sauce{
    @Override
    public String toString() {
        return "Marinara Sauce";
    }
}


class PlumTomatoSauce implements Sauce {
    @Override
    public String toString() {
        return "Tomato sauce with plum tomatoes";
    }
}

