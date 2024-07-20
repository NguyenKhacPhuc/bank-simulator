public class Transaction {
    private int transactionId;
    private int amountIdSender;
    private int transactionType;
    private double amountMoney;
    private String receiverAccountNumber;
    private String time;
    private double balanceAfterSend;
    private String message;

    public Transaction(int transactionId, int amountIdSender, int transactionType, double amountMoney, String receiverAccountNumber, String time, double balanceAfterSend, String message) {
        this.transactionId = transactionId;
        this.amountIdSender = amountIdSender;
        this.transactionType = transactionType;
        this.amountMoney = amountMoney;
        this.receiverAccountNumber = receiverAccountNumber;
        this.time = time;
        this.balanceAfterSend = balanceAfterSend;
        this.message = message;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAmountIdSender() {
        return amountIdSender;
    }

    public void setAmountIdSender(int amountIdSender) {
        this.amountIdSender = amountIdSender;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
}
