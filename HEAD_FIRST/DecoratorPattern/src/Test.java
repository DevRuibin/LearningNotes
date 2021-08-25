public class Test {
    public static void main(String[] args){
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + "$" + beverage.cost());

        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + "$" + beverage1.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2.setSize(Beverage.Size.VENTI);
        beverage2 = new Mocha(beverage2);
        System.out.println(beverage2.getDescription() + "$"  + String.format("%.2f", beverage2.cost()));
        System.out.println(beverage2.size);
    }
}
