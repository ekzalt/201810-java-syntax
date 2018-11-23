package patterns.command;

public class CommandLightOff implements ICommand {
    private Light light;

    public CommandLightOff(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
