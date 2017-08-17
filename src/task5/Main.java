package task5;

import task5.Delivery.DHLDeliveryStrategy;
import task5.Delivery.PostDeliveryStrategy;
import task5.Flower.*;
import task5.Payment.CreditCardPaymentStrategy;
import task5.Payment.PayPalPaymentStrategy;

public class Main {
    public static void main(String[] args) {
        Item item = new FlowerBucket();
        Flower cactus = new CactusFlower(true, 45, 30, FlowerColor.GREEN);
        ((FlowerBucket) item).addFlowers(cactus);
        cactus = new CactusFlower(true, 23, 51, FlowerColor.GREEN);
        Flower romashka = new RomashkaFlower(false, 10, 78, FlowerColor.WHITE);
        ((FlowerBucket) item).addFlowers(cactus, romashka);

        System.out.println("Romashka is in the bucket: " + ((FlowerBucket) item).searchFlower(romashka));
        romashka = new RomashkaFlower(false, 10, 78, FlowerColor.WHITE);
        System.out.println("Another romashka is in the bucket: " + ((FlowerBucket) item).searchFlower(romashka));

        System.out.println(item.getDescription());
        System.out.println(item.price());

        item = new PaperDecorator(item);
        System.out.println(item.getDescription());
        System.out.println(item.price());

        item = new RibbonDecorator(item);
        System.out.println(item.getDescription());
        System.out.println(item.price());

        item = new BasketDecorator(item);
        System.out.println(item.getDescription());
        System.out.println(item.price());

        Order order = new Order();
        order.addItem(item);
        order.setPaymentStrategy(new PayPalPaymentStrategy());
        order.setDeliveryStrategy(new DHLDeliveryStrategy());
        order.processOrder();

        order = new Order();
        order.addItem(item);
        order.addItem(item);
        order.setPaymentStrategy(new CreditCardPaymentStrategy());
        order.setDeliveryStrategy(new PostDeliveryStrategy());
        order.processOrder();

    }
}
