package task6;

import java.sql.Timestamp;
import java.util.Scanner;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    private final Cache cacheSystem = new Cache();

    public static void main(String[] args) {
        new Main().menu();
    }

    public void menu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("""
                    1 - Добавить данные в структуру
                    2 - Получить данные по ID
                    3 - Показать содержимое кэша
                    0 - Выход
                    """);

            System.out.print("Выберите действие: ");
            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число.");
                continue;
            }

            switch (choice) {
                case 1 -> addDataToStructure();
                case 2 -> getData();
                case 3 -> cacheSystem.printCache();
                case 0 -> exit = true;
                default -> System.out.println("Нет такой опции");
            }
            System.out.println();
        }
    }

    private void addDataToStructure() {
        System.out.print("Введите строковое значение для данных: ");
        String value = scanner.nextLine();

        Data newData = new Data(0, value, new Timestamp(System.currentTimeMillis()));
        cacheSystem.addData(newData);

        System.out.println("Данные успешно добавлены в общую структуру.");
    }

    private void getData() {
        System.out.print("Введите ID для поиска: ");
        int idToFind;
        try {
            idToFind = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ID.");
            return;
        }

        Data foundData = cacheSystem.getDataById(idToFind);

        if (foundData != null) {
            System.out.println("Результат: " + foundData);
            System.out.println("Timestamp обновлен, данные помещены в кэш.");
        } else {
            System.out.println("Объект с ID " + idToFind + " не найден в структуре.");
        }
    }
}