package patterns.strategy;

// конкретная реализация поведения воркера
public class FlyWithWings implements IFlyable {
    public void fly() {
        System.out.println("I fly with wings");
    }
}
