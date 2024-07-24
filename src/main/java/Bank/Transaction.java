package Bank;

import java.sql.*;

public class Transaction {
    private int transactionId;
    private int senderAccountId;
    private int receiverAccountId;
    private String transactionType;
    private double amountMoney;
    private String receiverAccountNumber;
    private String senderAccountNumber;
    private java.sql.Date time;
    private double balanceAfterSend;
    private String message;

    public Transaction(int transactionId, int senderAccountId, int receiverAccountId, String transactionType, double amountMoney, String receiverAccountNumber, String senderAccountNumber, java.sql.Date time, double balanceAfterSend, String message) {
        this.transactionId = transactionId;
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
        this.transactionType = transactionType;
        this.amountMoney = amountMoney;
        this.receiverAccountNumber = receiverAccountNumber;
        this.senderAccountNumber = senderAccountNumber;
        this.time = time;
        this.balanceAfterSend = balanceAfterSend;
        this.message = message;
    }

    public Transaction() {
    }

    public Transaction(int transactionId, int senderAccountId, int receiverAccountId, String transfers, int amountMoney, String number, String number1, int i, int balanceAfterSend, String done) {
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(int senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public int getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(int receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(double amountMoney) {
        this.amountMoney = amountMoney;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public java.sql.Date getTime() {
        return time;
    }

    public void setTime(java.sql.Date time) {
        this.time = time;
    }

    public double getBalanceAfterSend() {
        return balanceAfterSend;
    }

    public void setBalanceAfterSend(double balanceAfterSend) {
        this.balanceAfterSend = balanceAfterSend;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void delete(Connection conn, Transaction trans) throws SQLException {
        System.out.println("Inside delete");
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `bank`.`transaction` WHERE (`idTransaction` = '2');");
        int roww = statement.executeUpdate();

        if (roww < 0) {
            System.out.println("Delete unsuccessfull");
        }
    }
}