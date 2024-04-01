package mysql.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {
    private int id;
    private String username;
    private String password;
    private int balance;

    public Account() {

    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean register() {
        Connection con = Database.getConnection();
        if(con != null) {
            String query = "INSERT INTO accounts (username, password, balance) VALUES (?,?,0)";
            try {
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, username);
                st.setString(2, password);
                st.execute();
                int rows = st.getUpdateCount();
                if(rows == 0) {
                    System.out.println("Wrong data, try again");
                    return false;
                }
                else {
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("Wrong query");
            }
        }
        return false;
    }

    public boolean login() {
        Connection con = Database.getConnection();
        String query = "SELECT * FROM accounts WHERE username=?";
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                if(password.equals(rs.getString("password"))) {
                    id = rs.getInt("id");
                    balance = rs.getInt("balance");
                    return true;
                }
                else {
                    System.out.println("Wrong password");
                }
            }
            else {
                System.out.println("Username not found");
            }
        } catch (SQLException e) {
            System.out.println("Wrong query");
        }
        return false;
    }
}
