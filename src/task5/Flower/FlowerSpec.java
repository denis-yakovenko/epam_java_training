package task5.Flower;

public class FlowerSpec {

    protected FlowerColor color;
    protected double length;
    protected FlowerType type;

    public FlowerSpec(FlowerColor color, double length, FlowerType type) {
        this.color = color;
        this.length = length;
        this.type = type;
    }

    public FlowerType getType() {
        return type;
    }

    public double getLength() {
        return length;
    }

    public FlowerColor getColor() {
        return color;
    }

    public boolean matches(FlowerSpec otherSpec) {

        if (color != otherSpec.getColor()) return false;
        if (length != otherSpec.getLength()) return false;
        if (type != otherSpec.getType()) return false;

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlowerSpec that = (FlowerSpec) o;

        if (Double.compare(that.length, length) != 0) return false;
        if (color != that.color) return false;
        return type == that.type;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = color.hashCode();
        temp = Double.doubleToLongBits(length);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + type.hashCode();
        return result;
    }
}
