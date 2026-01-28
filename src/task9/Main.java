package task9;

public class Main {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        fareCalculator.calculateFare(5, 15, ((distance, timeMinutes) -> {
            int price = distance * timeMinutes * 5;
            System.out.println(price);
            return price;
        }));

        fareCalculator.calculateFare(20, 60, ((distance, timeMinutes) -> {
            double price = distance * timeMinutes * 0.8;
            System.out.println((int) price);
            return (int) price;
        }));

        fareCalculator.calculateFare(100, 300, ((distance, timeMinutes) -> {
            double price = distance * timeMinutes * 0.1;
            System.out.println((int) price);
            return (int) price;
        }));
    }
}
