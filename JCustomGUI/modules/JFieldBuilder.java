package JCustomGUI.modules;

import javax.swing.*;
import java.awt.*;

public class JFieldBuilder {
  // private static JTextField TextEdit(int radius) {
    //   return new JTextField() {
  //     @Override
  //     protected void paintComponent(Graphics g) {
    //       Graphics2D g2 = (Graphics2D) g.create();
  //       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
  //       g2.setColor(getBackground());
  //       g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
  //       g2.dispose();
  
  //       super.paintComponent(g);
  //     }
  //   };
  // }
  
  // private static JPasswordField PassEdit(int radius) {
    //   return new JPasswordField() {
      //     @Override
      //     protected void paintComponent(Graphics g) {
        //       Graphics2D g2 = (Graphics2D) g.create();
        //       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //       g2.setColor(getBackground());
        //       g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        //       g2.dispose();
        
        //       super.paintComponent(g);
        //     }
        //   };
        // }
        
  public static class Text  {
    private JTextField text = new JTextField();
    private static boolean DEFAULT_FONT = false;

    public Text size(int width, int height) {
      text.setSize(width, height);
      return this;
    }

    public Text location(int x, int y) {
      text.setLocation(x, y);
      return this;
    }

    public Text location(Font font) {
      text.setFont(font);
      DEFAULT_FONT = true;
      return this;
    }

    // public Text border(int radius) {
    //   text.setBorder(BorderFactory.createEmptyBorder());
    //   text.setOpaque(false);
    //   return this;
    // }

    public JTextField build() {
      if (DEFAULT_FONT == false) text.setFont(new Font(Font.SANS_SERIF, Font.BOLD, text.getHeight()/2));
      text.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, false));
      return text;
    }
  }

  public static class Password {
    private JPasswordField password = new JPasswordField();
    private static boolean DEFAULT_FONT = false;

    public Password size(int width, int height) {
      password.setSize(width, height);
      return this;
    }

    public Password location(int x, int y) {
      password.setLocation(x, y);
      return this;
    }

    public Password location(Font font) {
      password.setFont(font);
      DEFAULT_FONT = true;
      return this;
    }

    // public Password border(int radius) {
    //   Password.setBorder(BorderFactory.createEmptyBorder());
    //   Password.setOpaque(false);
    //   return this;
    // }

    public JPasswordField build() {
      if (DEFAULT_FONT == false) password.setFont(new Font(Font.SANS_SERIF, Font.BOLD, password.getHeight()));
      password.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, false));
      return password;
    }
  }
}