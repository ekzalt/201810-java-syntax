package patterns.proxy;

import patterns.state.GumballMachine;

import java.rmi.RemoteException;

public class MonitorGumballMachine {
    GumballMachine machine;

    public MonitorGumballMachine(GumballMachine machine) {
        this.machine = machine;
    }

    public void report() {
        try {
            System.out.println("Location: " + machine.getLocation());
            System.out.println("Coins: " + machine.getCountCoins());
            System.out.println("Balls: " + machine.getCountBalls());
            System.out.println("State: " + machine.getState().getClass().getSimpleName());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
