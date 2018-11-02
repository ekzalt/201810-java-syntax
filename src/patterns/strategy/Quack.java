package patterns.strategy;

// конкретная реализация поведения воркера
public class Quack implements IQuackable {
    public void quack() {
        System.out.println("quack quack quack");
    }
}
