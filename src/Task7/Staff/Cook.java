package Task7.Staff;

import Task7.Order;
import Task7.Restaurant;
import Task7.Status;

import static Task7.ConsoleHelper.writeMessage;

public class Cook extends Person{

    private Restaurant restaurant;

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Cook(String name) {
        super(name);
    }

    public void cookOrder(Order order)  {
        writeMessage("order cooked: "+order);
        order.setStatus(Status.COOKED);
        restaurant.getOrderRepo().save(order);
    }
}
