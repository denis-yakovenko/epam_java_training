package task5.Flower;

public class CactusFlower extends Flower {
    public CactusFlower(boolean fresh, double price, double length, FlowerColor color) {
        super(fresh, price, new FlowerSpec(color, length, FlowerType.CACTUS));
    }
}
