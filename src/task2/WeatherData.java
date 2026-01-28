package task2;

import java.util.Objects;

public record WeatherData(String city, Integer temperature, Integer humidity) {

    @Override
    public String toString() {
        return "{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        WeatherData that = (WeatherData) o;
        return Objects.equals(city, that.city) && Objects.equals(humidity, that.humidity) && Objects.equals(temperature, that.temperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, temperature, humidity);
    }
}
