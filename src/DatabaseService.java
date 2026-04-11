import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseService {
    public static final String DATABASE_PATH = "database.bin";

    public static List<User> USERS = new ArrayList<>();

    /**
     * Write the database file ;D
     */
    public static void writeDatabase() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(DATABASE_PATH))) {
            objectOutputStream.writeObject(USERS);
        } catch (IOException ex) {
            System.err.println("Something went wrong, Error: " + ex.getMessage());
        }
    }

    /**
     * Read the database file ;D
     */
    public static void readDatabase() {
        Path path = Paths.get(DATABASE_PATH);
        if (!Files.exists(path)) writeDatabase();

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DATABASE_PATH))) {
            USERS = (List<User>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Something went wrong, Error: " + ex.getMessage());
        }
    }

    /**
     * Add and save the user to the database ;D
     * @param user (User)
     */
    public static void addAndSaveUser(User user) {
        USERS.add(user);
        writeDatabase();
    }

    /**
     * Test niya if naay username mo match ;D
     * @param username (String)
     * @return boolean
     */
    public static boolean testUsername(String username) {
        return USERS.stream().anyMatch(user -> user.getUsername().equals(username));
    }

    /**
     * Test niya if mo match and username and password ;D
     * @param username (String)
     * @param password (char[])
     * @return boolean
     */
    public static boolean testUsernameAndPassword(String username, char[] password) {
        return USERS.stream()
                .anyMatch(user ->
                        user.getUsername().equals(username) &&
                        Arrays.equals(user.getPassword(), password)
                );
    }

    /**
     * Kuhaon niya ang user by its username and password ;D
     * @param username (String)
     * @param password (char[])
     * @return User
     */
    public static User getUserByNameAndPass(String username, char[] password) {
        return USERS.stream()
                .filter(u -> u.getUsername().equals(username))
                .filter(u -> Arrays.equals(u.getPassword(), password))
                .findFirst()
                .orElse(null);
    }
}
