package riddles;

/**
 * Represents a single riddle and its answer
 */
public class Riddle {
    private String question;
    private String answer;

    /**
     * Class constructor
     * @param question the question of the riddle
     * @param answer the valid answer
     */
    public Riddle(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    /**
     * Provides the question of the riddle
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Checks if a provided answer is correct or not
     * @param ans the provided answer
     * @return true if the provided answer is correct
     */
    public boolean checkAnswer(String ans) {
        return answer.equals(ans);
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Q: " + question + "\n" + "A: " + answer;
    }
}
