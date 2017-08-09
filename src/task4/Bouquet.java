package task4;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {

    private List<Plant> plants = new ArrayList<>();

    public List<Plant> getPlants() {
        return plants;
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public Integer findPlant(Plant plant) {
        for (int i = 0; i < plants.size(); i++) {
            if (plants.get(i).equals(plant)) {
                return i; // returning the index of the plant in the bouquet
            }
        }
        return null;
    }
}
