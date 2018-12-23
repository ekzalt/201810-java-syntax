package patterns.composer;

import java.util.Iterator;

public class ComponentWaitress {
    Component menu;

    public ComponentWaitress(Component menu) {
        this.menu = menu;
    }

    public void printAll() {
        menu.print();
    }

    public void printVegetarian() {
        Iterator<Component> iterator = menu.createIterator();

        System.out.println("\nVegetarian Menu\n");

        while (iterator.hasNext()) {
            Component component = iterator.next();

            try {
                if (component.isVegetarian()) component.print();
            } catch (UnsupportedOperationException e) {
                System.err.println("Not vegetarian has been found");
            }
        }
    }

    public void printNotVegetarian() {
        Iterator<Component> iterator = menu.createIterator();

        System.out.println("\nNot Vegetarian Menu\n");

        while (iterator.hasNext()) {
            Component component = iterator.next();

            try {
                if (!component.isVegetarian()) component.print();
            } catch (UnsupportedOperationException e) {
                System.err.println("Vegetarian has been found");
            }
        }
    }
}
