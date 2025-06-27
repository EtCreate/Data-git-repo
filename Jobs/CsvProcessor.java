package Jobs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CsvProcessor {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ElizabethHogan\\Downloads\\data.csv"; // Path to your CSV file

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {

            lines.skip(1) // skip header
                 .map(line -> line.split(",")) // split by comma
                 .forEach(fields -> {
                     int id = Integer.parseInt(fields[0].trim());
                     String name = fields[1].trim();
                     int age = Integer.parseInt(fields[2].trim());

                     System.out.printf("ID: %d, Name: %s, Age: %d%n", id, name, age);
                 });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


