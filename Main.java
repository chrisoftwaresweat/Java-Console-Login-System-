import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();

        //sign up
        account.createAcc(scanner);

        //sign in
        account.loginAcc(scanner);

        scanner.close();
    }
}
