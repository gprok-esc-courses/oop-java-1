package mysql.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bank_java_1",
                    "test4", "1111");
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("DB Driver not found");
        } catch (SQLException e) {
            System.out.println("Cannot connect to the database");
        }
        return null;
    }
}
