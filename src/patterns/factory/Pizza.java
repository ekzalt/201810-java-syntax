package patterns.factory;

public class Pizza implements IPizza {
    protected String type;

    public Pizza() {
        this.type = "Default Pizza";
    }

    public String getType() {
        return type;
    }

    public void prepare() {
        System.out.println("prepare pizza");
    }

    public void bake() {
        System.out.println("bake pizza");
    }

    public void cut() {
        System.out.println("cut pizza");
    }

    public void box() {
        System.out.println("box pizza");
    }
}
