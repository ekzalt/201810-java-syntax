package patterns.factory;

public class PizzaFactoryNY extends PizzaFactory {
    public PizzaFactoryNY() {
        name = "New York";
    }

    @Override
    public IPizza create(String type) {
        IPizza pizza;

        if (type.equals("cheese")) pizza = new PizzaCheeseNY();
        else if (type.equals("pepperoni")) pizza = new PizzaPepperoniNY();
        else pizza = new Pizza();

        return pizza;
    }
}
