package task2;

import java.util.Random;

public class WeatherAPI {
    Random random = new Random();

    public WeatherData getWeatherData(String city) {
        return new WeatherData(city, random.nextInt(-50, 50), random.nextInt(0, 100));
    }
}
