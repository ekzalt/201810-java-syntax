package patterns.state;

public class StateSold extends State {
    public StateSold(GumballMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin() {
        throw new UnsupportedOperationException("Giving a gumball is in progress");
    }

    @Override
    public void ejectCoin() {
        throw new UnsupportedOperationException("You cannot eject a coin after the crank was turned");
    }

    @Override
    public void turnCrank() {
        throw new UnsupportedOperationException("You already turned the crank");
    }

    @Override
    public void dispenseBall() {
        machine.dispenseBall();

        if (machine.getCountBalls() > 0) machine.setState(machine.getStateNoCoin());
        else machine.setState(machine.getStateSoldOut());
    }
}
