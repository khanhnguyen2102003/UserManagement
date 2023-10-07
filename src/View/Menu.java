package View;


import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("========= USER MANAGEMENT SYSTEM =========");
        System.out.println("||1. Create a new account.              ||");
        System.out.println("||2. Login system.                      ||");
        System.out.println("||3. Exit.                              ||");
        System.out.println("==========================================");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public String getUsername() {
        System.out.print("Enter username: ");
        return scanner.next();
    }

    public String getPassword() {
        System.out.print("Enter password: ");
        return scanner.next();
    }

    public void showErrorMessage(String message) {
        System.err.println(message);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
