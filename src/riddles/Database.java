package riddles;

import riddles.error_observers.ErrorObserver;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class Database {
    private Connection connection;
    private ErrorLogger errorLogger;
    private ArrayList<ErrorObserver> errorObservers;

    public Database() {
        errorLogger = new ErrorLogger();
        errorObservers = new ArrayList<>();
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/riddles_java2",
                    "test", "test");
        } catch (ClassNotFoundException e) {
            error(e.getMessage());
            connection = null;
        } catch (SQLException e) {
            error(e.getMessage());
            connection = null;
        }
    }

    public void addErrorObserver(ErrorObserver observer) {
        errorObservers.add(observer);
    }

    public void error(String msg) {
        String message = new Date() + ", " + getClass().getSimpleName() + ", " + msg;
        for(ErrorObserver observer : errorObservers) {
            observer.error(message);
        }
    }

    public boolean saveScore(String username, int score) {
        if(connection == null) {
            return false;
        }
        String query = "INSERT INTO scores (username, date_time, score) VALUES (?, NOW(), ?)";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            st.setInt(2, score);
            st.execute();
            return true;
        } catch (SQLException e) {
            error(e.getMessage());
            return false;
        }
    }

    public ArrayList<String> getTopScores(int n) {
        ArrayList<String> topScorers = new ArrayList<>();
        if(connection == null) {
            return topScorers;
        }
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
            error(e.getMessage());
        }
        return topScorers;
    }
}
