package Task7.Staff;

import Task7.ConsoleHelper;
import Task7.Order;
import Task7.Payment;
import Task7.Repository.IOrderRepo;
import Task7.Status;

import java.util.Arrays;

import static Task7.ConsoleHelper.writeMessage;
import static Task7.Restaurant.getOrderRepo;

public class Administrator extends Person{

    private IOrderRepo orderRepo = getOrderRepo();

    public Administrator(String name) {
        super(name);
    }

    public void acceptOrder(Order order)  {
        writeMessage("order accepted: "+order);
        order.setStatus(Status.ACCEPTED);
        orderRepo.save(order);
    }

    public void processPay(Order order)  {
        writeMessage("choose the payment type. input one of the values");
        writeMessage(Arrays.toString(Payment.values()));
        Payment payment = Payment.fromString(ConsoleHelper.readString());
        order.setPayment(payment);
        order.processPay();
        order.setStatus(Status.PAYED);
        orderRepo.save(order);
    }
}
