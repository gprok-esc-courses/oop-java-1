package hangman_v1;

public class User {
    private String name;
    private int found_times;
    private int hanged_times;

    public User(String name) {
        this.name = name;
        this.found_times = 0;
        this.hanged_times = 0;
    }

    public void hanged() {
        hanged_times++;
    }

    public void found() {
        found_times++;
    }

    public String getFinalScore() {
        return this.name + " Found: " + found_times + " Hanged: " + hanged_times;
    }
}
