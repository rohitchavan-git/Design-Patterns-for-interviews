package Decorator;


interface  Pizza {
    String getDescription();
    int getPrice();
}
class BasePizza implements Pizza {

    @Override
    public String getDescription() {
        return "normal base pizza";
    }

    @Override
    public int getPrice() {
        return 10;
    }
}

abstract class PizzaDecorator implements Pizza {

    protected Pizza decoratedPizza;
    public PizzaDecorator(Pizza pizza) {
       decoratedPizza = pizza;
    }
}
class PannerDecorator extends PizzaDecorator {
    public PannerDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return "panner added " + decoratedPizza.getDescription();
    }

    @Override
    public int getPrice() {
        return 12 + decoratedPizza.getPrice();
    }
}
class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return "chess added  "+ decoratedPizza.getDescription();
    }

    @Override
    public int getPrice() {
        return 12 + decoratedPizza.getPrice();
    }
}
public class Simple {

    public static void main(String[] args) {

        Pizza pizza =  new CheeseDecorator( new PannerDecorator(new BasePizza()));

        System.out.println(pizza.getDescription());
        System.out.println(pizza.getPrice());

    }
}
