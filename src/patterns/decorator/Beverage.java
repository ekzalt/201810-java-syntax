package patterns.decorator;

public abstract class Beverage implements IBeverage {
    protected String description;
    protected int cost;

    protected String getDescription() {
        return description;
    }

    protected int getCost() {
        return cost;
    }

    public void print() {
        System.out.println("cost: $" + ((double)getCost() / 100) + ", beverage: " + getDescription());
    }
}
