package task5.Delivery;

import task5.Flower.Item;

import java.util.List;

public class PostDeliveryStrategy implements IDelivery {
    @Override
    public void deliver(List<Item> items) {
        System.out.println("Delivering by Post:");
        for (Item item : items
                ) {
            System.out.println(item.getDescription());
        }
    }
}
