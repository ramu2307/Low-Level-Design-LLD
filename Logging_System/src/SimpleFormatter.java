public class SimpleFormatter implements Formatter{
    @Override
    public String format(LogMessage logMessage) {
        return logMessage.currentDateTime + " [" + logMessage.level + "] " + logMessage.message;
    }
}
