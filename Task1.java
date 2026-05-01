import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        //  Take 5 inputs from user
        System.out.println("Enter 5 elements:");
        for (int i = 0; i < 5; i++) {
            String input = scanner.nextLine();
            list.add(input);
        }

        // File path (Desktop)
        String filePath = System.getProperty("user.home") + "/Desktop/myfile.txt";
        File file = new File(filePath);

        try {
            //  Write to file using BufferedWriter
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String item : list) {
                writer.write(item);
                writer.newLine();
            }
            writer.close();
            System.out.println("Data written to file.");

            // Read from file
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("\nReading from file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            // Delete the file
            if (file.delete()) {
                System.out.println("\nFile deleted successfully.");
            } else {
                System.out.println("\nFailed to delete the file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
