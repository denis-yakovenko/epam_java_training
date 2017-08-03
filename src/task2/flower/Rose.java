package task2.flower;

public class Rose extends Flower {
    public Rose(Color color, Integer length, Integer price, Freshness freshness) {
        super(color, length, price, freshness);
    }

    public Rose(Color color, Integer length, Integer price) {
        super(color, length, price);
    }

    @Override
    public void smell() {
        System.out.println("smell like rose");
    }
}
