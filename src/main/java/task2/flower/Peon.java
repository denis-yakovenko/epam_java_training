package task2.flower;

public class Peon extends Flower {
    public Peon(Color color, Integer length, Integer price, Freshness freshness) {
        super(color, length, price, freshness);
    }

    public Peon(Color color, Integer length, Integer price) {
        super(color, length, price);
    }

    @Override
    public void smell() {
        System.out.println("smell like peon");
    }
}
