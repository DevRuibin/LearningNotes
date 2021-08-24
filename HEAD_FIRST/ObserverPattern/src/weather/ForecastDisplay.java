package weather;

import org.jetbrains.annotations.NotNull;

public class ForecastDisplay implements Observer, DisplayElement{
    private float currentPressure = 29.92f;
    private float lastPressure;
    private WeatherData weatherData;

    public ForecastDisplay(@NotNull WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }


    @Override
    public void display() {
        System.out.println("Forecast:\n");
        if(currentPressure > lastPressure){
            System.out.println("Improving weather on the way");
        }else if(currentPressure == lastPressure){
            System.out.println("More of the same");
        }else {
            System.out.println("watch out for cooler, rainy weather");
        }

    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }
}
