package patterns.command;

public class CommandFanLow implements ICommand {
    private Fan fan;
    // запоминаем предыдущее состояние
    private FanSpeed prevSpeed;

    public CommandFanLow(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        prevSpeed = fan.getSpeed();
        fan.setLow();
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
