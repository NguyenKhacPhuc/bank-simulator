package controller;

import data.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//update fields of customer
// Chau
public class CustomerManagement {
    public void deleteCustomer(Connection conn, Customer customer) throws SQLException {
        System.out.println("Inside delete");
        System.out.println("Enter id customer you want to delete: ");
        customer.setCustomerID(new Scanner(System.in).nextInt());
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `schema1`.`customer` WHERE (`idCustomer` = '" + customer.getCustomerID() + "');");
        int roww = statement.executeUpdate();
        if (roww < 0) {
            System.out.println("Delete unsuccessfully");
        }
    }

    public List<Customer> getAllCustomer(Connection conn) throws SQLException {
        //get all customer in db
        List<Customer> customers = new ArrayList<>();
        PreparedStatement statement = conn.prepareStatement("Select * from customer");
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            Customer customer = new Customer(rs.getInt("idCustomer"), rs.getString("name"), rs.getInt("age"), rs.getString("address"), rs.getInt("idAccount"));
            customers.add(customer);
        }
        return customers;
    }

    public static void createCustomer(Connection conn, Customer customer) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("INSERT INTO `customer` (`idCustomer`, `name`, `age`, `address`, `idAccount`) VALUES(?, ?, ?, ?, ?)");
        statement.setInt(1, customer.getCustomerID());
        statement.setString(2, customer.getName());
        statement.setInt(3, customer.getAge());
        statement.setString(4, customer.getAddress());
        statement.setInt(5, customer.getAccountsID());
        statement.executeUpdate();
    }
}
