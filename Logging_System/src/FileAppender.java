import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileAppender implements Appender{

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    public void append(String formattedMessage) {

        String currentDate = LocalDateTime.now().format(DATE_TIME_FORMATTER);
        String fileName = "fileWriterlogs_" + currentDate + ".log";

        try(FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(formattedMessage);
            fw.write(System.lineSeparator());
        }
        catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }
}
