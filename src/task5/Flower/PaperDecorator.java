package task5.Flower;

public class PaperDecorator extends ItemDecorator {
    public PaperDecorator(Item item) {
        super(item);
        System.out.println("Decorating with paper");
    }

    @Override
    public String getDescription() {
        return "Paper(" + item.getDescription() + ")";
    }

    @Override
    public double price() {
        return 13 + item.price();
    }
}
