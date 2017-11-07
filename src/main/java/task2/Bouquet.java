package task2;

import task2.flower.Flower;
import task2.util.BouquetUtil;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {

    List<Flower> flowers = new ArrayList<>();

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "cost=" + BouquetUtil.getCost(this) +
                ", freshness=" + BouquetUtil.getFreshness(this) +
                ", flowers" + flowers +
                '}';
    }
}
