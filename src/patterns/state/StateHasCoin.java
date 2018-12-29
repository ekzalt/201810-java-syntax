package patterns.state;

import java.util.Random;

public class StateHasCoin extends State {
    private Random random = new Random(System.currentTimeMillis());

    public StateHasCoin(GumballMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin() {
        throw new UnsupportedOperationException("You cannot insert another coin");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Returning coin was selected");
        machine.setState(machine.getStateNoCoin());
    }

    @Override
    public void turnCrank() {
        System.out.println("Crank was turned");
        int winner = random.nextInt(10);

        if (winner == 0 && machine.getCountBalls() > 1) machine.setState(machine.getStateWinner());
        else machine.setState(machine.getStateSold());
    }

    @Override
    public void dispenseBall() {
        throw new UnsupportedOperationException("You must select action - eject coin or turn crank");
    }
}
