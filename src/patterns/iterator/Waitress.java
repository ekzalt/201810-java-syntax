package patterns.iterator;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class Waitress {
    private IStore[] stores;

    public Waitress(IStore[] stores) {
        this.stores = stores;
    }

    private void printMenu(@NotNull Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem item = (MenuItem) iterator.next();
            System.out.println("$" + (double) item.getPrice() / 100 + " | " + item.getName() + " | " + item.getDescription());
        }
    }

    public void printAll() {
        for (IStore store : stores) {
            System.out.println("\n" + store.getTitle() + "\n");
            printMenu(store.createIterator());
        }
    }
}
