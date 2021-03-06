package patterns.adapter;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.function.Consumer;

public class AdapterEnumIterator implements Iterator {
    Enumeration enumeration;

    public AdapterEnumIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEachRemaining(Consumer action) {
        throw new UnsupportedOperationException();
    }
}
