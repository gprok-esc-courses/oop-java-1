package hangman_v1;

import java.util.Random;

public class Hangman {
    private String [] words = {"airplane", "university", "elephant",
    "mississippi", "machinegun", "australia", "skyfall", "tourist",
    "passenger", "electricity"};
    private String secret;
    private String correct_responses;
    private String wrong_responses;

    public Hangman() {
        this.secret = "";
        this.correct_responses = "";
        this.wrong_responses = "";
    }

    public void newGame() {
        Random rnd = new Random();
        int pos = rnd.nextInt(this.words.length-1);
        this.secret = this.words[pos];
        System.out.println(this.secret);
        wrong_responses = "";
        correct_responses = "";
    }

    public String getSecretWord() {
        String secret = "" + this.secret.charAt(0);
        for(int i = 1; i < this.secret.length()-1; i++) {
            String s = "" + this.secret.charAt(i);
            if(this.correct_responses.contains(s)) {
                secret += s;
            }
            else {
                secret += "_";
            }
        }
        secret += this.secret.charAt(this.secret.length()-1);
        return secret;
    }

    public void play(String guess) {
        // We need to check that 'guess' is just one character
        if(this.secret.contains(guess)) {
            this.correct_responses += guess;
        }
        else {
            this.wrong_responses += guess;
        }
    }

    public boolean isHanged() {
        return this.wrong_responses.length() == 6;
    }

    public boolean isFound() {
        for(int i = 1; i < this.secret.length()-1; i++) {
            String s = "" + this.secret.charAt(i);
            if(!this.correct_responses.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
