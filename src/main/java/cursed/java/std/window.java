package cursed.java.std;

import javax.swing.*;
import java.awt.*;

public class window {
    private static JFrame frame;

    public static void create(String title, int width, int height) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

    public static void create(String title) {
        create(title, 400, 300);
    }

    public static void textField(String title, String text) {
        textField(title, text, 400, 300);
    }

    public static void textField(String title, String text, int width, int height) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);

        JTextField textField = new JTextField(text);
        textField.setEditable(false);

        frame.add(textField, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void alert(String message) {
        JOptionPane.showMessageDialog(frame, message, "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
}