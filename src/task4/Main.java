package task4;

import task4.flower.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Bouquet> bouquets = new ArrayList<>();

    public static void main(String[] args) {
        Main flowerShop = new Main();

        Bouquet bouquet = new Bouquet();
        //bouquet.addFlower(new Flower(Kind.ROSE, Color.WHITE, 29, 55));
        flowerShop.bouquets.add(bouquet);

        // aaaaaaaaaaaaaa flowers have an interface "Smelling"
        for (Bouquet bouquet1 : flowerShop.bouquets
                ) {
            //bouquet1.getFlowers().forEach(Smellable::smell);
        }
    }
}
