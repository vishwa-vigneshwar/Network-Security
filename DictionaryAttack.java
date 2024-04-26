import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryAttack {
    public static void main(String[] args) {
        String username = "user123"; // The target username
        String dictionaryFile = "passwords.txt"; // Path to the dictionary file
        boolean accessGranted = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(dictionaryFile))) {
            String password;
            while ((password = reader.readLine()) != null) {
                if (authenticate(username, password)) {
                    System.out.println("Access granted for username: " + username + " with password: " + password);
                    accessGranted = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!accessGranted) {
            System.out.println("Dictionary attack failed. Access not granted.");
        }
    }

    // Simulate authentication logic
    private static boolean authenticate(String username, String password) {
        // In a real system, this function would check if the provided username and password are correct.
        // For demonstration purposes, it only checks if the password matches "123456".
        return password.equals("123456");
    }
}
