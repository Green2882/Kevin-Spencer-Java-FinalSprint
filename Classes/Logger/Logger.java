package Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {

    private static final String LOG_FILE = "application.log";

    public static void log(String level, String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            String logLine = String.format("%s [%s] %s%n",
                    LocalDateTime.now(),
                    level,
                    message
            );

            writer.write(logLine);

        } catch (IOException e) {
            System.err.println("LOGGER FAILED: " + e.getMessage());
        }
    }

    public static void error(String message) {
        log("ERROR", message);
    }

    public static void info(String message) {
        log("INFO", message);
    }

}
