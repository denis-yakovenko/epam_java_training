package Task7.Repository;

import Task7.Dish;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JDBCDishRepoImpl implements IDishRepo {

    private static Connection connection;
    private static JDBCDishRepoImpl repo;

    private JDBCDishRepoImpl() {
    }

    public static IDishRepo getInstance(Connection connection) {
        if (repo == null) {
            JDBCDishRepoImpl.connection = connection;
            repo = new JDBCDishRepoImpl();
        }
        return repo;
    }

    @Override
    public Dish save(Dish dish) {
        String sql;
        PreparedStatement stmt;
        try {
            if (dish.getId() == null) {
                sql = "INSERT INTO dish (name, price) VALUES (?,?)";
                stmt = connection.prepareStatement(sql);
                stmt.setString(1, dish.getName());
                stmt.setDouble(2, dish.getPrice());
                stmt.executeUpdate();
                sql = "SELECT LAST_INSERT_ID()";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                dish.setId(rs.getInt(1));
            } else {
                sql = "UPDATE dish SET name = ?, price = ? where id = ?";
                stmt = connection.prepareStatement(sql);
                stmt.setString(1, dish.getName());
                stmt.setDouble(2, dish.getPrice());
                stmt.setInt(3, dish.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dish;
    }

    @Override
    public void delete(int id) {
        try {
            String insertTableSQL = "DELETE FROM dish WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertTableSQL);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Dish get(int id) {
        try {
            String insertTableSQL = "SELECT id, name, price FROM dish WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertTableSQL);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return new Dish(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<Integer, Dish> getAll() {
        Map<Integer, Dish> dishes = new HashMap<>();
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT id, name, price FROM dish ORDER BY name";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                dishes.put(rs.getInt("id"), new Dish(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dishes;
    }
}
