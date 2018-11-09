package patterns.observer;

import java.util.Observable;
import java.util.Observer;

public class ConditionsDisplayNative implements Observer, IDisplay {
    // private Observable observable;
    private double temperature, humidity, pressure;

    /*
    public ConditionsDisplayNative(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }
    */

    public void render() {
        System.out.println("температура: " + temperature + "C, влажность: " + humidity + "%, давление: " + pressure + "мм");
    }

    public void update(Observable observable, Object params) {
        if (params instanceof WeatherObservableNative) {
            WeatherObservableNative data = (WeatherObservableNative)params;

            this.temperature = data.getTemperature();
            this.humidity = data.getHumidity();
            this.pressure = data.getPressure();

            render();
        }
    }
}
