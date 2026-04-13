import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

public class Account {
    private final Console console = System.console();

    String ogUser; //global var. for login validation
    char[] ogPass; // Replaced with char[] for more secured password reading - Charles Tinoy

    /**
     * Check if console ba ang gi gamit nimo.
     * @return boolean
     */
    private boolean checkIfConsole() {
        if (console == null) {
            Main.displayBorder(10, "ERROR");
            System.out.println("No console available. Run this in a real terminal.");
            return false;
        }

        return true;
    }

    /**
     * CREATING ACC CHANGES
     *
     * Changes from Charles Tinoy (Same ra ang logic don't worry ;D)
     *
     * 1. Instead na mag gamit ug while loop for both password and pasasword confirmation, gi separate nako.
     *
     * 2. Using "console.readPassword()" instead of a nextLine from scanner
     *      Kay aron mas secure ang safe ang imohang application.
     *
     * 3. Added extra logic for checking username availability
     *      Please refer sa "DatabaseService.testUsername" for details ;D
     */

    //sign up
    public void createAcc(Scanner scanner){
        if (!checkIfConsole()) return;

        Main.clearConsole();

        char[] confirmPass;

        Main.displayBorder(10, "SIGN UP");

        //username input
        System.out.print("Create a username: ");
        scanner.nextLine(); // This prevents from skipping the inputs automatically - Charles Tinoy
        ogUser = scanner.nextLine();

        // ========== CHECK IF USERNAME ALREADY EXISTED ==========
        while (DatabaseService.testUsername(ogUser)) {
            System.out.println();
            Main.displayBorder(10, "Username is already taken");
            System.out.print("Create a username: ");
            ogUser = scanner.nextLine();
        }

        System.out.println();

        //password input and validation
        ogPass = console.readPassword("Create a password: ");

        // ========== PASSWORD CREATION VALIDATION ==========
        while (ogPass.length < 6) {
            Arrays.fill(ogPass, ' ');

            Main.displayBorder(10, "Password too weak. Minimum of 6 characters");
            ogPass = console.readPassword("Create a password: ");
        }

        // ========== PASSWORD CONFIRMATION VALIDATION ==========
        confirmPass = console.readPassword("Confirm your password: ");
        while (!Arrays.equals(ogPass, confirmPass)) {
            Arrays.fill(confirmPass, ' ');

            Main.displayBorder(10, "Password didn't match. Try again");
            confirmPass = console.readPassword("Confirm your password: ");
        }

        System.out.println("Success: Account created successfully!\n");

        // ========== E ADD SI USER SA DATABASE ==========
        User user = new User(ogUser, ogPass);
        DatabaseService.addAndSaveUser(user);

        // ========== E CLEAR ANG CACHE SA "console.readPassword()" (Aron dli ma hack) >:( ==========
        Arrays.fill(ogPass, ' ');
        Arrays.fill(confirmPass, ' ');
    }

    /**
     * LOGIN ACC CHANGES
     *
     * Changes from Charles Tinoy (Same ra gihapon ang logic ;D)
     *
     * 1. E separate ang logic sa pag check sa username and password
     *      please ko check lang sa "DatabaseService.[testUsername and testPassword]" for more details ;D
     *
     * 2. So gi removed nako ang "do { } while" loop since ang each input man atoang e validate.
     *
     * 3. And also nag ang attempts is naa sud sa each validation sa inputs.
     *
     * @param scanner (Scanner)
     */

    //sign in
    public void loginAcc(Scanner scanner){
        if (!checkIfConsole()) return;

        Main.clearConsole();
        DatabaseService.readDatabase();

        String username;
        char[] pass;
        int attempt = 0;

        Main.displayBorder(10, "SIGN IN");

        //log in, and recheck acc info
        System.out.print("Enter your username: ");
        scanner.nextLine(); // This prevents from skipping the inputs automatically - Charles Tinoy
        username = scanner.nextLine();

        // ========== E CHECK ANG USERNAME ==========
        while (!DatabaseService.testUsername(username)) {
            System.out.println();

            if (attempt >= 3) {
                System.out.println("Too many attempts. Try again later.\n");
                return;
            }

            Main.displayBorder(10, "We couldn't find your username");
            System.out.print("Enter your username: ");
            ogUser = scanner.nextLine();

            attempt++;
        }

        System.out.println();
        pass = console.readPassword("Enter your password: ");

        // ========== E CHECK ANG PASSWORD ==========
        while (!DatabaseService.testUsernameAndPassword(username, pass)) {
            if (attempt >= 3) {
                System.out.println("Too many attempts. Try again later.\n");
                return;
            }

            Main.displayBorder(10, "Wrong password.");
            pass = console.readPassword("Enter your password: ");

            attempt++;
        }

        // ========== THEN BWALA ;D ==========
        User user = DatabaseService.getUserByNameAndPass(username, pass);

        // ========== E CLEAR ANG CACHE SA "console.readPassword()" (Aron dli ma hack) >:( ==========
        Arrays.fill(pass, ' ');

        if (user == null) {
            System.out.println("Error: Unable to find your account.\n");
            return;
        }

        user.toString();
    }
}