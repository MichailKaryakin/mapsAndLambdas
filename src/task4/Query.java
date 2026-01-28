package task4;

import java.sql.Timestamp;

public class Query {
    private Integer id;
    private String content;
    private Timestamp timestamp;

    public Query(Integer id, String content, Timestamp timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", content = '" + content + '\'' +
                ", timestamp = " + timestamp;
    }
}
