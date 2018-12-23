package patterns.state;

public class GumballMachine implements IState {
    private IState stateNoCoin;
    private IState stateHasCoin;
    private IState stateSold;
    private IState stateSoldOut;
    private IState stateWinner;
    private IState state;

    private int countBalls = 0;
    private int countCoins = 0;

    public GumballMachine() {
        initStates();
        fill(0);
    }

    public GumballMachine(int count) {
        initStates();
        fill(count);
    }

    private void initStates() {
        stateNoCoin = new StateNoCoin(this);
        stateHasCoin = new StateHasCoin(this);
        stateSold = new StateSold(this);
        stateSoldOut = new StateSoldOut(this);
        stateWinner = new StateWinner(this);
    }

    public int getCountBalls() {
        return countBalls;
    }

    public void fill(int count) {
        countBalls += count;

        if (getCountBalls() > 0) setState(getStateNoCoin());
        else setState(getStateSoldOut());
    }

    public int getCountCoins() {
        return countCoins;
    }

    public IState getStateNoCoin() {
        return stateNoCoin;
    }

    public IState getStateHasCoin() {
        return stateHasCoin;
    }

    public IState getStateSold() {
        return stateSold;
    }

    public IState getStateSoldOut() {
        return stateSoldOut;
    }

    public IState getStateWinner() {
        return stateWinner;
    }

    public void setState(IState state) {
        this.state = state;
    }

    @Override
    public void insertCoin() {
        try {
            state.insertCoin();
            countCoins++;
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void ejectCoin() {
        try {
            state.ejectCoin();

            if (getCountCoins() > 0) countCoins--;
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void turnCrank() {
        try {
            state.turnCrank();
            state.dispenseBall();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dispenseBall() {
        if (getCountBalls() > 0) {
            countBalls--;
            System.out.println("You got a gumball, " + getCountBalls() + " gumballs are inside");
        }
    }
}
