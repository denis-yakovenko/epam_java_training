package task2;

import java.util.ArrayList;
import java.util.List;

public class FlowerShop {
    private List<Bouquet> bouquets = new ArrayList<>();

    public List<Bouquet> getBouquets() {
        return bouquets;
    }

    public void addBouquet(Bouquet bouquet) {
        bouquets.add(bouquet);
    }

}
