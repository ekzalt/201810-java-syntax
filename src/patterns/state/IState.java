package patterns.state;

// needs for rmi
import java.io.Serializable;

public interface IState extends Serializable {
    void insertCoin();
    void ejectCoin();
    void turnCrank();
    void dispenseBall();
}
