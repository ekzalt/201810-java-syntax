package patterns.decorator;

public class DecoratorMocha extends Beverage {
    public DecoratorMocha(Beverage beverage) {
        this.description = beverage.getDescription() + ", Mocha";
        this.cost = beverage.getCost() + 20;
    }

    public DecoratorMocha(Beverage beverage, int number) {
        this.description = beverage.getDescription() + ", Mocha " + number;
        this.cost = beverage.getCost() + 20 * number;
    }
}
