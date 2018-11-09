package patterns.observer;

public interface IObserver {
    void update(double temperature, double humidity, double pressure);
}
