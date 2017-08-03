package task2;

import task2.flower.Flower;
import task2.flower.Freshness;

import java.util.ArrayList;

public class Bouquet {

    ArrayList<Flower> flowers = new ArrayList<>();

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public Integer getCost() {
        Integer cost = 0;
        for (Flower flower : flowers
                ) {
            cost += flower.getPrice();
        }
        return cost;
    }

    public float getFreshness() {
        Integer freshFlowersInBouquet = 0;
        for (Flower flower : flowers
                ) {
            if (flower.getFreshness().equals(Freshness.FRESH))
                freshFlowersInBouquet++;
        }
        return (float) freshFlowersInBouquet / flowers.size();
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "cost=" + getCost() +
                ", freshness=" + getFreshness() +
                ", flowers" + flowers +
                '}';
    }
}
