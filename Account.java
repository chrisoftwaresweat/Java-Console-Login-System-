import java.util.Scanner;

public class Account {
    String ogUser, ogPass; //global var. for login validation

    //sign up
    public void createAcc(Scanner scanner){
        String confirmPass;

        System.out.println("SIGN UP");

        //username input
        System.out.print("Create a username: ");
        ogUser = scanner.nextLine();

        //password input and validation
        do{
            System.out.print("Create a password: "); ogPass = scanner.nextLine();
            System.out.print("Confirm your password: "); confirmPass = scanner.nextLine();

            if (!ogPass.equals(confirmPass)) System.out.println("\nPassword didn't match. Try again\n");
            else if (ogPass.length()<6) System.out.println("\nPassword too weak. Minimum of 6 characters\n");
            else System.out.println("\nAccount created successfully\n");

        }while(!ogPass.equals(confirmPass) || ogPass.length()<6);

    }

    //sign in
    public void loginAcc(Scanner scanner){
        String user, pass;
        int attempt = 0;

        System.out.println("SIGN IN");

        //log in, and recheck acc info
        do {

            System.out.print("Enter your username: "); user = scanner.nextLine();
            System.out.print("Enter your password: "); pass = scanner.nextLine();

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
