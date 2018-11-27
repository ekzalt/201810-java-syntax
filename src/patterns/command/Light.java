package patterns.command;

public class Light implements ISwitchable {
    private String room;
    private int brightness = 100;

    public Light(String room) {
        this.room = room;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    @Override
    public void on() {
        System.out.println("Light in " + room + " is ON, brightness " + brightness + "%");
    }

    @Override
    public void off() {
        System.out.println("Light in " + room + " is OFF");
    }
}
