package Task7.Staff;

import Task7.*;

import java.util.Arrays;

import static Task7.ConsoleHelper.writeMessage;

public class Administrator extends Person{

    private Restaurant restaurant;

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Administrator(String name) {
        super(name);
    }

    public void acceptOrder(Order order)  {
        writeMessage("order accepted: "+order);
        order.setStatus(Status.ACCEPTED);
        restaurant.getOrderRepo().save(order);
    }

    public void processPay(Order order)  {
        writeMessage("choose the payment type. input one of the values");
        writeMessage(Arrays.toString(Payment.values()));
        Payment payment = Payment.fromString(ConsoleHelper.readString());
        order.setPayment(payment);
        order.processPay();
        order.setStatus(Status.PAYED);
        restaurant.getOrderRepo().save(order);
    }
}
