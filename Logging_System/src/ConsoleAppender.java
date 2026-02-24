public class ConsoleAppender implements Appender{
    public void append(String formattedMessage) {
        System.out.println(formattedMessage);
    }
}
