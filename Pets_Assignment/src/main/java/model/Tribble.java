package model;

public class Tribble {

    private int id;
    private String name;
    private String color;
    private String noise;
    private String description;

    public Tribble() {
    }

    public Tribble(int id, String name, String color, String noise, String description) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.noise = noise;
        this.description = description;
    }

    public Tribble(int id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Tribble(String name, String color, String noise, String description) {
        this.name = name;
        this.color = color;
        this.noise = noise;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNoise() {
        return noise;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Tribble{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", noise='" + noise + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
