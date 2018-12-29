package patterns.state;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemote extends Remote {
    String getLocation() throws RemoteException;
    int getCountCoins() throws RemoteException;
    int getCountBalls() throws RemoteException;
    IState getState() throws RemoteException;
}
