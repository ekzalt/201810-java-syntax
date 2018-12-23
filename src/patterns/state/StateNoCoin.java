package patterns.state;

public class StateNoCoin extends State {
    private GumballMachine machine;

    public StateNoCoin(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You inserted +1 coin to " + machine.getCountCoins() + " other coins");
        machine.setState(machine.getStateHasCoin());
    }

    @Override
    public void ejectCoin() {
        throw new UnsupportedOperationException("You did not insert coin");
    }

    @Override
    public void turnCrank() {
        throw new UnsupportedOperationException("You did not insert coin");
    }

    @Override
    public void dispenseBall() {
        throw new UnsupportedOperationException("You did not insert coin");
    }
}
