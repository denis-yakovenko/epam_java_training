package Task7;

import Task7.Repository.*;
import Task7.Staff.Administrator;
import Task7.Staff.Cook;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import static Task7.ConsoleHelper.askOperation;
import static Task7.ConsoleHelper.writeMessage;
import static Task7.Operation.EXIT;

public class Restaurant {

    private IDishRepo dishRepo = getDishRepo();
    private IOrderRepo orderRepo = getOrderRepo();
    private Map<Integer, Dish> menu;
    private Administrator administrator = new Administrator("John Doe");
    private Cook cook = new Cook("Gordon Freeman");

    public static Connection getConnection() {
        return MySQLConnectionImpl.getConnection();
    }

    public static void closeConnection() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static IDishRepo getDishRepo() {
        return JDBCDishRepoImpl.getInstance(getConnection());
    }

    public static IOrderRepo getOrderRepo() {
        return JDBCOrderRepoImpl.getInstance(getConnection());
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        restaurant.run();
    }

    private void run() {
        openDB();
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
        closeDB();
    }

    private void openDB() {
        createTestMenuIfNotExists();
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

    private void createTestMenuIfNotExists() {
        if (dishRepo.getAll().size() == 0) {
            dishRepo.save(new Dish("Steak", 1.2));
            dishRepo.save(new Dish("Soup", 4.5));
            dishRepo.save(new Dish("Hamburger", 2.6));
            dishRepo.save(new Dish("Coffee", 9.4));
            dishRepo.save(new Dish("Tea", 0.5));
            Dish dish = dishRepo.save(new Dish("Test", 0.5));
            dishRepo.delete(dish.getId());
        }
    }

    private void closeDB() {
        closeConnection();
    }
}