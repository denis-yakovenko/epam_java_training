package Task7;

import Task7.Repository.IDishRepo;
import Task7.Repository.IOrderRepo;
import Task7.Staff.Administrator;
import Task7.Staff.Cook;

import java.util.Map;

import static Task7.ConsoleHelper.askOperation;
import static Task7.ConsoleHelper.writeMessage;
import static Task7.Operation.EXIT;

public class Restaurant {

    private IDishRepo dishRepo;
    private IOrderRepo orderRepo;
    private Map<Integer, Dish> menu;
    private Administrator administrator;
    private Cook cook;

    public void setDishRepo(IDishRepo dishRepo) {
        this.dishRepo = dishRepo;
    }

    public void setOrderRepo(IOrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public IDishRepo getDishRepo() {
        return dishRepo;
    }

    public IOrderRepo getOrderRepo() {
        return orderRepo;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    public void run() {
        Operation operation;
        do {
            operation = askOperation();
            switch (operation) {
                case MENU:
                    showMenu();
                    break;
                case INPUT_ORDER:
                    processOrder();
                    break;
                case SHOW_ORDERS:
                    showOrders();
                    break;
                case EXIT:
                    break;
            }
        } while (operation != EXIT);
    }

    private void processOrder() {
        Order order = inputOrderFromClient();
        administrator.acceptOrder(order);
        cook.cookOrder(order);
        administrator.processPay(order);
    }

    private Order inputOrderFromClient() {
        writeMessage("choose the dishes from the menu");
        writeMessage("add dishes to an order using its id's like 1,2,3,4... then press enter");
        Order order = new Order();
        String dishList = ConsoleHelper.readString();
        for (String dish : dishList.split(",")
                ) {
            order.addItem(dishRepo.get(Integer.parseInt(dish)));
        }
        orderRepo.save(order);
        return order;
    }

    private void showMenu() {
        if (menu == null)
            menu = dishRepo.getAll();
        for (Map.Entry<Integer, Dish> dish : menu.entrySet()
                ) {
            writeMessage(dish.getValue().toString());
        }
    }

    private void showOrders() {
        for (Map.Entry<Integer, Order> order : orderRepo.getAll().entrySet()
                ) {
            writeMessage(order.getValue().toString());
        }
    }
}