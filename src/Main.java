import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    /**
     * Mo clear ang console duhhh
     */
    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception ex) {
            System.err.println("Something went wrong, error: " + ex.getMessage());
        }
    }

    /**
     * Mo display ug "=" based sa length
     * @param length (int)
     */
    public static void displayBorder(int length) {
        for (int i = 0; i < length; i++)
            System.out.print("=");
        System.out.println();
    }

    /**
     * Same ra pero naay heading, for example "===== HELLO WORLD ====="
     * @param length (int)
     * @param heading (String)
     */
    public static void displayBorder(int length, String heading) {
        for (int i = 0; i < length / 2; i++)
            System.out.print("=");
        System.out.printf(" %s ", heading);
        for (int i = 0; i < length / 2; i++)
            System.out.print("=");
        System.out.println();
    }

    /**
     * Gi butang lang nako dri kay gubot na kaayo ang main :(
     */
    private static void displayOptions() {
        displayBorder(10, "Options");
        System.out.println("SIGN UP\t\t[1]");
        System.out.println("SIGN IN\t\t[2]");
        System.out.println("EXIT\t\t[3]");
        displayBorder(10, "Options");
    }

    private static boolean checkDatabaseAvailability() {
        Path path = Paths.get(DatabaseService.DATABASE_PATH);
        return Files.exists(path);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();

        clearConsole();
        DatabaseService.readDatabase();

        boolean isExit = false;
        boolean isInitalized = checkDatabaseAvailability();

        do {
            if (!isInitalized)
                System.out.printf("Please wait for the \"%s\" to load...\n", DatabaseService.DATABASE_PATH);

            displayOptions();

            System.out.print("Option: ");
            while (!scanner.hasNextInt()) {
                clearConsole();
                displayOptions();
                System.out.print("Invalid input, please try again: ");
                scanner.next();
            }
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    if (checkDatabaseAvailability()) {
                        isInitalized = true;
                        account.createAcc(scanner);
                    }
                    break;
                case 2:
                    if (checkDatabaseAvailability()) {
                        isInitalized = true;
                        account.loginAcc(scanner);
                    }
                    break;
                default:
                    isExit = true;
            }
        } while (!isExit);

        scanner.close();
    }
}