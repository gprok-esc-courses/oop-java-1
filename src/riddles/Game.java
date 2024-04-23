package riddles;

import riddles.error_observers.FileLogger;
import riddles.error_observers.MailLogger;
import riddles.error_observers.PrinterLogger;

import java.util.ArrayList;

public class Game {
    private String username;
    private ArrayList<Riddle> riddles;
    private int score;
    private int current;
    private Database db;
    private RiddleFinder finder;


    public Game() {
        db = new Database();
        db.addErrorObserver(new FileLogger());
        db.addErrorObserver(new PrinterLogger());
        db.connect();
        finder = new RiddleFinder();
        finder.addErrorObserver(new FileLogger());
        finder.addErrorObserver(new MailLogger());
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void startNewGame() {
        riddles = finder.getRiddles(4);
        score = 0;
        current = 0;
    }

    public boolean gameOk() {
        return riddles != null && riddles.size() == 4;
    }

    public String getCurrentQuestion() {
        System.out.println("Cheat: " + riddles.get(current).getAnswer());
        return riddles.get(current).getQuestion();
    }

    public boolean isCorrectAnswer(String answer) {
        if(riddles.get(current).checkAnswer(answer)) {
            score++;
            current++;
            return true;
        }
        else {
            current++;
            return false;
        }
    }

    public void saveScore() {
        db.saveScore(username, score);
    }

    public boolean gameOver() {
        return username.equals("exit");
    }

    public int getScore() {
        return score;
    }

    public ArrayList<String> getTopScorers() {
        return db.getTopScores(2);
    }
}
