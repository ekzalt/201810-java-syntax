package patterns.template;

public class Coffee extends Caffeine {
    public Coffee(String[] condiments) {
        super(condiments);
    }

    @Override
    protected void brewCaffeine() {
        System.out.println("dripping coffee through filter");
    }
}
