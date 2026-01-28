package task11;

import java.util.Scanner;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    private final InventoryManager inventoryManager = new InventoryManager();
    private final Character character = new Character();

    public static void main(String[] args) {
        new Main().menu();
    }

    public Main() {
        character.setName("Elessar");
    }

    public void menu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("""
                    1 - Добавить предмет
                    2 - Удалить предмет по имени
                    3 - Изменить ценность предмета
                    4 - Показать инвентарь
                    0 - Выход
                    """);

            System.out.print("Выберите действие: ");
            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Введите число.");
                continue;
            }

            switch (choice) {
                case 1 -> addItem();
                case 2 -> removeItem();
                case 3 -> updateItem();
                case 4 -> printInventory();
                case 0 -> exit = true;
                default -> System.out.println("Нет такой опции");
            }

            System.out.println();
        }
    }

    private void addItem() {
        System.out.print("Введите имя предмета: ");
        String name = scanner.nextLine();

        System.out.print("Введите ценность предмета: ");
        double value;

        try {
            value = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Некорректное число.");
            return;
        }

        Item item = new Item(name, value);

        inventoryManager.addItem(character, item,
                c -> System.out.println("Предмет добавлен. Всего предметов: " + c.getItems().size())
        );
    }

    private void removeItem() {
        System.out.print("Введите имя предмета для удаления: ");
        String name = scanner.nextLine();

        inventoryManager.removeItem(character,
                item -> item.getName().equalsIgnoreCase(name)
        );

        System.out.println("Удаление выполнено (если предмет существовал).");
    }

    private void updateItem() {
        System.out.print("Введите имя предмета для изменения: ");
        String name = scanner.nextLine();

        System.out.print("Введите новое значение: ");
        double newValue;

        try {
            newValue = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Некорректное число.");
            return;
        }

        inventoryManager.updateItem(
                character,
                item -> item.getName().equalsIgnoreCase(name),
                item -> {
                    item.setValue(newValue);
                    return item;
                }
        );

        System.out.println("Изменение выполнено (если предмет существовал).");
    }

    private void printInventory() {
        if (character.getItems().isEmpty()) {
            System.out.println("Инвентарь пуст.");
            return;
        }

        System.out.println("Инвентарь:");
        character.getItems().forEach(item ->
                System.out.println(item.getName() + " | value = " + item.getValue())
        );
    }
}
