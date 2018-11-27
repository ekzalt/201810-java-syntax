package patterns.facade;

public class Screen implements IVertically {
    @Override
    public void up() {
        System.out.println("Screen moved UP");
    }

    @Override
    public void down() {
        System.out.println("Screen moved DOWN");
    }
}
