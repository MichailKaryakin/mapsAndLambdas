package task6;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Cache {
    private final Map<Integer, Data> structure = new HashMap<>();
    private final Map<Integer, Data> cache = new HashMap<>();
    private final int CACHE_SIZE = 64;
    private int id = 1;

    public void addData(Data data) {
        structure.put(id++, data);
    }

    public Data getDataById(int id) {
        if (structure.containsKey(id)) {
            Data data;
            if (cache.containsKey(id)) {
                data = cache.get(id);
            } else {
                data = structure.get(id);
                checkCache();
                cache.put(id, data);
            }
            data.setTimestamp(new Timestamp(System.currentTimeMillis()));
            return data;
        } else {
            return null;
        }
    }

    private void checkCache() {
        if (cache.size() >= CACHE_SIZE) {
            Timestamp minTimestamp = new Timestamp(System.currentTimeMillis());
            int removalId = 0;
            for (Map.Entry<Integer, Data> entry : cache.entrySet()) {
                if (entry.getValue().getTimestamp().before(minTimestamp)) {
                    minTimestamp = entry.getValue().getTimestamp();
                    removalId = entry.getKey();
                }
            }

            cache.remove(removalId);
        }
    }

    public void printCache() {
        for (Map.Entry<Integer, Data> entry : cache.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
