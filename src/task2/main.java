package task2;

import task2.flower.*;
import task2.util.BouquetUtil;

public class main {
    public static void main(String[] args) {
        FlowerShop flowerShop = new FlowerShop();

        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(new Peon(Color.WHITE, 29, 55));
        bouquet.addFlower(new Peon(Color.RED, 47, 23, Freshness.STALE));
        bouquet.addFlower(new Rose(Color.GREEN, 23, 61, Freshness.STALE));
        bouquet.addFlower(new Rose(Color.WHITE, 26, 28));
        bouquet.addFlower(new Rose(Color.RED, 61, 46));
        flowerShop.addBouquet(bouquet);

        bouquet = new Bouquet();
        bouquet.addFlower(new Rose(Color.RED, 61, 33));
        bouquet.addFlower(new Peon(Color.GREEN, 31, 42));
        bouquet.addFlower(new Rose(Color.WHITE, 21, 44));
        flowerShop.addBouquet(bouquet);

        // it's possible to change the freshness of the flower if it's changed
        flowerShop.getBouquets().get(0).getFlowers().get(0).setFreshness(Freshness.STALE);
        flowerShop.getBouquets().get(1).getFlowers().get(1).setFreshness(Freshness.STALE);
        flowerShop.getBouquets().get(1).getFlowers().get(2).setFreshness(Freshness.STALE);

        // flowers have an interface "Smelling"
        for (Bouquet bouquet1 : flowerShop.getBouquets()
                ) {
            bouquet1.getFlowers().forEach(Smelling::smell);
        }

        // determine the cost of each bouquet
        for (Bouquet bouquet1 : flowerShop.getBouquets()
                ) {
            System.out.println(String.format("Bouquet cost: %d", BouquetUtil.getCost(bouquet1)));
        }

        // determine the longest flower in all bouquets
        Flower longestFlower = null;
        for (Bouquet bouquet1 : flowerShop.getBouquets()
                ) {
            for (Flower flower : bouquet1.getFlowers()
                    ) {
                if (longestFlower == null || flower.getLength() > longestFlower.getLength())
                    longestFlower = flower;
            }
        }
        if (longestFlower != null)
            System.out.println(String.format("Longest flower length: %d, flower itself: %s", longestFlower.getLength(), longestFlower));
        else System.out.println("There are not enough flowers to determine the one with maximum length");

        // determine the freshest bouquet
        Bouquet freshestBouquet = null;
        for (Bouquet bouquet1 : flowerShop.getBouquets()
                ) {
            if (freshestBouquet == null || BouquetUtil.getFreshness(bouquet1) > BouquetUtil.getFreshness(freshestBouquet))
                freshestBouquet = bouquet1;
        }
        if (freshestBouquet != null)
            System.out.println(String.format("Freshest bouquet %s", freshestBouquet));
        else System.out.println("There are not enough bouquets to determine the freshest one");


    }
}
