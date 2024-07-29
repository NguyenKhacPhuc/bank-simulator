import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class Connect {
    public static void main(String[] args) throws SQLException {
        String DB_URL = "jdbc:mysql://localhost:3306/my_db";
        String PASSWORD = "123456";
        String USER_NAME = "root";
        String selectCustomer = "SELECT * FROM customer where idCustomer = 1";
        String selectAccount = "SELECT * FROM account where idAccount = 2";
        String selectTransaction = "SELECT * FROM transaction where idTransaction = 1";
        String selectBank = "SELECT * FROM bank where bankName ='TPbank'";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL,
                    USER_NAME, PASSWORD);
            PreparedStatement cus = conn.prepareStatement(selectCustomer);
            ResultSet result = cus.executeQuery();
            while (result.next()) {
                System.out.println(result.getInt(1)+" "+result.getString(2) + " " + result.getInt(3));
            }
            PreparedStatement acc = conn.prepareStatement(selectAccount);
            ResultSet rs = acc.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2) + " " + rs.getFloat(3)+ " " + rs.getString(4));
            }
            PreparedStatement trans = conn.prepareStatement(selectTransaction);
            ResultSet resul = trans.executeQuery();
            while (resul.next()) {
                System.out.println(resul.getInt(1)+" "+resul.getString(2) + " " + resul.getString(3));
            }
            PreparedStatement bank = conn.prepareStatement(selectBank);
            ResultSet resu = bank.executeQuery();
            while (resu.next()) {
                System.out.println(resu.getInt(1)+" "+resu.getString(2) + " " + resu.getFloat(3));
            }
            bank.close();
            trans.close();
            acc.close();
            cus.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

