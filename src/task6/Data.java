package task6;

import java.sql.Timestamp;
import java.util.Objects;

public class Data {
    private Integer id;
    private String value;
    private Timestamp lastAccessed;

    public Data(Integer id, String value, Timestamp timestamp) {
        this.id = id;
        this.value = value;
        this.lastAccessed = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Timestamp getTimestamp() {
        return lastAccessed;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.lastAccessed = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Objects.equals(id, data.id) && Objects.equals(value, data.value) && Objects.equals(lastAccessed, data.lastAccessed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, lastAccessed);
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", lastAccessed=" + lastAccessed +
                '}';
    }
}
