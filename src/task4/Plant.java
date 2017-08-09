package task4;

public abstract class Plant implements CanSmell {
    private String name;
    private Color color;
    private Integer height;
    private Freshness freshness;

    public Plant(String name, Color color, Integer height, Freshness freshness) {
        this.name = name;
        this.color = color;
        this.height = height;
        this.freshness = freshness;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Integer getHeight() {
        return height;
    }

    public Freshness getFreshness() {
        return freshness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return getName().equals(plant.getName()) &&
                getColor() == plant.getColor() &&
                getHeight().equals(plant.getHeight()) &&
                getFreshness().equals(plant.getFreshness());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getColor().hashCode();
        result = 31 * result + getHeight().hashCode();
        result = 31 * result + getFreshness().hashCode();
        return result;
    }
}
