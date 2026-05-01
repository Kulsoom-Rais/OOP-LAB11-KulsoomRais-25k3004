import java.util.Scanner;

// Generic class with two parameters
class Login<T, U> {
    private T username;
    private U password;

    // Pre-stored credentials
    private final String storedUsername = "admin";
    private final String storedPassword = "12345";

    public Login(T username, U password) {
        this.username = username;
        this.password = password;
    }

    public void validateLogin() {
        if (username.equals(storedUsername) && password.equals(storedPassword)) {
            System.out.println("Login successful. Welcome, " + username + "!");
        } else {
            System.out.println("Invalid username or password. Program terminated.");
            System.exit(0); // terminate program
        }
    }
}

public class Task3{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String user = input.nextLine();

        System.out.print("Enter Password: ");
        String pass = input.nextLine();

        // Creating generic object
        Login<String, String> login = new Login<>(user, pass);

        // Validate login
        login.validateLogin();

        System.out.println("You can now access the system.");
    }
}





