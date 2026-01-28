package task7;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> handleMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        if (handleMap.containsKey(type)) {
            System.out.println("Вы сменили обрабатывающую функцию!");
            handleMap.put(type, consumer);
        } else {
            handleMap.put(type, consumer);
        }
    }

    public void sendNotification(Notification notification) {
        handleMap.get(notification.getType()).accept(notification);
    }
}
