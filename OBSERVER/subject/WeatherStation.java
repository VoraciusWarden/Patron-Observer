package subject;

import display.CurrentConditionsDisplay;
import display.ForecastDisplay;
import display.HeatIndexDisplay;
import display.PressureDisplay;
import display.StatisticsDisplay;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();


        new CurrentConditionsDisplay(weatherData);
        new ForecastDisplay(weatherData);
        new HeatIndexDisplay(weatherData);
        new PressureDisplay(weatherData);
        new StatisticsDisplay(weatherData);

        //  Simulaciones
        System.out.println("-> | Simulación 1 | <-");
        weatherData.setMeasurements(56, 14, 106.1f);
        System.out.println("-> | Simulación 2 | <-");
        weatherData.setMeasurements(35, 70, 10.5f);
        System.out.println("-> | Simulación 3 |<-");
        weatherData.setMeasurements(8, 250, 536.2f);
    }
}
