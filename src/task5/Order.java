package task5;

import task5.Delivery.IDelivery;
import task5.Flower.Item;
import task5.Payment.IPayment;

import java.util.LinkedList;
import java.util.List;

public class Order {
    private List<Item> items = new LinkedList<>();
    private IPayment payment;
    private IDelivery delivery;

    public void setPaymentStrategy(IPayment payment) {
        this.payment = payment;
    }

    public void setDeliveryStrategy(IDelivery delivery) {
        this.delivery = delivery;
    }

    double calculateTotalPrice() {
        double totalPrice = 0;
        for (Item item : items
                ) {
            totalPrice += item.price();
        }
        return totalPrice;
    }

    public void processOrder() {
        payment.pay(calculateTotalPrice());
        delivery.deliver(items);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
