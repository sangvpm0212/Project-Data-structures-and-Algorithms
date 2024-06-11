/*  Name: Văn Phú Minh Sang
    ID: ITDSIU21112
 Purpose: A program applies cryptographic hashing to password verification.
*/

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class PasswordVerifier extends JFrame {

    private static Map<String, String> userPasswords = new HashMap<>();

    public PasswordVerifier() {
        setTitle("Password Verification System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Register", new RegisterPanel(userPasswords));
        tabbedPane.addTab("Login", new LoginPanel(userPasswords));

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PasswordVerifier passwordVerifier = new PasswordVerifier();
            passwordVerifier.setVisible(true);
        });
    }
}
