package controller;

import data.Account;
import data.Customer;
import data.Transaction;

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
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `bank`.`customer` WHERE (`idCustomer` = '" + customer.getCustomerID() + "');");
        int roww = statement.executeUpdate();
        if (roww < 0) {
            System.out.println("Delete unsuccessfully");
        }
    }

    public List<Customer> getAllCustomer(Connection conn) throws SQLException {
        //get all transaction in db
        List<Customer> customers = new ArrayList<>();
        PreparedStatement statement = conn.prepareStatement("Select * from customer");
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            Customer customer = new Customer(rs.getInt("idCustomer"), rs.getString("name"), rs.getString("address"), rs.getString("idAccount"));
            customers.add(customer);
        }
        return customers;
    }
}
