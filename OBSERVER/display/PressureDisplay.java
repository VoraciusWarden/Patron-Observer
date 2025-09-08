package display;

import observer.Observer;
import subject.WeatherData;


public class PressureDisplay implements Observer {
    private float pressure;

    public PressureDisplay(WeatherData weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("Presión actual: " + pressure);
    }
}
