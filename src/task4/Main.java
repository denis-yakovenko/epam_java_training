package task4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Bouquet> bouquets = new ArrayList<>();

    public static void main(String[] args) {
        Main flowerShop = new Main();

        // creating the bouquet
        Bouquet bouquet = new Bouquet();
        bouquet.addPlant(new Flower("Rose", Color.WHITE, 20, Freshness.FRESH, 19));
        bouquet.addPlant(new Flower("Rose", Color.GREEN, 40, Freshness.FRESH, 4));
        bouquet.addPlant(new Flower("Rose", Color.WHITE, 30, Freshness.STALE, 6));
        bouquet.addPlant(new Flower("Peon", Color.RED, 10, Freshness.FRESH, 7));
        bouquet.addPlant(new Flower("Peon", Color.GREEN, 10, Freshness.FRESH, 9));
        bouquet.addPlant(new Cactus("Opuntia", Color.GREEN, 50, 2.3, 23)); // index 6
        bouquet.addPlant(new Cactus("Aloe", Color.GREEN, 60, 1.4, 45));
        bouquet.addPlant(new Cactus("Aloe", Color.GREEN, 60, 3.8, 12));
        bouquet.addPlant(new Cactus("Astrophytum", Color.GREEN, 70, 4.2, 7));
        flowerShop.bouquets.add(bouquet);

        Integer founded;

        // trying to find certain Cactus in the bouquet
        if ((founded = bouquet.findPlant(new Cactus("Aloe", Color.GREEN, 60, 1.4, 45))) != null)
            System.out.println("founded, index: " + founded);
        else
            System.out.println("not found");

        // trying to find certain Flower that does not exists in the bouquet
        if ((founded = bouquet.findPlant(new Flower("Rose", Color.RED, 333, Freshness.STALE, 66))) != null)
            System.out.println("founded, index: " + founded);
        else
            System.out.println("not found");

        // creating one more bouquet
        bouquet = new Bouquet();
        bouquet.addPlant(new Flower("Rose", Color.WHITE, 88, Freshness.FRESH, 23));
        bouquet.addPlant(new Flower("Peon", Color.RED, 66, Freshness.FRESH,56));
        bouquet.addPlant(new Cactus("Aloe", Color.GREEN, 63, 7.4, 12));
        flowerShop.bouquets.add(bouquet);

        // determine the cost of each bouquet
        for (Bouquet bouquet1 : flowerShop.bouquets
                ) {
            System.out.println(String.format("Bouquet cost: %d", bouquet1.getCost()));
        }

        // determine the longest flower in all bouquets
        Plant highestPlant = null;
        for (Bouquet bouquet1 : flowerShop.bouquets
                ) {
            for (Plant plant : bouquet1.getPlants()
                    ) {
                if (highestPlant == null || plant.getHeight() > highestPlant.getHeight())
                    highestPlant = plant;
            }
        }
        if (highestPlant != null)
            System.out.println(String.format("Longest flower length: %d, flower itself: %s", highestPlant.getHeight(), highestPlant));
        else System.out.println("There are not enough flowers to determine the one with maximum length");

        // determine the freshest bouquet
        Bouquet freshestBouquet = null;
        for (Bouquet bouquet1 : flowerShop.bouquets
                ) {
            if (freshestBouquet == null || bouquet1.getFreshness() > freshestBouquet.getFreshness())
                freshestBouquet = bouquet1;
        }
        if (freshestBouquet != null)
            System.out.println(String.format("Freshest bouquet %s", freshestBouquet));
        else System.out.println("There are not enough bouquets to determine the freshest one");

        // plants can smell
        for (Bouquet bouquet1 : flowerShop.bouquets
                ) {
            bouquet1.getPlants().forEach(CanSmell::smell);
        }

        /*// trying to find certain Flower in the shop
        if ((founded = flowerShop.findPlant(new Flower("Peon", Color.RED, 66, Freshness.FRESH, 12))) != null)
            System.out.println("Flower founded, bouquet index: " + founded);
        else
            System.out.println("Flower not found in the shop");

        // trying to find certain Flower that does not exists in the shop
        if ((founded = flowerShop.findPlant(new Flower("Rose", Color.WHITE, 66, Freshness.STALE, 67))) != null)
            System.out.println("Flower founded, bouquet index: " + founded);
        else
            System.out.println("Flower not found in the shop");*/
    }

    /*Integer findPlant(Plant plant) {
        Integer founded;
        for (Bouquet bouquet : bouquets) {
            if ((founded = bouquet.findPlant(plant)) != null)
                return founded;
        }
        return null;
    }*/
}
