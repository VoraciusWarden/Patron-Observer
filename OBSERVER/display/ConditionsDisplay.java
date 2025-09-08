package display;

import observer.Observer;
import subject.WeatherData;

public class ConditionsDisplay implements Observer {
    private float temperature;
    private float humidity;

    public ConditionsDisplay(WeatherData weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Condiciones actuales: " + temperature + "°C y " + humidity + "% humedad");
    }
}
