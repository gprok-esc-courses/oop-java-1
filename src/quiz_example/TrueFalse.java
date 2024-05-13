package quiz_example;

public class TrueFalse extends Question {

    @Override
    public void setAnswers(String correct, String[] wrong) {
        String [] answers = {"True", "False"};
        if(correct.equals("True")) {
            correctIndex = 0;
        }
        else {
            correctIndex = 1;
        }
        this.answers = answers;
    }
}
