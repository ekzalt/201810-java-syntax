package patterns.template;

import org.jetbrains.annotations.NotNull;

// для шаблонного метода алгоритма сортировки реализуем compareTo
public class ComparableDuck implements Comparable {
    private String name;
    private int weight;

    public ComparableDuck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + " weights " + weight;
    }

    @Override
    public int compareTo(@NotNull Object object) {
        ComparableDuck duck = (ComparableDuck) object;

        if (this.getWeight() < duck.getWeight()) return -1;
        else if (this.getWeight() == duck.getWeight()) return 0;
        else return 1;
    }
}
