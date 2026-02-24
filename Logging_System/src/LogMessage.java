import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogMessage {
    LogLevel level;
    String message;
    String currentDateTime;

    public LogMessage(LogLevel level, String message) {
        this.level = level;
        this.message = message;
        this.currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
