package display;

import java.util.List;
import java.util.ArrayList;

import observer.Observer;
import subject.WeatherData;

public class StatisticsDisplay implements Observer {
    private List<Float> temperatureReadings;

    public StatisticsDisplay(WeatherData weatherData) {
        this.temperatureReadings = new ArrayList<>();
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        temperatureReadings.add(temp);
        display();
    }

    public void display() {
        float sum = 0;
        for (float t : temperatureReadings) {
            sum += t;
        }
        float avg = sum / temperatureReadings.size();
        float max = temperatureReadings.stream().max(Float::compare).orElse(0f);
        float min = temperatureReadings.stream().min(Float::compare).orElse(0f);

        System.out.println("Estadísticas -> Promedio: " + avg + "°C, Máx: " + max + "°C, Mín: " + min + "°C");
    }
}
