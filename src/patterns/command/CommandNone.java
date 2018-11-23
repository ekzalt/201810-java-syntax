package patterns.command;

public class CommandNone implements ICommand {
    @Override
    public void execute() {
        System.out.println("Do nothing by default");
    }

    @Override
    public void undo() {
        System.out.println("Do nothing by default");
    }
}
