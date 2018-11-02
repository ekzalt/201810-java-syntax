package patterns;

import patterns.strategy.DuckBase;
import patterns.strategy.DuckMallard;
import patterns.strategy.FlyNoWay;
import patterns.strategy.QuackSqueak;

public class Main {
    public static void main(String[] args) {
        // стратегия

        DuckBase duckMallard = new DuckMallard();
        duckMallard.display();
        duckMallard.fly();
        duckMallard.quack();

        duckMallard.setFlyable(new FlyNoWay());
        duckMallard.setQuackable(new QuackSqueak());
        duckMallard.fly();
        duckMallard.quack();
    }
}
