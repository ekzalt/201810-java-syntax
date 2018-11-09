package patterns;

import patterns.observer.ConditionsDisplayCustom;
import patterns.observer.ConditionsDisplayNative;
import patterns.observer.WeatherObservableCustom;
import patterns.observer.WeatherObservableNative;
import patterns.strategy.DuckBase;
import patterns.strategy.DuckMallard;
import patterns.strategy.FlyNoWay;
import patterns.strategy.QuackSqueak;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n--- strategy ---\n");

        DuckBase duckMallard = new DuckMallard();
        duckMallard.display();
        duckMallard.fly();
        duckMallard.quack();

        duckMallard.setFlyable(new FlyNoWay());
        duckMallard.setQuackable(new QuackSqueak());
        duckMallard.fly();
        duckMallard.quack();

        System.out.println("\n--- observer ---\n");

        // вариант 1
        WeatherObservableCustom observableCustom = new WeatherObservableCustom();
        // ConditionsDisplayCustom displayCustom = new ConditionsDisplayCustom(observableCustom);
        ConditionsDisplayCustom displayCustom = new ConditionsDisplayCustom();
        observableCustom.subscribe(displayCustom);

        // насильное внедрение данных в наблюдателя
        observableCustom.setData(20.20, 60.60, 80.80);

        // вариант 2
        WeatherObservableNative observableNative = new WeatherObservableNative();
        ConditionsDisplayNative displayNative = new ConditionsDisplayNative();
        observableNative.addObserver(displayNative);

        observableNative.setData(25.25, 65.65, 85.85);
        // наблюдатель сам получает данные по требованию
        displayNative.update(observableNative, observableNative);

        System.out.println("\n--- decorator ---\n");
    }
}
