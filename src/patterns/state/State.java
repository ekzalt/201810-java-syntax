package patterns.state;

public abstract class State implements IState {
    protected transient GumballMachine machine;

    public State(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void ejectCoin() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void turnCrank() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void dispenseBall() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
