package task4;

import task4.flower.Flower;

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
                flowers +
                '}';
    }
}
