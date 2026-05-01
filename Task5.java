import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Create file
            File file = new File("Confidential.txt");

            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            //  Take input
            System.out.print("Enter designation (Faculty/Student): ");
            String designation = sc.nextLine().trim();

            //  Assign permissions
            boolean canRead = false;
            boolean canWrite = false;
            boolean canExecute = false;

            if (designation.equalsIgnoreCase("Faculty")) {
                canRead = true;
                canWrite = true;
                canExecute = true;
            }
            else if (designation.equalsIgnoreCase("Student")) {
                canRead = true;
            }
            else {
                System.out.println("Invalid designation entered.");
                return;
            }

            // Apply permissions to file
            file.setReadable(canRead);
            file.setWritable(canWrite);
            file.setExecutable(canExecute);

            // Step 4: Display access rights
            System.out.println("\nAccess Rights Status:");
            System.out.println("Read (R): " + (canRead ? "YES" : "NO"));
            System.out.println("Write (W): " + (canWrite ? "YES" : "NO"));
            System.out.println("Execute (X): " + (canExecute ? "YES" : "NO"));

        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }

        sc.close();
    }
}


