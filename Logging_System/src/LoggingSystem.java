public class LoggingSystem {
    public static void main(String[] args) {

        Formatter formatter = new SimpleFormatter();
        Logger logger = new Logger(formatter);

        logger.addAppender(new ConsoleAppender());
        logger.addAppender(new FileAppender());

        logger.info("This is info message");
        logger.debug("This is debug message");
        logger.error("This is error message");
    }
}
