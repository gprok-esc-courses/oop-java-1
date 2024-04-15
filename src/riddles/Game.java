package riddles;

import java.util.ArrayList;

public class Game {
    private String username;
    private ArrayList<Riddle> riddles;
    private int score;
    private int current;
    private Database db;


    public Game() {
        db = new Database();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void startNewGame() {
        RiddleFinder finder = new RiddleFinder();
        riddles = finder.getRiddles(4);
        score = 0;
        current = 0;
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
