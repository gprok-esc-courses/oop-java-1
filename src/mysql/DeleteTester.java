package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteTester {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "test4", "1111");

            Scanner scanner = new Scanner(System.in);
            System.out.print("ID: ");
            int id = scanner.nextInt();
            String query = "DELETE FROM product WHERE id=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, id);
            st.execute();
            int rows = st.getUpdateCount();
            if(rows > 0) {
                System.out.println("Product deleted");
            }
            else {
                System.out.println("Delete failed");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
