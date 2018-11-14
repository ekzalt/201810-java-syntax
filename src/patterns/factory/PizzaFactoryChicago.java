package patterns.factory;

public class PizzaFactoryChicago extends PizzaFactory {
    public PizzaFactoryChicago() {
        name = "Chicago";
    }

    @Override
    public IPizza create(String type) {
        IPizza pizza;

        if (type.equals("cheese")) pizza = new PizzaCheeseChicago();
        else if (type.equals("pepperoni")) pizza = new PizzaPepperoniChicago();
        else pizza = new Pizza();

        return pizza;
    }
}
