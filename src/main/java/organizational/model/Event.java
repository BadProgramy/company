package organizational.model;

public class Event {
    private int id;
    private String description;
    private String name;

    public Event() {
    }

    public Event(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public void addDescription(String description) {
        this.description+=description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
