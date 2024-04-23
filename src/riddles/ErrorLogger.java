package riddles;

import java.io.*;

public class ErrorLogger {

    public void error(String message) {
        try {
            File file = new File("error.log");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            message = message.replace("\n", " ");
            writer.write(message);
            writer.println();
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Error logger not working properly");
        }
    }
}
