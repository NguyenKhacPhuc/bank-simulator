package controller;

import data.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerManagement {
    public void deleteCustomer(Connection conn, Customer customer) throws SQLException {
        System.out.println("Inside delete");
        System.out.println("Enter id customer you want to delete: ");
        customer.setCustomerID(new Scanner(System.in).nextInt());
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `schema1`.`customer` WHERE (`idCustomer` = '" + customer.getCustomerID() + "');");
        int roww = statement.executeUpdate();
        if (roww < 0) {
            System.out.println("Delete unsuccessfull");
        }
    }
}
