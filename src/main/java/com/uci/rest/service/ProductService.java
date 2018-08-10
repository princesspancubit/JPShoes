package com.uci.rest.service;

import com.uci.rest.db.DatabaseConnector;
import com.uci.rest.db.DatabaseUtils;
import com.uci.rest.model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private final static String ALL_PRODUCTS_QUERY = "SELECT * FROM products";
    
    public static Product getProductById(String id) {
        Connection connection = DatabaseConnector.getConnection();
        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_PRODUCTS_QUERY + " WHERE productNumber = '" + id +"'");

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    Product product = new Product();

                    product.setName(resultSet.getString("name"));
                    product.setPrice(resultSet.getDouble("price"));
                    product.setQuantity(resultSet.getInt("quantity"));
                    product.setProductNumber(resultSet.getString("productNumber"));
                    product.setDescription(resultSet.getString("description"));
                    product.setImage(resultSet.getString("image"));

                    return product;
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

    public static List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<Product>();

        Connection connection = DatabaseConnector.getConnection();
        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_PRODUCTS_QUERY);

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    Product product = new Product();

                    product.setName(resultSet.getString("name"));
                    product.setPrice(resultSet.getDouble("price"));
                    product.setQuantity(resultSet.getInt("quantity"));
                    product.setProductNumber(resultSet.getString("productNumber"));
                    product.setDescription(resultSet.getString("description"));
                    product.setImage(resultSet.getString("image"));

                    productList.add(product);

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

        return productList;
    }
}
