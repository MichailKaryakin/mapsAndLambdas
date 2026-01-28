package task2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private final HashMap<String, WeatherData> weatherDataMap = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    private final WeatherAPI weatherAPI = new WeatherAPI();

    public static void main(String[] args) {
        Main main = new Main();
        main.runSearch();
    }

    public void runSearch() {
        boolean exit = false;

        while (!exit) {
            System.out.println("(Нажмите 0, чтобы выйти)");
            System.out.println("Введите название города: ");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                exit = true;
            } else {
                System.out.println("Данные по погоде: " + getWeatherData(input));
            }
        }
    }

    public WeatherData getWeatherData(String city) {
        if (!weatherDataMap.containsKey(city)) {
            weatherDataMap.put(city, weatherAPI.getWeatherData(city));
        }
        return weatherDataMap.get(city);
    }
}
