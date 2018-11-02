package patterns.strategy;

// реализуем конкретный класс
public class DuckMallard extends DuckBase {
    public DuckMallard() {
        // и инжектируем конкретное поведение воркеров (по умолчанию)
        flyable = new FlyWithWings();
        quackable = new Quack();
    }

    // также реализуем конкретный метод
    public void display() {
        System.out.println("I am a Mallard duck");
    }
}
