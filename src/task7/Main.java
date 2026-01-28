package task7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    private final NotificationManager notificationManager = new NotificationManager();
    private final List<Notification> notifications = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.registerHandlers();
        main.createNotifications();

        for (Notification notification : main.notifications) {
            main.notificationManager.sendNotification(notification);
        }
    }

    public void registerHandlers() {
        notificationManager.registerHandler("Message", (notification) ->
                System.out.println(notification.getMessage()));

        notificationManager.registerHandler("Technical", (notification) -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Our platform requires some actions from you to work properly, " +
                    "push on the notification, and we'll redirect you");
        });

        notificationManager.registerHandler("Ad", (notification) ->
                System.out.println("Spam, never mind"));

        notificationManager.registerHandler("News", (notification) ->
                System.out.println("Most probably rubbish, but here are some news, click if you'd like to read!"));
    }

    public void createNotifications() {
        notifications.add(new Notification("Message", "Hey, let's play battlefield!"));

        notifications.add(new Notification("Technical", "Confirm your phone number, please"));

        notifications.add(new Notification("Ad", "Purchase our MEGA-super-premium subscription, " +
                "and your life (as well as your wallet) will forever be transformed!"));

        notifications.add(new Notification("News", "War, skyrocketing prices " +
                "and president's extramarital affairs: be with us and never miss on anything!"));

        notifications.add(new Notification("News", "Breaking news! " +
                "CIA is doing Venezuelan coke! " +
                "Meanwhile, unemployment rates are higher than ever! " +
                "Some negro dropped from the Empire State Building in an act of protest! " +
                "Here is our interview with the first two-headed mother! " +
                "And many more insides, outstanding facts and plain gibberish! Stay tuned!"));
    }
}
