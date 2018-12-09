package patterns.iterator;

import java.util.Iterator;

public class StoreDiner implements IStore {
    public static final int MAX_LENGTH = 4;

    private String title = "Menu Diner Store";
    private int i = 0;
    private MenuItem[] menu = new MenuItem[MAX_LENGTH];

    public StoreDiner() {
        add(
                "Vegetarian BLT",
                "Sauce with lettuce and tomato on whole wheat",
                true,
                300);

        add(
                "Vegetarian",
                "Bacon with lettuce and tomato on whole wheat",
                false,
                300);

        add(
                "Soup",
                "Soup with a side of potato salad",
                false,
                330);

        add(
                "Hot dog",
                "Hot dog with relish, onions, topped with cheese",
                false,
                310);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Iterator createIterator() {
        return new IteratorDiner(menu);
    }

    @Override
    public void add(String name,
                    String description,
                    boolean vegetarian,
                    int price) {
        MenuItem item = new MenuItem(name, description, vegetarian, price);

        if (i < MAX_LENGTH) {
            menu[i] = item;
            i++;
        } else {
            System.err.println("You cannot add more items");
        }
    }
}
