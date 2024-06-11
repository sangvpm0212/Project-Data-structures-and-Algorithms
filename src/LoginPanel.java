/*  Name: Văn Phú Minh Sang
    ID: ITDSIU21112
 Purpose: A program applies cryptographic hashing to password verification.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class LoginPanel extends JPanel {

    private Map<String, String> userPasswords;

    public LoginPanel(Map<String, String> userPasswords) {
        this.userPasswords = userPasswords;
        setLayout(new GridLayout(7, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JLabel comparisonResultLabel = new JLabel();
        JLabel storedHashedPasswordLabel = new JLabel("Stored Hashed Password: ");
        JLabel enteredHashedPasswordLabel = new JLabel("Entered Hashed Password: ");
        JLabel displayStoredHashedPassword = new JLabel();
        JLabel displayEnteredHashedPassword = new JLabel();

        add(new JLabel("Username: "));
        add(usernameField);
        add(new JLabel("Password: "));
        add(passwordField);
        add(new JLabel());
        add(loginButton);
        add(storedHashedPasswordLabel);
        add(displayStoredHashedPassword);
        add(enteredHashedPasswordLabel);
        add(displayEnteredHashedPassword);
        add(new JLabel("Comparison Result: "));
        add(comparisonResultLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword());

                // Check for empty fields
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username and password cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Verify the password
                String storedHashedPassword = userPasswords.get(username);
                String enteredHashedPassword = hashPassword(password);
                boolean loginSuccessful = storedHashedPassword != null && storedHashedPassword.equals(enteredHashedPassword);

                displayStoredHashedPassword.setText(storedHashedPassword != null ? storedHashedPassword : "N/A");
                displayEnteredHashedPassword.setText(enteredHashedPassword);

                if (loginSuccessful) {
                    comparisonResultLabel.setText("Password comparison: Matched");
                    JOptionPane.showMessageDialog(null, "Login successful! Welcome back, " + username + "!");
                } else {
                    comparisonResultLabel.setText("Password comparison: Not Matched");
                    JOptionPane.showMessageDialog(null, "Login failed. Incorrect username or password.");
                }
            }
        });
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
