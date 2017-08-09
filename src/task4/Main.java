package task4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Bouquet> bouquets = new ArrayList<>();

    public static void main(String[] args) {
        Main flowerShop = new Main();

        // creating the bouquet
        Bouquet bouquet = new Bouquet();
        bouquet.addPlant(new Flower("Rose", Color.WHITE, 20, Freshness.FRESH));
        bouquet.addPlant(new Flower("Rose", Color.GREEN, 40, Freshness.FRESH));
        bouquet.addPlant(new Flower("Rose", Color.WHITE, 30, Freshness.STALE));
        bouquet.addPlant(new Flower("Peon", Color.RED, 10, Freshness.FRESH));
        bouquet.addPlant(new Flower("Peon", Color.GREEN, 10, Freshness.FRESH));
        bouquet.addPlant(new Cactus("Opuntia", Color.GREEN, 50, 2.3)); // index 6
        bouquet.addPlant(new Cactus("Aloe", Color.GREEN, 60, 1.4));
        bouquet.addPlant(new Cactus("Aloe", Color.GREEN, 60, 3.8));
        bouquet.addPlant(new Cactus("Astrophytum", Color.GREEN, 70, 4.2));
        flowerShop.bouquets.add(bouquet);

        Integer founded;

        // trying to find certain Cactus in the bouquet
        if ((founded = bouquet.findPlant(new Cactus("Aloe", Color.GREEN, 60, 1.4))) != null)
            System.out.println("Cactus founded, flower index: " + founded);
        else
            System.out.println("Cactus not found in the bouquet");

        // trying to find certain Flower that does not exists in the bouquet
        if ((founded = bouquet.findPlant(new Flower("Rose", Color.RED, 333, Freshness.STALE))) != null)
            System.out.println("Flower founded, flower index: " + founded);
        else
            System.out.println("Flower not found in the bouquet");

        // creating one more bouquet
        bouquet = new Bouquet();
        bouquet.addPlant(new Flower("Rose", Color.WHITE, 88, Freshness.FRESH));
        bouquet.addPlant(new Flower("Peon", Color.RED, 66, Freshness.FRESH));
        bouquet.addPlant(new Cactus("Aloe", Color.GREEN, 63, 7.4));
        flowerShop.bouquets.add(bouquet);

        // trying to find certain Flower in the shop
        if ((founded = flowerShop.findPlant(new Flower("Peon", Color.RED, 66, Freshness.FRESH))) != null)
            System.out.println("Flower founded, bouquet index: " + founded);
        else
            System.out.println("Flower not found in the shop");

        // trying to find certain Flower that does not exists in the shop
        if ((founded = flowerShop.findPlant(new Flower("Rose", Color.WHITE, 66, Freshness.STALE))) != null)
            System.out.println("Flower founded, bouquet index: " + founded);
        else
            System.out.println("Flower not found in the shop");

        // plants can smell
        for (Bouquet bouquet1 : flowerShop.bouquets
                ) {
            bouquet1.getPlants().forEach(CanSmell::smell);
        }
    }

    Integer findPlant(Plant plant) {
        Integer founded;
        for (Bouquet bouquet : bouquets) {
            if ((founded = bouquet.findPlant(plant)) != null)
                return founded;
        }
        return null;
    }
}
