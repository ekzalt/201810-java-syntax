package patterns.command;

// создание макросов - списка комманд для последовательного исполнения
public class CommandMacro implements ICommand {
    ICommand[] commands;

    public CommandMacro(ICommand[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (ICommand command : commands) command.execute();
    }

    @Override
    public void undo() {
        for (ICommand command : commands) command.undo();
    }
}
