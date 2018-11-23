package patterns.command;

public class CommandDoorOpen implements ICommand {
    private Door door;

    public CommandDoorOpen(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.open();
    }

    @Override
    public void undo() {
        door.close();
    }
}
