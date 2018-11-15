package patterns;

import patterns.decorator.*;
import patterns.factory.*;
import patterns.observer.ConditionsDisplayCustom;
import patterns.observer.ConditionsDisplayNative;
import patterns.observer.WeatherObservableCustom;
import patterns.observer.WeatherObservableNative;
import patterns.singleton.SingleSync;
import patterns.singleton.SingleTemplate;
import patterns.singleton.SingleVolatile;
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

        // оборачиваем объект декораторами
        IBeverage beverage1 =
                new DecoratorWhip(
                        new DecoratorMocha(
                                new BeverageEspresso()));
        beverage1.print();

        // указываем количество порций
        IBeverage beverage2 = new DecoratorMocha(new BeverageHouseBlend(), 2);
        beverage2.print();

        System.out.println("\n--- factory ---\n");

        IPizzaStore store1 = new PizzaStore();
        IPizzaStore store2 = new PizzaStore(new PizzaFactoryNY());
        IPizzaStore store3 = new PizzaStore();
        store3.setFactory(new PizzaFactoryChicago());

        IPizza pizza1 = store1.order("cheese");
        IPizza pizza2 = store2.order("cheese");
        IPizza pizza3 = store3.order("cheese");

        System.out.println(pizza1.getType());
        System.out.println(pizza2.getType());
        System.out.println(pizza3.getType());

        System.out.println("\n--- singleton ---\n");

        SingleSync singleton1 = SingleSync.getInstance();
        SingleTemplate singleton2 = SingleTemplate.getInstance();
        SingleVolatile singleton3 = SingleVolatile.getInstance();

        singleton1.getType();
        singleton2.getType();
        singleton3.getType();
    }
}
