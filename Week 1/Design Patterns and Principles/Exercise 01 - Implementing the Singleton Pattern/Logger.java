package singleton;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static volatile Logger instance;
    private PrintWriter fileWriter;

    private Logger() {
        try {
            fileWriter = new PrintWriter(new FileWriter("server.log", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        String logMessage = String.format("[LOG] %s", message);
        System.out.println(logMessage);
        fileWriter.println(logMessage);
        fileWriter.flush();
    }
}