package patterns.command;

public class Light implements ISwitchable {
    private String room;

    public Light(String room) {
        this.room = room;
    }

    @Override
    public void on() {
        System.out.println("Light in " + room + " is ON");
    }

    @Override
    public void off() {
        System.out.println("Light in " + room + " is OFF");
    }
}
