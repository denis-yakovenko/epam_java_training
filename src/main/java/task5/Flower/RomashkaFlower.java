package task5.Flower;

public class RomashkaFlower extends Flower {
    public RomashkaFlower(boolean fresh, double price, double length, FlowerColor color) {
        super(fresh, price, new FlowerSpec(color, length, FlowerType.ROMASHKA));
    }
}
