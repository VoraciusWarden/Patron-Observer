package display;

import java.util.ArrayList;
import java.util.List;
import observer.Observer;
import subject.WeatherData;

public class StatisticsDisplay implements Observer, DisplayElement {
    private List<Float> temps = new ArrayList<>();

    public StatisticsDisplay(WeatherData weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        temps.add(temp);
        display();
    }

    @Override
    public void display() {
        float sum = 0;
        for (float t : temps) sum += t;
        float avg = sum / temps.size();
        float max = temps.stream().max(Float::compare).orElse(0f);
        float min = temps.stream().min(Float::compare).orElse(0f);

        System.out.println("Estadísticas -> Promedio: " + avg + "°C, Máx: " + max + "°C, Mín: " + min + "°C");
    }
}
