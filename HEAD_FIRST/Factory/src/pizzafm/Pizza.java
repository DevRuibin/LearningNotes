package pizzafm;

import java.util.ArrayList;

abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clam;
    Veggies[] veggies;

    abstract void prepare();
//    void prepare(){
//        System.out.println("Prepare " + name);
//        System.out.println("Tossing dough...");
//        System.out.println("Adding sauce...");
//        System.out.println("Adding toppings: ");
//        for (String topping :
//                toppings) {
//            System.out.println("    " + topping);
//        }
//    }

    void bake(){
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut(){
        System.out.println("Cut the pizza into diagonal slices");
    }

    void box(){
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("----").append(name).append("----\n");
        if(dough != null){
            stringBuilder.append(dough).append("\n");
        }
        if(sauce != null){
            stringBuilder.append(sauce).append("\n");
        }
        if(cheese != null){
            stringBuilder.append(cheese).append("\n");
        }
        if(veggies != null){
            for (Veggies veggie: veggies) {
                stringBuilder.append(veggie).append("\n");
            }
        }
        if(clam != null){
            stringBuilder.append(clam).append("\n");
        }
        if(pepperoni != null){
            stringBuilder.append(pepperoni).append("\n");
        }

        return stringBuilder.toString();
    }
}


class CheesePizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
 
	public CheesePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
	}
}
class ClamPizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
 
	public ClamPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		clam = ingredientFactory.createClam();
	}
}
class PepperoniPizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
 
	public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		veggies = ingredientFactory.createVeggies();
		pepperoni = ingredientFactory.createPepperoni();
	}
}
class VeggiePizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
 
	public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		veggies = ingredientFactory.createVeggies();
	}
}
