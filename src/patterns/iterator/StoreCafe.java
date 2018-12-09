package patterns.iterator;

import java.util.Hashtable;
import java.util.Iterator;

public class StoreCafe implements IStore {
    private String title = "Menu Cafe Store";
    private Hashtable<String, MenuItem> menu = new Hashtable();

    public StoreCafe() {
        add(
                "Veggie Burger",
                "Vegetarian burger on whole wheat bun, lettuce, tomato and fries",
                true,
                400);

        add(
                "Soup",
                "A cup of soup with a side of salad",
                false,
                370);

        add(
                "Burrito",
                "A large burrito with whole pinto beans, salsa, guacamole",
                true,
                430);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Iterator createIterator() {
        return menu.values().iterator();
    }

    @Override
    public void add(String name, String description, boolean vegetarian, int price) {
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        menu.put(item.getName(), item);
    }
}
