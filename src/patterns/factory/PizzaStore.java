package patterns.factory;

public class PizzaStore implements IPizzaStore {
    private IPizzaFactory factory;

    public PizzaStore() {
        this.factory = new PizzaFactory();
    }

    public PizzaStore(IPizzaFactory factory) {
        this.factory = factory;
    }

    public void setFactory(IPizzaFactory factory) {
        this.factory = factory;
    }

    public String getFactoryName() {
        return factory.getName();
    }

    // фасад
    public IPizza order(String type) {
        IPizza pizza = factory.create(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
