package patterns.command;

public class Panel implements IPanel {
    private int slots;
    private CommandNone commandNone = new CommandNone();
    private ICommand commandUndo = new CommandNone();
    private ICommand[] onCommands;
    private ICommand[] offCommands;

    public Panel(int slots) {
        this.slots = slots;
        onCommands = new ICommand[slots];
        offCommands = new ICommand[slots];

        for (int i = 0; i < slots; i++) onCommands[i] = offCommands[i] = commandNone;
    }

    @Override
    public void setCommand(int slot, ICommand onCommand, ICommand offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    @Override
    public void pressOn(int slot) {
        onCommands[slot].execute();
        commandUndo = onCommands[slot];
    }

    @Override
    public void pressOff(int slot) {
        offCommands[slot].execute();
        commandUndo = onCommands[slot];
    }

    // logger
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n--- Control Panel ---\n");

        for (int i = 0; i < slots; i++) {
            sb.append("slot " + i + ": ON " +
                    onCommands[i].getClass().getName() + ", OFF " +
                    offCommands[i].getClass().getName() + "\n");
        }

        return sb.toString();
    }
}
