package Model;


import java.io.*;
import java.util.*;

public class User {
    private static final String DATA_FILE = System.getProperty("user.dir") + "\\src\\user.dat";
    private Map<String, String> users;
    public User() {
        users = new HashMap<>();
        loadDataFromFile();
    }

    private void loadDataFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean createUser(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, password);
            saveDataToFile();
            return true;
        }
        return false;
    }

    public boolean login(String username, String password) {
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    private void saveDataToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                bw.write(entry.getKey() + ";" + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
