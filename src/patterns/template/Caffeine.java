package patterns.template;

public abstract class Caffeine {
    protected String[] condiments;

    public Caffeine(String[] condiments) {
        this.condiments = condiments;
    }

    // стандартные методы по умолчанию
    protected void boilWater() {
        System.out.println("boil water");
    }

    protected void pourCup() {
        System.out.println("pour into cup");
    }

    protected void addCondiments(String[] condiments) {
        for (String condiment : condiments) {
            System.out.println("add " + condiment);
        }
    }

    /*
    Стандартные методы могут иметь пустую реализацию
    и влиять на алгоритм.
    Суб-класс их может переовределить и вмешаться в алгоритм.
    Такие методы называются "перехватчики".
    */
    protected boolean needCondiments() {
        return true;
    }

    // методы различные в реализации
    protected abstract void brewCaffeine();

    // не переопределяемый наследуемый шаблонный метод
    public final void prepareDrink() {
        boilWater();
        brewCaffeine();
        pourCup();
        if (needCondiments()) addCondiments(condiments);
    }
}
