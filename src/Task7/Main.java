package Task7;

import Task7.Repository.JDBCDishRepoImpl;
import Task7.Repository.JDBCOrderRepoImpl;
import Task7.Repository.MySQLConnectionImpl;
import Task7.Staff.Administrator;
import Task7.Staff.Cook;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Connection connection = MySQLConnectionImpl.getConnection();
        restaurant.setDishRepo(JDBCDishRepoImpl.getInstance(connection));
        restaurant.setOrderRepo(JDBCOrderRepoImpl.getInstance(connection));
        restaurant.setAdministrator(new Administrator("John Doe"));
        restaurant.setCook(new Cook("Gordon Freeman"));
        restaurant.run();
    }
}
