package Task7;

import java.util.LinkedList;
import java.util.List;

import static Task7.ConsoleHelper.writeMessage;

public class Order {
    private Integer id;
    private List<Dish> dishes = new LinkedList<>();
    private Payment payment;
    private Status status;

    public Order() {
        this.status = Status.CREATED;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void addItem(Dish dish){
        dishes.add(dish);
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Dish dish : dishes
                ) {
            totalPrice += dish.getPrice();
        }
        return totalPrice;
    }

    public void processPay() {
        writeMessage("order "+getId()+" payed by "+getPayment()+", total sum is "+calculateTotalPrice());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dishes=" + dishes +
                ", payment=" + payment +
                ", status=" + status +
                '}';
    }
}
