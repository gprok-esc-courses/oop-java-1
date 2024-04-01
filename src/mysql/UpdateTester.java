package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTester {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "test4", "1111");

            Scanner scanner = new Scanner(System.in);
            System.out.print("ID: ");
            int id = scanner.nextInt();
            System.out.print("Stock: ");
            int stock = scanner.nextInt();
            String query = "UPDATE product SET stock=? WHERE id=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, stock);
            st.setInt(2, id);
            st.execute();
            int rows = st.getUpdateCount();
            if(rows > 0) {
                System.out.println("Product stock updated");
            }
            else {
                System.out.println("Update failed");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
