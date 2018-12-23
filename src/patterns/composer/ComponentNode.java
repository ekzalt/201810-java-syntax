package patterns.composer;

import java.util.ArrayList;
import java.util.Iterator;

public class ComponentNode extends Component {
    private ArrayList<Component> components = new ArrayList();
    private String name;
    private String description;
    private Iterator iterator = null;

    public ComponentNode(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return components.get(index);
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
    public void print() {
        System.out.println("\n" + getName());
        System.out.println(getDescription() + "\n");

        Iterator<Component> iterator = components.iterator();

        while (iterator.hasNext()) {
            Component component = iterator.next();
            component.print();
        }
    }

    @Override
    public Iterator createIterator() {
        if (iterator == null) iterator = new IteratorComposite(components.iterator());

        return iterator;
    }
}
