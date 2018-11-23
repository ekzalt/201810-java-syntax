package patterns.command;

public class Door implements IOpenable {
    private String room;

    public Door(String room) {
        this.room = room;
    }

    @Override
    public void open() {
        System.out.println("Door in " + room + " is OPEN");
    }

    @Override
    public void close() {
        System.out.println("Door in " + room + " is CLOSE");
    }
}
