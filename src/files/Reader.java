package files;

import java.io.*;

public class Reader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("test.txt")));

        String line;

        do {
            line = reader.readLine();
            if(line != null) {
                System.out.println(line);
            }
        } while(line != null);
    }
}
