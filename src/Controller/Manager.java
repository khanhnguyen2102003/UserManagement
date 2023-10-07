package Controller;

import Model.User;
import View.Menu;

public class Manager {

    private User model;
    private Menu menu;

    public Manager(User model, Menu menu) {
        this.model = model;
        this.menu = menu;
    }

    public void run() {
        while (true) {
            int choice = menu.getMenuChoice();
            switch (choice) {
                case 1:
                    createNewAccount();
                    break;
                case 2:
                    loginSystem();
                    break;
                case 3:
                    return;
                default:
                    menu.showErrorMessage("Invalid choice. Please try again.");
            }
        }
    }

    private void createNewAccount() {
        String username;
        String password;

        do {
            username = menu.getUsername();
            if (!isValidUsername(username)) {
                menu.showErrorMessage("Invalid username format. Username must be at least 5 characters and contain no spaces.");
            }
        } while (!isValidUsername(username));

        do {
            password = menu.getPassword();
            if (!isValidPassword(password)) {
                menu.showErrorMessage("Invalid password format. Password must be at least 6 characters and contain no spaces.");
            }
        } while (!isValidPassword(password));

        if (model.createUser(username, password)) {
            menu.showMessage("Account created successfully.");
        } else {
            menu.showErrorMessage("Username already exists.");
        }
    }

    private void loginSystem() {
        String username;
        String password;

        do {
            username = menu.getUsername();
            if (!isValidUsername(username)) {
                menu.showErrorMessage("Invalid username format. Username must be at least 5 characters and contain no spaces.");
            }
        } while (!isValidUsername(username));

        do {
            password = menu.getPassword();
            if (!isValidPassword(password)) {
                menu.showErrorMessage("Invalid password format. Password must be at least 6 characters and contain no spaces.");
            }
        } while (!isValidPassword(password));

        if (model.login(username, password)) {
            menu.showMessage("Login successful.");
        } else {
            menu.showErrorMessage("Login failed. Username or password is incorrect.");
        }
    }

    private boolean isValidUsername(String username) {
        return username.length() >= 5 && !username.contains(" ");
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 6 && !password.contains(" ");
    }

    public static void main(String[] args) {
        User model = new User();
        Menu menu = new Menu();
        Manager controller = new Manager(model, menu);
        controller.run();
    }
}
