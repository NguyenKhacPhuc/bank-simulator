


import java.sql.*;

public class exer {

    //Create
    //Create new record of table in database

    //Select ( Read )
    // Read all data or filtered data
    // Read record where name =

    //Update
    //Update owner name of record id = 3

    //delete
    public static void main(String[] args){
        try{
            String DB_URL = "jdbc:mysql://localhost:3306/schema1";
            String PASSWORD = "07072003";
            String USER_NAME = "root";
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            updateAccount(conn, new Account(1,"Hello",10000,"acc1234",10000,"nopass",2));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(dbURL, userName, password);
            System.out.println("Connected successfully!");
        } catch (Exception ex) {
            System.out.println("Connection failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    public static void updateAccount(Connection conn, Account account) throws SQLException {
        PreparedStatement statement = ((java.sql.Connection) conn).prepareStatement("UPDATE account" +
                " SET idAccount = " + account.accountID + ",userName =?" + ",balance =?" + ",accNumber =?" + ",limitDayWithdrawal =?" + ",password =?" + ",idBank =?"+
                " WHERE idAccount=" + account.accountID + ";");
        statement.setString(1, account.getUserName());
        statement.setFloat(2, account.getBalance());
        statement.setString(3, account.getAccNumber());
        statement.setFloat(4, account.getLimit());
        statement.setString(5, account.getPassWord());
        statement.setInt(6, account.getIdBank());
        statement.executeUpdate();
    }
    public static void updateCustomer(Connection conn, Customer customer) throws SQLException {
        PreparedStatement statement = ((java.sql.Connection) conn).prepareStatement("UPDATE account" +
                " SET idCustomer = " + customer.idCustomer + ",name =?" + ",age =?" + ",address =?" + ",idAccount =?"+
                " WHERE idCustomer=" + customer.idCustomer + ";");
        // statement.setInt(1, customer.getIdCustomer());
        statement.setString(1, customer.getName());
        statement.setInt(2, customer.getAge());
        statement.setString(3, customer.getAddress());
        statement.setInt(4, customer.getIdAccount());
        statement.executeUpdate();
    }
    public static void updateTransaction(Connection conn, Transaction trans) throws SQLException {
        PreparedStatement statement = ((java.sql.Connection) conn).prepareStatement("UPDATE account" +
                " SET idTransaction = " + trans.transactionId + ",senderAccountNumber =?" + ",receiverAccountNumber =?" + ",time =?" + ",amountMoney =?"+ ",balanceAfterSend =?"+ ",message =?"+ ",transactionType =?"+ ",senderAccountId =?"+ ",receiverAccountId =?"+
                " WHERE idTransaction=" + trans.transactionId + ";");
        // statement.setInt(1, customer.getIdCustomer());
         statement.setString(1, trans.getSenderAccountNumber());
         statement.setString(2, trans.getTime());
         statement.setDouble(3, trans.getAmountMoney());
         statement.setDouble(4,trans.getBalanceAfterSend());
         statement.setString(5, trans.getMessage());
         statement.setInt(6, trans.getTransactionType());
         statement.setInt(7, trans.getReceiverAccountId());
         statement.setInt(8, trans.getSenderAccountId());
         statement.setInt(9, trans.getReceiverAccountId());
        statement.executeUpdate();
    }
}
