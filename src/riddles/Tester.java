package riddles;

import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        Database db = new Database();
        ArrayList<String> top = db.getTopScores(2);
        for(String s : top) {
            System.out.println(s);
        }
    }
}
