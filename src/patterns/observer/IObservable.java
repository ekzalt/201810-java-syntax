package patterns.observer;

public interface IObservable {
    void subscribe(IObserver observer);
    void unsubscribe(IObserver observer);
    void notifyObservers();
}
