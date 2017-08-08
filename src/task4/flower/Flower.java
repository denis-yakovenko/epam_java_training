package task4.flower;

public class Flower extends Plant {
    private Kind kind;
    private Color color;
    private Freshness freshness;
    private Integer length;
    private Integer price;

    @Override
    public void Smell() {
        System.out.println("smell like "+kind);
    }


    /*@Override
    public void smell() {
        System.out.println("smell like "+this.kind);
    }*/
}
