package Task7.Repository;

import Task7.Order;

import java.util.Map;

public interface IOrderRepo {

    Order save(Order order) ;

    void delete(int id) ;

    Order get(int id) ;

    Map<Integer, Order> getAll();
}
