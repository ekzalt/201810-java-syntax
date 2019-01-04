package starter;

import java.util.Arrays;
import java.util.List;

// обобщенное программирование в java, использование дженериков
public class Comparer {
    // ограничение на тип - подходят только типы реализующие Comparable
    private static <T extends Comparable<T>> T getMax(List<T> list) {
        T max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            T item = list.get(i);

            if (item.compareTo(max) > 0) max = item;
        }

        return max;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        System.out.println(getMax(list));
    }
}
