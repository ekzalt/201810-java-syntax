package patterns.iterator;

import java.util.Iterator;

public interface IStore {
    String getTitle();
    Iterator createIterator();
    void add(String name,
             String description,
             boolean vegetarian,
             int price);
}
