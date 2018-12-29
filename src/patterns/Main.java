package patterns;

import patterns.adapter.AdapterTurkey;
import patterns.adapter.Turkey;
import patterns.command.*;
import patterns.composer.ComponentItem;
import patterns.composer.ComponentNode;
import patterns.composer.ComponentWaitress;
import patterns.decorator.*;
import patterns.facade.FacadeHomeTheater;
import patterns.facade.PopcornMachine;
import patterns.facade.Screen;
import patterns.facade.Video;
import patterns.factory.*;
import patterns.iterator.*;
import patterns.observer.ConditionsDisplayCustom;
import patterns.observer.ConditionsDisplayNative;
import patterns.observer.WeatherObservableCustom;
import patterns.observer.WeatherObservableNative;
import patterns.proxy.DatingService;
import patterns.proxy.MonitorGumballMachine;
import patterns.singleton.SingleSync;
import patterns.singleton.SingleTemplate;
import patterns.singleton.SingleVolatile;
import patterns.state.GumballMachine;
import patterns.strategy.DuckBase;
import patterns.strategy.DuckMallard;
import patterns.strategy.FlyNoWay;
import patterns.strategy.QuackSqueak;
import patterns.template.Caffeine;
import patterns.template.Coffee;
import patterns.template.ComparableDuck;
import patterns.template.Tea;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Arrays;

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

        System.out.println("\n--- adapter ---\n");

        AdapterTurkey adapter = new AdapterTurkey(new Turkey());
        adapter.quack();
        adapter.fly();

        System.out.println("\n--- facade ---\n");

        FacadeHomeTheater homeTheater = new FacadeHomeTheater(
                new PopcornMachine(),
                new Screen(),
                new Light("living room"),
                new Video(),
                new Audio());

        homeTheater.watchMovie("Avengers");
        homeTheater.endMovie();

        System.out.println("\n--- template ---\n");

        String[] teaCondiments = {"sugar", "lemon"};
        String[] coffeeCondiments = {"sugar", "milk"};

        Caffeine tea = new Tea(teaCondiments);
        Caffeine coffee = new Coffee(coffeeCondiments);

        tea.prepareDrink();
        coffee.prepareDrink();

        ComparableDuck[] ducks = {
                new ComparableDuck("Daffy", 8),
                new ComparableDuck("Howard", 2),
                new ComparableDuck("Louie", 6),
                new ComparableDuck("Sidney", 4)
        };

        Arrays.sort(ducks);

        for (ComparableDuck duck : ducks) System.out.println(duck);

        System.out.println("\n--- iterator ---\n");

        IStore[] stores = {
                new StoreDiner(),
                new StorePancake(),
                new StoreCafe()
        };
        Waitress waitress = new Waitress(stores);

        waitress.printAll();

        System.out.println("\n--- composer ---\n");

        ComponentNode storePancake = new ComponentNode("Pancake Menu", "breakfast");
        ComponentNode storeDiner = new ComponentNode("Diner Menu", "lunch");
        ComponentNode storeCafe = new ComponentNode("Cafe Menu", "dinner");
        ComponentNode storeDessert = new ComponentNode("Dessert Menu", "dessert");
        ComponentNode storesAll = new ComponentNode("All Menus", "all combined menus");

        storesAll.add(storePancake);
        storesAll.add(storeDiner);
        storesAll.add(storeCafe);
        storesAll.add(storeDessert);

        storePancake.add(new ComponentItem(
                "K&B Pancake Breakfast",
                "Pancakes with scrambled eggs, toast",
                true,
                300));
        storePancake.add(new ComponentItem(
                "Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                300));
        storePancake.add(new ComponentItem(
                "Blueberry Pancakes",
                "Pancakes with fresh blueberries",
                true,
                350));
        storePancake.add(new ComponentItem(
                "Waffles",
                "Waffles with your choice blueberries or strawberries",
                true,
                360));

        storeDiner.add(new ComponentItem(
                "Vegetarian BLT",
                "Sauce with lettuce and tomato on whole wheat",
                true,
                300));
        storeDiner.add(new ComponentItem(
                "Vegetarian",
                "Bacon with lettuce and tomato on whole wheat",
                false,
                300));
        storeDiner.add(new ComponentItem(
                "Soup",
                "Soup with a side of potato salad",
                false,
                330));
        storeDiner.add(new ComponentItem(
                "Hot dog",
                "Hot dog with relish, onions, topped with cheese",
                false,
                310));

        storeCafe.add(new ComponentItem(
                "Veggie Burger",
                "Vegetarian burger on whole wheat bun, lettuce, tomato and fries",
                true,
                400));
        storeCafe.add(new ComponentItem(
                "Soup",
                "A cup of soup with a side of salad",
                false,
                370));
        storeCafe.add(new ComponentItem(
                "Burrito",
                "A large burrito with whole pinto beans, salsa, guacamole",
                true,
                430));

        storeDessert.add(new ComponentItem(
                "Apple Pie",
                "Apple pie with a flakey crust, topped with vanilla icecream",
                true,
                160));

        ComponentWaitress componentWaitress = new ComponentWaitress(storesAll);

        componentWaitress.printAll();
        // componentWaitress.printVegetarian();
        // componentWaitress.printNotVegetarian();

        System.out.println("\n--- state ---\n");

        GumballMachine machine = null;

        try {
            machine = new GumballMachine(2, "rmi://127.0.0.1/gm0");

            /*
            // register instance into remote rmi
            Naming.rebind("//127.0.0.1/gm0", machine);

            // getting instance from remote rmi
            GumballMachine gm0 = (GumballMachine) Naming.lookup("rmi://127.0.0.1/gm0");
            */
        } catch (Exception e) {
            e.printStackTrace();
        }

        machine.insertCoin();
        machine.turnCrank();

        System.out.println("\n--- proxy ---\n"); // the example needs rmiregistry

        MonitorGumballMachine monitor = new MonitorGumballMachine(machine);
        monitor.report();

        DatingService datingService = new DatingService();
        datingService.run();
    }
}
