package patterns.strategy;

// создаем дазовый абстрактный класс
public abstract class DuckBase {
    // инжектируем воркеров в виде интерфейсов на верхнем уровне
    // в родительском классе
    IFlyable flyable;
    IQuackable quackable;

    // сеттеры для динамического изменения поведения воркеров
    public void setFlyable(IFlyable flyable) {
        this.flyable = flyable;
    }

    public void setQuackable(IQuackable quackable) {
        this.quackable = quackable;
    }

    // этот метод будет иметь уникальную реализацию в дочерних классах
    public abstract void display();

    public void fly() {
        flyable.fly();
    }

    public void quack() {
        quackable.quack();
    }

    // этот наследуемый метод одинаковый
    public void swim() {
        System.out.println("I swim");
    }
}
