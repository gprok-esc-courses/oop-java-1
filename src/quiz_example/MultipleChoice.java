package quiz_example;

import java.util.Random;

public class MultipleChoice extends Question {
    @Override
    public void setAnswers(String correct, String[] wrong) {
        String [] answers = new String[4];
        Random rnd = new Random();
        int r = rnd.nextInt(4);
        int wrongPoint = 0;
        for(int i = 0; i < 4; i++) {
            if(i == r) {
                answers[i] = correct;
            }
            else {
                answers[i] = wrong[wrongPoint];
                wrongPoint++;
            }
        }
        correctIndex = r;
        this.answers = answers;
    }
}
