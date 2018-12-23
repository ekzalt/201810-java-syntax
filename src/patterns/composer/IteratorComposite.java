package patterns.composer;

import java.util.Iterator;
import java.util.Stack;

public class IteratorComposite implements Iterator {
    private Stack<Iterator<Component>> stack = new Stack();

    public IteratorComposite(Iterator<Component> iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()) return false;

        Iterator<Component> iterator = stack.peek();

        if (iterator.hasNext()) return true;

        stack.pop();
        return hasNext();
    }

    @Override
    public Object next() {
        if (!hasNext()) return null;

        Iterator<Component> iterator = stack.peek();
        Component component = iterator.next();

        if (component instanceof ComponentNode) stack.push(component.createIterator());

        return component;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
