package patterns.factory;

public interface IPizza {
    String getType();
    void prepare();
    void bake();
    void cut();
    void box();
}
