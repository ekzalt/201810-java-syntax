package patterns.command;

public class CommandFanOff implements ICommand {
    private Fan fan;
    // запоминаем предыдущее состояние
    private FanSpeed prevSpeed;

    public CommandFanOff(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        prevSpeed = fan.getSpeed();
        fan.off();
    }

    @Override
    public void undo() {
        switch (prevSpeed) {
            case HIGH:
                fan.setHigh();
                break;
            case MEDIUM:
                fan.setMedium();
                break;
            case LOW:
                fan.setLow();
                break;
            case OFF:
                fan.off();
                break;
            default:
                fan.off();
        }
    }
}
