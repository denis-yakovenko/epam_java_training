package task2.util;

import task2.Bouquet;
import task2.flower.Flower;
import task2.flower.Freshness;

public class BouquetUtil {
    public static Integer getCost(Bouquet bouquet) {
        Integer cost = 0;
        for (Flower flower : bouquet.getFlowers()
                ) {
            cost += flower.getPrice();
        }
        return cost;
    }

    public static float getFreshness(Bouquet bouquet) {
        Integer freshFlowersInBouquet = 0;
        for (Flower flower : bouquet.getFlowers()
                ) {
            if (flower.getFreshness().equals(Freshness.FRESH))
                freshFlowersInBouquet++;
        }
        return (float) freshFlowersInBouquet / bouquet.getFlowers().size();
    }
}
