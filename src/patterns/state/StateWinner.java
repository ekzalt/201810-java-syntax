package patterns.state;

public class StateWinner extends State {
    private GumballMachine machine;

    public StateWinner(GumballMachine machine) {
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
        System.out.println("You are winner! You get 2 gumballs if they exist");

        if (machine.getCountBalls() > 1) {
            machine.dispenseBall();
            machine.dispenseBall();
        } else {
            machine.dispenseBall();
        }

        if (machine.getCountBalls() > 0) machine.setState(machine.getStateNoCoin());
        else machine.setState(machine.getStateSoldOut());
    }
}
