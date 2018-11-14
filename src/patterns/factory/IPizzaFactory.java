package patterns.factory;

public interface IPizzaFactory {
    IPizza create(String type);
    String getName();
}
