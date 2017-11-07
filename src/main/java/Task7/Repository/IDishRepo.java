package Task7.Repository;

import Task7.Dish;

import java.util.Map;

public interface IDishRepo {

    Dish save(Dish Dish) ;

    void delete(int id) ;

    Dish get(int id) ;

    Map<Integer, Dish> getAll() ;
}
