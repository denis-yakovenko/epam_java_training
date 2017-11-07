package task4;

public class Flower extends Plant {

    public Flower(String name, Color color, Integer height, Freshness freshness, Integer price) {
        super(name, color, height, freshness, price);
    }

    @Override
    public void smell() {
        System.out.println("smell like "+getName());
    }
    @Override
    public String toString() {
        return "Flower{" +
                super.toString()+
                '}';
    }
}
