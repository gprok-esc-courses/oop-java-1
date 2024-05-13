package quiz_example;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private ArrayList<Question> questions;
    private int score;
    private int current;

    public void newGame() {
        APIReader reader = new APIReader();
        questions = reader.getQuestionList();
        score = 0;
        current = 0;
    }

    public void displayCurrent() {
        questions.get(current).display();
    }

    public void checkAnswer(int ans) {
        if(questions.get(current).isCorrectAnswer(ans)) {
            score++;
        }
        current++;
    }

    public boolean gameOver() {
        return current == 10;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        newGame();
        while(!gameOver()) {
            displayCurrent();
            System.out.print("ANSWER: ");
            int ans = scanner.nextInt();
            checkAnswer(ans);
        }
        System.out.println("SCORE: " + score);
    }
}
