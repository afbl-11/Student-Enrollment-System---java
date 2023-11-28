public abstract class Validators {
    public static void validatePassword(String password) {
        // Check if the password is null or empty
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty.");
        }

        // Check if the password length is less than the minimum required
        if (password.length() < 8 || password.length() > 128) {
            throw new IllegalArgumentException("Password must be at least 8 characters long.");
        }

        // Additional password validation criteria can be added here

        // If the password passes all checks, it is considered valid
    }
    
}
