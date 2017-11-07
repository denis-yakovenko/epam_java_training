package task5.Flower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlowerBucket extends Item {

    private List<Flower> flowers = new ArrayList<>();

    @Override
    public String getDescription() {
        return "Bucket{" +
                "flowers=" + flowers +
                "}";
    }

    @Override
    public double price() {
        double cost = 0;
        for (Flower flower : flowers
                ) {
            cost += flower.price;
        }
        return cost;
    }

    public boolean searchFlower(Flower flower) {
        for (Flower flower1 : flowers) {
            if (flower1.equals(flower)) {
                return true;
            }
        }
        return false;
    }

    public void addFlowers(Flower... flowers) {
        Collections.addAll(this.flowers, flowers);
    }

}
