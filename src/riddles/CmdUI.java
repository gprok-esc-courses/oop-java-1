package riddles;

import java.util.ArrayList;
import java.util.Scanner;

public class CmdUI {
    private Game game;
    private Scanner scanner;

    public CmdUI() {
        game = new Game();
        scanner = new Scanner(System.in);
    }

    public void getUsername() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        game.setUsername(username);
    }

    public void displayScore() {
        System.out.println("SCORE: " + game.getScore() + "/4");
    }

    public String playAgain() {
        System.out.print("Play again? (y/n): ");
        String response = scanner.nextLine();
        return response;
    }

    public void displayTopScorers() {
        System.out.println("TOP SCORERS");
        ArrayList<String> top = game.getTopScorers();
        for(String s : top) {
            System.out.println(" - " + s);
        }
    }

    public void run() {
        do {
            getUsername();
            if(!game.gameOver()) {
                String response = "y";
                do {
                    game.startNewGame();
                    for (int i = 0; i < 4; i++) {
                        System.out.println(game.getCurrentQuestion());
                        System.out.print("Answer: ");
                        String answer = scanner.nextLine();
                        game.isCorrectAnswer(answer);
                    }
                    displayScore();
                    game.saveScore();
                    displayTopScorers();
                    response = playAgain();
                } while(response.equals("y"));
            }
        } while(!game.gameOver());
    }
}
