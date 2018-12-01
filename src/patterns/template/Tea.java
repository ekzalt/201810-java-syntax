package patterns.template;

public class Tea extends Caffeine {
    public Tea(String[] condiments) {
        super(condiments);
    }

    @Override
    protected void brewCaffeine() {
        System.out.println("steeping the tea");
    }
}
