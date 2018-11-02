package patterns.strategy;

// конкретная реализация поведения воркера
public class QuackSqueak implements IQuackable {
    public void quack() {
        System.out.println("squeak squeak squeak");
    }
}
