package display;

import observer.Observer;
import subject.WeatherData;

public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure = 1013.0f;
    private float lastPressure;

    public ForecastDisplay(WeatherData weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }

    @Override
    public void display() {
        if (currentPressure > lastPressure) {
            System.out.println("Pronóstico: Mejorando el clima en camino!");
        } else if (currentPressure == lastPressure) {
            System.out.println("Pronóstico: Más de lo mismo");
        } else {
            System.out.println("Pronóstico: El clima se pondrá más fresco y lluvioso");
        }
    }
}
