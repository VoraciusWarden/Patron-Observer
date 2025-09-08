package display;

import observer.Observer;
import subject.WeatherData;

public class ForecastDisplay implements Observer {
    private float pressure;

    public ForecastDisplay(WeatherData weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("Pronóstico: presión = " + pressure);
    }
}
