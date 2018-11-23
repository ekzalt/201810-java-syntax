package patterns.command;

public class CommandDoorClose implements ICommand {
    private Door door;

    public CommandDoorClose(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.close();
    }

    @Override
    public void undo() {
        door.open();
    }
}
