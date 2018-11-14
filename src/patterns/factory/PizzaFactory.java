package patterns.factory;

public class PizzaFactory implements IPizzaFactory {
    protected String name;

    public PizzaFactory() {
        this.name = "Default";
    }

    public String getName() {
        return name;
    }

    // фабричный метод, обычно объявлется абстрактым,
    // чтобы обязать субклассы его реализовать
    public IPizza create(String type) {
        IPizza pizza;

        if (type.equals("cheese")) pizza = new PizzaCheese();
        else if (type.equals("pepperoni")) pizza = new PizzaPepperoni();
        else pizza = new Pizza();

        return pizza;
    }
}
