import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter Student Full Name: ");
            String studentName = input.nextLine();

            System.out.print("Enter Student ID: ");
            String studentID = input.nextLine();

            System.out.print("Enter PF Lab Marks: ");
            int pfLab = input.nextInt();

            System.out.print("Enter PF Theory Marks: ");
            int pfTheory = input.nextInt();
            input.nextLine();

            String fileName = studentName.replace(" ", "_") + ".txt";

            ArrayList<String> courses = new ArrayList<>();

            int maxCredits = 15;
            int currentCredits = 0;

            System.out.print("Enter number of courses you want to register: ");
            int n = input.nextInt();
            input.nextLine();

            boolean oopRequested = false;

            for (int i = 0; i < n; i++) {

                System.out.print("Enter course name: ");
                String course = input.nextLine();

                // Detect OOP request (any form)
                boolean isOOP = course.equalsIgnoreCase("OOP Lab")
                        || course.equalsIgnoreCase("OOP Theory")
                        || course.equalsIgnoreCase("OOP");

                if (isOOP) {
                    oopRequested = true;

                    // Check PF condition
                    if (pfLab >= 50 && pfTheory >= 50) {

                        // OOP Lab + Theory together = 6 credits
                        if (currentCredits + 6 <= maxCredits) {
                            courses.add("OOP Lab");
                            courses.add("OOP Theory");
                            currentCredits += 6;
                            System.out.println("OOP courses registered successfully.");
                        } else {
                            System.out.println("Not enough credit hours for OOP courses.");
                        }

                    } else {
                        System.out.println("Cannot register OOP: PF requirement not met.");
                    }

                } else {
                    // Normal course
                    if (currentCredits + 3 <= maxCredits) {
                        courses.add(course);
                        currentCredits += 3;
                    } else {
                        System.out.println("Credit hour limit reached. Cannot add " + course);
                    }
                }
            }


            // Write file
            FileWriter writer = new FileWriter(fileName);
            writer.write("Student Name: " + studentName + "\n");
            writer.write("Student ID: " + studentID + "\n");
            writer.write("Registered Courses:\n");

            for (String c : courses) {
                writer.write("- " + c + "\n");
            }

            writer.close();

            // Read file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            System.out.println("\n--- File Content ---");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}