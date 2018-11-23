package patterns.command;

public interface IPanel {
    void setCommand(int slot, ICommand onCommand, ICommand offCommand);
    void pressOn(int slot);
    void pressOff(int slot);
}
