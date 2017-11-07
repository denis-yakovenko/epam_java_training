package task5.Flower;

public class BasketDecorator extends ItemDecorator {

    public BasketDecorator(Item item) {
        super(item);
        System.out.println("Decorating with basket");
    }

    @Override
    public String getDescription() {
        return "Basket(" + item.getDescription() + ")";
    }

    @Override
    public double price() {
        return 4 + item.price();
    }

}
