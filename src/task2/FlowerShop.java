package task2;

import java.util.ArrayList;

public class FlowerShop {
    private ArrayList<Bouquet> bouquets = new ArrayList<>();

    public ArrayList<Bouquet> getBouquets() {
        return bouquets;
    }

    public void addBouquet(Bouquet bouquet) {
        bouquets.add(bouquet);
    }


}
