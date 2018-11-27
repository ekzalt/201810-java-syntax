package patterns.adapter;

import patterns.strategy.IFlyable;
import patterns.strategy.IQuackable;

/*
Адаптер объектов реализует множественные интерфейсы
Адаптер классов использует множественное наследование (например в Python)
 */

public class AdapterTurkey implements IQuackable, IFlyable {
    private int duckDistance = 2;
    private Turkey turkey;

    public AdapterTurkey(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void fly() {
        for (int i = 0; i < duckDistance; i++) turkey.fly();
    }

    @Override
    public void quack() {
        turkey.gobble();
    }
}
