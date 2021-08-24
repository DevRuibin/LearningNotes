package weather;

import org.jetbrains.annotations.NotNull;

public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private final WeatherData weatherData;

    public WeatherData getWeatherData() {
        return weatherData;
    }



    public CurrentConditionDisplay(@NotNull WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: ");
        System.out.println("\ttemperature: " + temperature + "F degrees");
        System.out.println("\thumidity: " + humidity + "% humidity");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
}
