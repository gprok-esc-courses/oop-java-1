package mysql;

import java.sql.*;
import java.util.Scanner;

public class InsertTester {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "test4", "1111");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Price: ");
            double price = scanner.nextDouble();
            System.out.print("Stock: ");
            int stock = scanner.nextInt();
            String query = "INSERT INTO product (name, price, stock) VALUES (?, ?, ?)";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, name);
            st.setDouble(2, price);
            st.setInt(3, stock);
            st.execute();
            int rows = st.getUpdateCount();
            if(rows > 0) {
                System.out.println("Inserted new product");
            }
            else {
                System.out.println("Insert product failed");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
