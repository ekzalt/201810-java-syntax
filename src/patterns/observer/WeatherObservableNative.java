package patterns.observer;

import java.util.Observable;

public class WeatherObservableNative extends Observable {
    private double temperature, humidity, pressure;

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setDataChanged() {
        setChanged();
        notifyObservers();
    }

    public void setData(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        setDataChanged();
    }
}
