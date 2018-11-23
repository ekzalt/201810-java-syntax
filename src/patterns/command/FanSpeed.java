package patterns.command;

public enum FanSpeed {
    HIGH (3),
    MEDIUM (2),
    LOW (1),
    OFF (0);

    private int speed;

    FanSpeed(int speed) {
        this.speed = speed;
    }
}
