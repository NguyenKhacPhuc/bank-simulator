// package Bank;

// import java.sql.*;

// public class exer {

//     //Create
//     //Create new record of table in database

//     //Select ( Read )
//     // Read all data or filtered data
//     // Read record where name =

//     //Update
//     //Update owner name of record id = 3

//     //delete
//     public static void main(String[] args){
//         try{
//             String DB_URL = "jdbc:mysql://localhost:3306/schema1";
//             String PASSWORD = "phuc1213";
//             String USER_NAME = "root";
//             Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
//             // updateCatData(conn, new Cat(3, "Nam", "Duowng", "2023"));
//         }
//         catch(Exception e)
//         {
//             e.printStackTrace();
//         }
//     }

//     public static Connection getConnection(String dbURL, String userName, String password) {
//         Connection conn = null;
//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             conn = (Connection) DriverManager.getConnection(dbURL, userName, password);
//             System.out.println("Connected successfully!");
//         } catch (Exception ex) {
//             System.out.println("Connection failure!");
//             ex.printStackTrace();
//         }
//         return conn;
//     }

//     public static void updateCatData(Connection conn, Cat cat) throws SQLException {
//         PreparedStatement statement = ((java.sql.Connection) conn).prepareStatement("UPDATE cats" +
//                 " SET id = " + cat.id + ",name =?" +
//                 " WHERE id=" + cat.id + ";");
//         statement.setString(1, cat.name);
//         statement.executeUpdate();
//     }
// }