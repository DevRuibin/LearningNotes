package weather;

import org.jetbrains.annotations.NotNull;

public class StatisticsDisplay implements Observer, DisplayElement{
    private float maxTemp = 0f;
    private float minTemp = 200f;
    private float tempSum = 0f;
    private int numReadings;
    private WeatherData weatherData;

    public StatisticsDisplay(@NotNull WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        tempSum += temp;
        numReadings ++;
        maxTemp = Math.max(maxTemp, temp);
        minTemp = Math.min(minTemp, temp);
        display();
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }
}
