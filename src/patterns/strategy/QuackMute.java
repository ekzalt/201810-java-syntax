package patterns.strategy;

// конкретная реализация поведения воркера
public class QuackMute implements IQuackable {
    public void quack() {
        System.out.println("--- silence ---");
    }
}
