package patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class StorePancake implements IStore {
    private String title = "Menu Pancake Store";
    private ArrayList<MenuItem> menu = new ArrayList<MenuItem>();

    public StorePancake() {
        add(
                "K&B Pancake Breakfast",
                "Pancakes with scrambled eggs, toast",
                true,
                300);

        add(
                "Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                300);

        add(
                "Blueberry Pancakes",
                "Pancakes with fresh blueberries",
                true,
                350);

        add(
                "Waffles",
                "Waffles with your choice blueberries or strawberries",
                true,
                360);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Iterator createIterator() {
        return menu.iterator();
    }

    @Override
    public void add(String name,
                    String description,
                    boolean vegetarian,
                    int price) {
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        menu.add(item);
    }
}
