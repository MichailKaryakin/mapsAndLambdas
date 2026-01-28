package task11;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Character> consumer) {
        character.addItem(item);
        consumer.accept(character);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getItems().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        for (Item item : character.getItems()) {
            if (predicate.test(item)) {
                item.setValue(function.apply(item).getValue());
            }
        }
    }
}
