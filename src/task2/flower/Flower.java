package task2.flower;

public abstract class Flower implements Smelling {
    private Color color;
    private Freshness freshness;
    private Integer length;
    private Integer price;

    public Flower(Color color, Integer length, Integer price, Freshness freshness) {
        this.color = color;
        this.freshness = freshness;
        this.length = length;
        this.price = price;
    }

    public Flower(Color color, Integer length, Integer price) {
        this(color, length, price, Freshness.FRESH);
    }

    public Freshness getFreshness() {
        return freshness;
    }

    public void setFreshness(Freshness freshness) {
        this.freshness = freshness;
    }

    public Integer getPrice() {
        if (freshness.equals(Freshness.STALE))
            return price / 2;
        else
            return price;
    }

    public Integer getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "kind=" + getClass().getSimpleName() +
                ", color=" + color +
                ", freshness=" + freshness +
                ", length=" + length +
                ", price=" + price +
                '}';
    }
}
