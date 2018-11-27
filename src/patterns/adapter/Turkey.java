package patterns.adapter;

import patterns.strategy.IFlyable;

public class Turkey implements IGobblable, IFlyable {
    @Override
    public void gobble() {
        System.out.println("gobble gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I fly a short distance");
    }
}
