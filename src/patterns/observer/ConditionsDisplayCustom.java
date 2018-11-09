package patterns.observer;

public class ConditionsDisplayCustom implements IObserver, IDisplay {
    // private IObservable observable;
    private double temperature, humidity, pressure;

    /*
    public ConditionsDisplayCustom(IObservable observable) {
        this.observable = observable;
        observable.subscribe(this);
    }
    */

    public void render() {
        System.out.println("температура: " + temperature + "C, влажность: " + humidity + "%, давление: " + pressure + "мм");
    }

    public void update(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        render();
    }
}
