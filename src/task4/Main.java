package task4;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final UserQueries userQueries = new UserQueries();

    public static void main(String[] args) {
        new Main().menu();
    }

    public void menu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("""
                    1 - Новый пользователь
                    2 - Добавить запрос пользователя
                    3 - Удалить пользователя
                    4 - История запросов
                    5 - Вывести все данные
                    0 - Выход
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> createUser();
                case 2 -> addQuery();
                case 3 -> deleteUser();
                case 4 -> showHistory();
                case 5 -> System.out.println(userQueries);
                case 0 -> exit = true;
                default -> System.out.println("Нет такой опции");
            }
        }
    }

    private void createUser() {
        System.out.print("ID пользователя: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Имя пользователя: ");
        String name = scanner.nextLine();

        User user = new User(id, name);
        boolean created = userQueries.newUser(user, new ArrayList<>());

        if (!created) {
            System.out.println("Пользователь уже существует");
            return;
        }

        System.out.println("Пользователь создан");
        addQueriesInteractive(user);
    }

    private void addQueriesInteractive(User user) {
        boolean addMore = true;

        while (addMore) {
            System.out.print("ID запроса: ");
            int queryId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Текст запроса: ");
            String content = scanner.nextLine();

            Query query = new Query(
                    queryId,
                    content,
                    new Timestamp(System.currentTimeMillis())
            );

            boolean appended = userQueries.appendQuery(user, query);
            System.out.println(appended ? "Запрос добавлен" : "Пользователь не найден");

            System.out.print("Добавить ещё один запрос? (y/n): ");
            String answer = scanner.nextLine();
            addMore = answer.equalsIgnoreCase("y");
        }
    }

    private void addQuery() {
        User user = readUser();
        addQueriesInteractive(user);
    }

    private void deleteUser() {
        User user = readUser();

        boolean deleted = userQueries.deleteEntry(user);
        System.out.println(deleted ? "Пользователь удалён" : "Пользователь не найден");
    }

    private void showHistory() {
        User user = readUser();

        String history = userQueries.queryHistory(user);
        System.out.println(history.isEmpty()
                ? "История пуста или пользователь не найден"
                : history);
    }

    private User readUser() {
        System.out.print("ID пользователя: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Имя пользователя: ");
        String name = scanner.nextLine();

        return new User(id, name);
    }
}
