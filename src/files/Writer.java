package files;

import java.io.*;

public class Writer {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(new File("test.txt"), true)));

        writer.write("Hello from the Writer class");
        writer.println();
        writer.close();
    }
}
