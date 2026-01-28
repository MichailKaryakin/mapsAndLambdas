package task10;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> userFilters) {
        for (MessageFilter userFilter : userFilters) {
            if (!userFilter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
