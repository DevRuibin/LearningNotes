import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Beverage {
    String description = "Unknown Beverage";

    protected String getDescription() {
        System.out.println(description);
        return description;
    }

    protected abstract double cost();
}
