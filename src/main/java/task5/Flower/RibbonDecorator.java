package task5.Flower;

public class RibbonDecorator extends ItemDecorator {
    public RibbonDecorator(Item item) {
        super(item);
        System.out.println("Decorating with ribbon");
    }

    @Override
    public String getDescription() {
        return "Ribbon(" + item.getDescription() + ")";
    }

    @Override
    public double price() {
        return 40 + item.price();
    }
}
