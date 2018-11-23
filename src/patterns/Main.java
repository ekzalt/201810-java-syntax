package patterns;

import patterns.command.*;
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

        System.out.println("\n--- command ---\n");

        Panel panel = new Panel(7);
        Light lightBedroom = new Light("bedroom");
        Door doorGarage = new Door("garage");
        Audio audio = new Audio();
        Fan kitchenFan = new Fan("kitchen");

        panel.setCommand(
                0,
                new CommandLightOn(lightBedroom),
                new CommandLightOff(lightBedroom));
        panel.setCommand(
                1,
                new CommandDoorOpen(doorGarage),
                new CommandDoorClose(doorGarage));
        panel.setCommand(
                2,
                new CommandAudioStartPlay(audio),
                new CommandAudioStopPlay(audio));
        panel.setCommand(
                3,
                new CommandFanLow(kitchenFan),
                new CommandFanOff(kitchenFan));

        panel.pressOn(0);
        panel.pressOn(1);
        panel.pressOn(2);
        panel.pressOn(3);
        panel.pressOff(0);
        panel.pressOff(1);
        panel.pressOff(2);
        panel.pressOff(3);

        // party time :)

        Light lightLivingRoom = new Light("living room");
        Fan fanLivingRoom = new Fan("living room");
        ICommand[] partyOnCommands = {
                new CommandLightOn(lightLivingRoom),
                new CommandFanLow(fanLivingRoom),
                new CommandAudioStartPlay(audio)
        };
        ICommand[] partyOffCommands = {
                new CommandLightOff(lightLivingRoom),
                new CommandFanOff(fanLivingRoom),
                new CommandAudioStopPlay(audio)
        };
        panel.setCommand(
                4,
                new CommandMacro(partyOnCommands),
                new CommandMacro(partyOffCommands));
        panel.pressOn(4); // start party
        panel.pressOff(4); // stop party

        System.out.println(panel);
    }
}
