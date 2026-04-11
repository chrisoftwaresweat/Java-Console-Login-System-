import java.util.Scanner;

public class Main {
    public static void displayBorder(int length) {
        for (int i = 0; i < length; i++)
            System.out.print("=");
        System.out.println();
    }

    public static void displayBorder(int length, String heading) {
        for (int i = 0; i < length / 2; i++)
            System.out.print("=");
        System.out.printf(" %s ", heading);
        for (int i = 0; i < length / 2; i++)
            System.out.print("=");
        System.out.println();
    }

    private static void displayOptions() {
        displayBorder(10, "Options");
        System.out.println("SIGN UP\t\t\t[1]");
        System.out.println("SIGN IN\t\t\t[2]");
        System.out.println("EXIT\t\t\t[3]");
        displayBorder(10, "Options");
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();

        boolean isExit = false;
        do {
            displayOptions();

            System.out.print("Option: ");
            while (!scanner.hasNextInt()) {
                displayOptions();
                System.out.print("Invalid input, please try again: ");
                scanner.next();
            }
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> account.createAcc(scanner);
                case 2 -> account.loginAcc(scanner);
                default -> isExit = true;
            }
        } while (!isExit);

        scanner.close();
    }
}