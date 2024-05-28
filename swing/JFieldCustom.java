package src.module.screens.config;

import javax.swing.*;
import java.awt.*;

public class JFieldCustom {
  private static JTextField TextEdit(int radius) {
    return new JTextField() {
      @Override
      protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.dispose();

        super.paintComponent(g);
      }
    };
  }

  private static JPasswordField PassEdit(int radius) {
    return new JPasswordField() {
      @Override
      protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.dispose();

        super.paintComponent(g);
      }
    };
  }

  public static JTextField JITextCustom(int x, int y, int width, int height, int size, int radius, Color background, Color foreground) {
    JTextField inputUser = TextEdit(radius);
    inputUser.setBorder(BorderFactory.createEmptyBorder());
    inputUser.setBounds(x, y, width, height);
    inputUser.setFont(new Font(Font.SANS_SERIF, Font.BOLD, size));
    inputUser.setOpaque(false);
    return inputUser;
  }

  public static JTextField JITextCustom(int x, int y, int width, int height, int size) {
    JTextField inputUser = new JTextField();
    inputUser.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, false));
    inputUser.setBounds(x, y, width, height);
    inputUser.setFont(new Font(Font.SANS_SERIF, Font.BOLD, size));
    return inputUser;
  }

  public static JPasswordField JIPassCustom(int x, int y, int width, int height, int size, int radius, Color bacground, Color foreground) {
    JPasswordField inputPassword = PassEdit(radius);
    inputPassword.setBorder(BorderFactory.createEmptyBorder());
    inputPassword.setBounds(x, y, width, height);
    inputPassword.setFont(new Font(Font.SANS_SERIF, Font.BOLD, size));
    inputPassword.setOpaque(false);
    return inputPassword;
  }

  public static JPasswordField JIPassCustom(int x, int y, int width, int height, int size) {
    JPasswordField inputPassword = new JPasswordField();
    inputPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, false));
    inputPassword.setBounds(x, y, width, height);
    inputPassword.setFont(new Font(Font.SANS_SERIF, Font.BOLD, size));
    return inputPassword;
  }
}