package Task7.Staff;

import Task7.Order;
import Task7.Repository.IOrderRepo;
import Task7.Status;

import java.sql.SQLException;

import static Task7.ConsoleHelper.writeMessage;
import static Task7.Restaurant.getOrderRepo;

public class Cook extends Person{

    private IOrderRepo orderRepo = getOrderRepo();

    public Cook(String name) {
        super(name);
    }

    public void cookOrder(Order order)  {
        writeMessage("order cooked: "+order);
        order.setStatus(Status.COOKED);
        orderRepo.save(order);
    }
}
