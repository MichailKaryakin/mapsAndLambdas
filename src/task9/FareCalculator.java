package task9;

import java.util.function.BiFunction;

public class FareCalculator {
    public void calculateFare(Integer distance, Integer timeMinutes, BiFunction<Integer, Integer, Integer> calculator) {
        calculator.apply(distance, timeMinutes);
    }
}
