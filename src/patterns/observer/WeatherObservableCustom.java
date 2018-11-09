package patterns.observer;

import java.util.ArrayList;

public class WeatherObservableCustom implements IObservable {
    private ArrayList<IObserver> observers;
    private double temperature, humidity, pressure;

    public WeatherObservableCustom() {
        observers = new ArrayList();
    }

    public void subscribe(IObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(IObserver observer) {
        int i = observers.indexOf(observer);

        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setData(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        notifyObservers();
    }
}
