import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

public class Account {
    private final Console console = System.console();

    String ogUser; //global var. for login validation
    char[] ogPass; // Replaced with char[] for more secured password reading - Charles Tinoy

    //sign up
    public void createAcc(Scanner scanner){
        if (console == null) {
            Main.displayBorder(10, "ERROR");
            System.out.println("No console available... Run this in a real terminal.");
            return;
        }

        char[] confirmPass;

        Main.displayBorder(10, "SIGN UP");

        //username input
        System.out.print("Create a username: ");
        scanner.nextLine(); // This prevents from skipping the inputs automatically - Charles Tinoy
        ogUser = scanner.nextLine();
        System.out.println();

        /**
         * Changes from Charles Tinoy (Same ra ang logic don't worry ;D)
         * 1. Instead na mag gamit ug while loop for both password and pasasword confirmation, gi separate nako.
         *
         * 2. Using "console.readPassword()" instead of a nextLine from scanner
         *      Kay aron mas secure ang safe ang imohang application.
         */
        //password input and validation
        ogPass = console.readPassword("Create a password: ");

        // ========== PASSWORD CREATION ==========
        while (ogPass.length < 6) {
            Arrays.fill(ogPass, ' ');
            Main.displayBorder(10, "Password Error: Try again.");
            System.out.println("Password too weak. Minimum of 6 characters");
            ogPass = console.readPassword("Create a password: ");
        }

        // ========== PASSWORD CONFIRMATION ==========
        confirmPass = console.readPassword("Confirm your password: ");
        while (!Arrays.equals(ogPass, confirmPass)) {
            Arrays.fill(confirmPass, ' ');
            Main.displayBorder(10, "Password Confirmation Error: Try again.");
            System.out.println("Password didn't match. Try again");
            confirmPass = console.readPassword("Confirm your password: ");
        }

        System.out.println("Success: Account created successfully!\n");

        // ========== E CLEAR ANG CACHE SA "console.readPassword()" (Aron dli ma hack) >:( ==========
        Arrays.fill(ogPass, ' ');
        Arrays.fill(confirmPass, ' ');
    }

    //sign in
    public void loginAcc(Scanner scanner){
        String user, pass;
        int attempt = 0;

        Main.displayBorder(10, "SIGN IN");

        //log in, and recheck acc info
        do {

            System.out.print("Enter your username: "); user = scanner.nextLine();
            System.out.print("Enter your password:"); pass = scanner.nextLine();

            if (!user.equals(ogUser)) {
                attempt++;
                System.out.println("\nWe couldn't find your username.\n");
            } else if (!pass.equals(ogPass)) {
                attempt++;
                System.out.println("\nWrong password.\n");
            }else {
                System.out.printf("\nWELCOME %s\n\n", ogUser.toUpperCase());
                break;
            }

            //count the attempts, and stops the user after the third attempt
            if (attempt==3) {
                System.out.println("\nToo many attempts. Try again later\n");
                break;
            }

        }while (attempt<3);

    }
}