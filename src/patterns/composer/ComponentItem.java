package patterns.composer;

import java.util.Iterator;

public class ComponentItem extends Component {
    private String name;
    private String description;
    private boolean vegetarian;
    private int price;

    public ComponentItem(String name,
                    String description,
                    boolean vegetarian,
                    int price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public void print() {
        System.out.println("$" + (double) getPrice() / 100 + " | " + getName() + (isVegetarian() ? " (v) " : " (m) ") + " | " + getDescription());
    }

    @Override
    public Iterator createIterator() {
        return new IteratorNull();
    }
}
