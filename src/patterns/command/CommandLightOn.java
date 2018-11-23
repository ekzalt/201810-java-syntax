package patterns.command;

public class CommandLightOn implements ICommand {
    private Light light;

    public CommandLightOn(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
