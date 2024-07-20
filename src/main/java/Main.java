import java.sql.*;

public class Main {
    public static void main(String[] args) {
        final String DB_URL = "jdbc:mysql://localhost:3306/bank";
        final String PASSWORD = "";
        final String USER_NAME = "root";

        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement statement = conn.createStatement();
        }catch (SQLException e){
            System.out.println("Have SQLException");
        }



    }

    public static Connection getConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    public static void delete(){

    }

}
