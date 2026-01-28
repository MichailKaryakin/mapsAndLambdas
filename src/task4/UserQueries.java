package task4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserQueries {
    private final HashMap<User, List<Query>> userQueries = new HashMap<>();

    public boolean newUser(User user, List<Query> queries) {
        if (userQueries.containsKey(user)) {
            return false;
        } else {
            userQueries.put(user, queries);
            return true;
        }
    }

    public boolean appendQuery(User user, Query query) {
        if (userQueries.containsKey(user)) {
            userQueries.get(user).add(query);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteEntry(User user) {
        if (userQueries.containsKey(user)) {
            userQueries.remove(user);
            return true;
        } else {
            return false;
        }
    }

    public String queryHistory(User user) {
        StringBuilder data = new StringBuilder();

        for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
            if (entry.getKey().equals(user)) {
                data.append("Пользователь: ").append(entry.getKey()).append("\n");

                entry.getValue()
                        .stream()
                        .sorted(Comparator.comparing(Query::getTimestamp))
                        .forEach(query -> data.append("Запрос: ").append(query).append("\n"));

                data.append("\n");
            }
        }

        return data.toString();
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();

        for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
            data.append("Пользователь: ").append(entry.getKey()).append("\n");
            for (Query query : entry.getValue()) {
                data.append("Запрос: ").append(query).append("\n");
            }
            data.append("\n");
        }

        return data.toString();
    }
}
