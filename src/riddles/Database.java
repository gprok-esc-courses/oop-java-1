package riddles;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection connection;

    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/riddles_java",
                    "test", "test");
        } catch (ClassNotFoundException e) {
            connection = null;
        } catch (SQLException e) {
            connection = null;
        }
    }

    public boolean saveScore(String username, int score) {
        String query = "INSERT INTO scores (username, date_time, score) VALUES (?, NOW(), ?)";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            st.setInt(2, score);
            st.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public ArrayList<String> getTopScores(int n) {
        ArrayList<String> topScorers = new ArrayList<>();
        String query = "SELECT username, AVG(score) as avg_score " +
                        "FROM scores " +
                        "GROUP BY username " +
                        "ORDER BY AVG(score) DESC " +
                        "LIMIT ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, n);
            ResultSet result = st.executeQuery();
            while(result.next()) {
                topScorers.add(result.getString("username") + " score: " + result.getDouble("avg_score"));
            }
        } catch (SQLException e) {

        }
        return topScorers;
    }
}
