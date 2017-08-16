package task5.Flower;

public abstract class Flower {

    protected boolean fresh;
    protected double price;
    protected FlowerSpec spec;

    public Flower(boolean fresh, double price, FlowerSpec spec) {
        this.fresh = fresh;
        this.price = price;
        this.spec = spec;
    }

    public FlowerSpec getSpec() {
        return spec;
    }

    public double getPrice() {
        return price;
    }

    public boolean isFresh() {
        return fresh;
    }

    public String toString() {
        return "Type: " + spec.getType() + " price is " + String.valueOf(getPrice()) + " its color is " + spec.getColor() + " fresh level is " + String.valueOf(isFresh()) + " its height " + String.valueOf(spec.getLength());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flower flower = (Flower) o;

        if (fresh != flower.fresh) return false;
        if (Double.compare(flower.price, price) != 0) return false;
        return spec.equals(flower.spec);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (fresh ? 1 : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + spec.hashCode();
        return result;
    }
}
