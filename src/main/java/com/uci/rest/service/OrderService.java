package com.uci.rest.service;

import com.uci.rest.db.DatabaseConnector;
import com.uci.rest.db.DatabaseUtils;
import com.uci.rest.model.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private final static String ALL_PRODUCTS_QUERY = "SELECT * FROM assign4orders";

    public static Order getOrderById(String id) {
        Connection connection = DatabaseConnector.getConnection();
        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_PRODUCTS_QUERY + " WHERE orderid = '" + id +"'");

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    Order order = new Order();

                    order.setOrderId(id);
                    order.setCustFirstName(resultSet.getString("customerFirstName"));
                    order.setCustLastName(resultSet.getString("customerLastName"));
                    order.setPhoneNumber(resultSet.getString("phoneNumber"));
                    order.setEmail(resultSet.getString("email"));
                    order.setShipAdd(resultSet.getString("shipAdd"));
                    order.setShipMeth(resultSet.getString("shipMeth"));
                    order.setCardNum(resultSet.getString("cardNum"));
                    order.setCardName(resultSet.getString("cardName"));
                    order.setMonth(resultSet.getInt("month"));
                    order.setYear(resultSet.getInt("year"));
                    order.setTotalQty(resultSet.getInt("totalQty"));
                    order.setTotalPrice(resultSet.getInt("totalPrice"));

                    return order;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
    
    public static boolean AddTodo(Order order) {
        String sql = "INSERT INTO assign4orders (orderid, customerFirstName, customerLastName, phoneNumber, email, shipAdd, shipMeth, cardNum, cardName, month, year)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConnector.getConnection();
        return DatabaseUtils.performDBUpdate(connection, sql, order.getOrderId(), order.getCustFirstName(), order.getCustLastName(), order.getPhoneNumber(), order.getEmail(), order.getShipAdd(), order.getShipMeth(), order.getCardNum(), order.getCardName(), Integer.toString(order.getMonth()), Integer.toString(order.getYear()));
    }

    public static boolean updateOrder(Order order) {

        String sql = "UPDATE assign4orders SET customerFirstName=?, customerLastName=?, phoneNumber=?, email=?, shipAdd=?, shipMeth=?, cardNum=?, cardName=?, month=?, year=? WHERE orderid=?";

        Connection connection = DatabaseConnector.getConnection();

        boolean updateStatus = DatabaseUtils.performDBUpdate(connection, sql, order.getCustFirstName(), order.getCustLastName(), order.getPhoneNumber(), order.getEmail(), order.getShipAdd(), order.getShipMeth(), order.getCardNum(), order.getCardName(), Integer.toString(order.getMonth()), Integer.toString(order.getYear()), order.getOrderId());

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateStatus;

    }


    public static boolean deleteOrder(Order retrievedOrder) {

        String sql = "DELETE FROM assign4orders WHERE orderid=?";

        Connection connection = DatabaseConnector.getConnection();

        boolean updateStatus = DatabaseUtils.performDBUpdate(connection, sql, String.valueOf(retrievedOrder.getOrderId()));

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateStatus;
    }
}
