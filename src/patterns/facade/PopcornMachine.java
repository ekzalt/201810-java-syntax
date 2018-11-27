package patterns.facade;

import patterns.command.ISwitchable;

public class PopcornMachine implements ISwitchable {
    private int corn;

    public void setCorn(int grams) {
        corn = grams;
    }

    public int getCorn() {
        // cook corn
        return corn;
    }

    @Override
    public void on() {
        System.out.println("PopcornMachine is ON");
    }

    @Override
    public void off() {
        System.out.println("PopcornMachine is OF");
    }
}
