package patterns.state;

public class StateSoldOut extends State {
    public StateSoldOut(GumballMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin() {
        throw new UnsupportedOperationException("The machine is sold out");
    }

    @Override
    public void ejectCoin() {
        throw new UnsupportedOperationException("The machine is sold out");
    }

    @Override
    public void turnCrank() {
        throw new UnsupportedOperationException("The machine is sold out");
    }

    @Override
    public void dispenseBall() {
        throw new UnsupportedOperationException("The machine is sold out");
    }
}
