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
        Administrator administrator = new Administrator("John Doe");
        administrator.setRestaurant(restaurant);
        restaurant.setAdministrator(administrator);
        Cook cook = new Cook("Gordon Freeman");
        cook.setRestaurant(restaurant);
        restaurant.setCook(cook);
        restaurant.run();
    }
}
