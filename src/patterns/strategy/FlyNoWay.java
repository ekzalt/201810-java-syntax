package patterns.strategy;

// конкретная реализация поведения воркера
public class FlyNoWay implements IFlyable {
    public void fly() {
        System.out.println("I cannot fly");
    }
}
