package controller;

import data.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//update fields
//get
public class TransactionManagement {

    public void deleteTransaction(Connection conn, Transaction trans) throws SQLException {
        System.out.println("Inside delete");
        System.out.println("Enter id transaction you want to delete: ");
        trans.setTransactionId(new Scanner(System.in).nextInt());
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `schema1`.`transaction` WHERE (`idTransaction` = '" + trans.getTransactionId() + "');");
        int roww = statement.executeUpdate();

        if (roww < 0) {
            System.out.println("Delete unsuccessfull");
        }
    }
    public List<Transaction> getAllTransaction(Connection conn) throws SQLException {
        return null;
    }

}
