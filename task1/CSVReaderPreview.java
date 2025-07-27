package task1;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        
        String filePath = "dataset/dataset.csv";
        String line;
        String delimiter = ",";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            String headerLine = bufferedReader.readLine();
            if (headerLine == null) {
                System.out.println("The CSV file is empty.");
                return;
            }

            System.out.println("=== Data Preview ===\n");

            // Display column headers
            String[] headers = headerLine.split(delimiter);
            System.out.println("Columns:");
            for (String column : headers) {
                System.out.print(column + " ");
            }

            System.out.println("\nTotal columns: " + headers.length);
            System.out.println("\nFirst 5 Records:\n");

            int totalRecords = 0;

            
            while ((line = bufferedReader.readLine()) != null && totalRecords < 5) {
                String[] fields = line.split(delimiter);
                System.out.println(String.join(" ", fields));
                totalRecords++;
            }

            
            while (bufferedReader.readLine() != null) {
                totalRecords++;
            }

            System.out.println("\nTotal Records (excluding header): " + totalRecords);

        } catch (IOException e) {
            System.err.println("An error occurred while reading the file:");
            e.printStackTrace();
        }
    }
}
