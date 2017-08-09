package task4;

public class Flower extends Plant {

    public Flower(String name, Color color, Integer height, Freshness freshness) {
        super(name, color, height, freshness);
    }

    @Override
    public void smell() {
        System.out.println("smell like "+getName());
    }

}
