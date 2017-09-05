package Task7.Repository;

import Task7.Dish;
import Task7.Order;
import Task7.Payment;
import Task7.Status;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JDBCOrderRepoImpl implements IOrderRepo {

    private static Connection connection;
    private static JDBCOrderRepoImpl repo;

    private JDBCOrderRepoImpl() {
    }

    public static IOrderRepo getInstance(Connection connection) {
        if (repo == null) {
            JDBCOrderRepoImpl.connection = connection;
            repo = new JDBCOrderRepoImpl();
        }
        return repo;
    }

    @Override
    public Order save(Order order) {
        String sql;
        PreparedStatement stmt;
        try {
            if (order.getId() == null) {
                sql = "INSERT INTO `order` (payment, status) VALUES (?,?)";
                stmt = connection.prepareStatement(sql);
                stmt.setString(1, String.valueOf(order.getPayment()));
                stmt.setString(2, String.valueOf(order.getStatus()));
                stmt.executeUpdate();
                sql = "SELECT LAST_INSERT_ID()";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                order.setId(rs.getInt(1));
            } else {
                sql = "UPDATE `order` SET payment = ?, status = ? where id = ?";
                stmt = connection.prepareStatement(sql);
                stmt.setString(1, String.valueOf(order.getPayment()));
                stmt.setString(2, String.valueOf(order.getStatus()));
                stmt.setInt(3, order.getId());
                stmt.executeUpdate();
                sql = "DELETE FROM order_dishes WHERE order_id = ?";
                stmt = connection.prepareStatement(sql);
                stmt.setInt(1, order.getId());
                stmt.executeUpdate();
            }
            sql = "INSERT INTO order_dishes (order_id, dish_id) VALUES (?,?)";
            stmt = connection.prepareStatement(sql);
            for (Dish dish : order.getDishes()
                    ) {
                stmt.setInt(1, order.getId());
                stmt.setInt(2, dish.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM `order` WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order get(int id) {
        try {
            String sql = "SELECT id, payment, status FROM `order` WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setPayment(Payment.fromString(rs.getString("payment")));
            order.setStatus(Status.valueOf(rs.getString("status")));
            sql = "select d.id,d.name,d.price from order_dishes od join dish d on od.dish_id=d.id where od.order_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, order.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                order.addItem(new Dish(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<Integer, Order> getAll() {
        Map<Integer, Order> orders = new HashMap<>();
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT id, payment, status FROM `order` ORDER BY id";
            ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement pStmt;
            sql = "select d.id,d.name,d.price from order_dishes od join dish d on od.dish_id=d.id where od.order_id = ?";
            pStmt = connection.prepareStatement(sql);
            ResultSet rsDetail;
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setPayment(Payment.fromString(rs.getString("payment")));
                order.setStatus(Status.valueOf(rs.getString("status")));
                pStmt.setInt(1, order.getId());
                rsDetail = pStmt.executeQuery();
                while (rsDetail.next()) {
                    order.addItem(new Dish(rsDetail.getInt("id"), rsDetail.getString("name"), rsDetail.getDouble("price")));
                }
                orders.put(order.getId(), order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
