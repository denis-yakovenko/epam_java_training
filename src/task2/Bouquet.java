package task2;

import task2.flower.Flower;
import task2.util.BouquetUtil;

import java.util.ArrayList;

public class Bouquet {

    ArrayList<Flower> flowers = new ArrayList<>();

    public ArrayList<Flower> getFlowers() {
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
