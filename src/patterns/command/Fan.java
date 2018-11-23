package patterns.command;

public class Fan {
    private FanSpeed speed = FanSpeed.OFF;
    private String room;

    public Fan(String room) {
        this.room = room;
    }

    public void setHigh() {
        speed = FanSpeed.HIGH;
        System.out.println("Fan is ON, speed is " + speed);
    }

    public void setMedium() {
        speed = FanSpeed.MEDIUM;
        System.out.println("Fan is ON, speed is " + speed);
    }

    public void setLow() {
        speed = FanSpeed.LOW;
        System.out.println("Fan is ON, speed is " + speed);
    }

    public void off() {
        speed = FanSpeed.OFF;
        System.out.println("Fan is OFF");
    }

    public FanSpeed getSpeed() {
        return speed;
    }
}
