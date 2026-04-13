import java.io.Serializable;

/**
 * Model ni sya para sa "USER"
 * Think of it as a "BLUEPRINT" sa mga users
 * Each user kay naay "Username" and "Password" and both are protected for privacy and security ;D
 */
public class User implements Serializable {
    private final String username;
    private final char[] password;

    public User(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getUsername() { return username; }
    public char[] getPassword() { return password; }

    /**
     * Polymorphism para sa "toString()" nga method
     *      Aron lahus na ug print bah kapoy ug print manually oy 💀
     * @return String
     */
    @Override
    public String toString() {
        System.out.printf("Welcome %s!\n", username);
        System.out.println();
        return super.toString();
    }
}
