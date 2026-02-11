import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static Logger instance;

    private BufferedWriter writer;
    private String fileName = "log.txt";

    private Logger() {
        openFile(fileName);
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private void openFile(String fileName) {
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public synchronized void setFileName(String newFileName) {
        close();
        this.fileName = newFileName;
        openFile(newFileName);
    }

    public synchronized void write(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public synchronized void close() {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}