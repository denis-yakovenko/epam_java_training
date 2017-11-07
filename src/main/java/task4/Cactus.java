package task4;

public class Cactus extends Plant implements CanStoreWater {
    private Double storedWater;

    public Cactus(String name, Color color, Integer height, Double storedWater, Integer price) {
        super(name, color, height, Freshness.FRESH, price);
        this.storedWater = storedWater;
    }

    @Override
    public void smell() {
        System.out.println("smell like " + getName());
    }

    @Override
    public Double getStoredWater() {
        return storedWater;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cactus cactus = (Cactus) o;
        return super.equals(cactus) &&
                getStoredWater().equals(cactus.getStoredWater());

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getStoredWater().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Cactus{" +
                super.toString()+
                ", storedWater=" + storedWater +
                '}';
    }
}
