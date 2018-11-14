package patterns.factory;

public interface IPizzaStore {
    IPizza order(String type);
    void setFactory(IPizzaFactory factory);
    String getFactoryName();
}
