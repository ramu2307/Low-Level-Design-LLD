import java.util.ArrayList;
import java.util.List;

public class Logger {

    Formatter formatter;
    List<Appender> appenderList;

    public Logger(Formatter formatter) {
        this.formatter = formatter;
        this.appenderList = new ArrayList<>();
    }
    public void addAppender(Appender appender) {
        this.appenderList.add(appender);
    }

    public void log(LogLevel level, String message) {
        LogMessage logMessage = new LogMessage(level, message);
        String formattedMessage = formatter.format(logMessage);

        for(Appender appender : appenderList) {
            appender.append(formattedMessage);
        }
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
}
