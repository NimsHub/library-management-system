package library;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;

public class Logger {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void log(Level level, String message) {
        String formattedMessage = String.format("[%s] %s: %s\n", LocalDateTime.now().format(formatter), level.getName(), message);
        System.out.print(formattedMessage);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void warn(String message) {log(Level.WARNING, message);}

    public void error(String message) {log(Level.SEVERE, message);}
}
