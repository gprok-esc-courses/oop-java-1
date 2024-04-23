package files;

import java.io.*;

public class TestFile {
    public static void main(String[] args) throws IOException {

        File file = new File("test.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter bwriter = new BufferedWriter(writer);
        PrintWriter pwriter = new PrintWriter(bwriter);
        pwriter.write("Hello from print writer");
        pwriter.println();
        pwriter.close();

    }
}
