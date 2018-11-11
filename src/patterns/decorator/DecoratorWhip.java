package patterns.decorator;

public class DecoratorWhip extends Beverage {
    public DecoratorWhip(Beverage beverage) {
        this.description = beverage.getDescription() + ", Whip";
        this.cost = beverage.getCost() + 10;
    }

    public DecoratorWhip(Beverage beverage, int number) {
        this.description = beverage.getDescription() + ", Whip " + number;
        this.cost = beverage.getCost() + 10 * number;
    }
}
