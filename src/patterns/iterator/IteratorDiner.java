package patterns.iterator;

import java.util.Iterator;

public class IteratorDiner implements Iterator {
    private MenuItem[] menu;
    private int i = 0;

    public IteratorDiner(MenuItem[] menu) {
        this.menu = menu;
    }

    @Override
    public boolean hasNext() {
        if (i >= menu.length || menu[i] == null) return false;

        return true;
    }

    @Override
    public Object next() {
        MenuItem item = menu[i];
        i++;

        return item;
    }

    @Override
    public void remove() {
        if (i <= 0) throw new IllegalStateException("You cannot remove an item until you have done at least one next");

        if (menu[i -1] != null) {
            for (int j = i - 1; j < (menu.length - 1); j++) menu[j] = menu[j - 1];

            menu[menu.length - 1] = null;
        }
    }
}
