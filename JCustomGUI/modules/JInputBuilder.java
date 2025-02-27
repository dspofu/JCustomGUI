package JCustomGUI.modules;

import javax.swing.*;
import java.awt.*;

public class JInputBuilder {
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
    private static boolean isFont = false;

    public Text size(int width, int height) {
      text.setSize(width, height);
      return this;
    }

    public Text location(int x, int y) {
      text.setLocation(x, y);
      return this;
    }

    public Text font(Font font) {
      text.setFont(font);
      isFont = true;
      return this;
    }

    public JTextField build() {
      if (isFont == false) text.setFont(new Font(Font.SANS_SERIF, Font.BOLD, text.getHeight()/2));
      text.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, false));
      return text;
    }
  }

  public static class Password {
    private JPasswordField password = new JPasswordField();
    private static boolean isFont = false;

    public Password size(int width, int height) {
      password.setSize(width, height);
      return this;
    }

    public Password location(int x, int y) {
      password.setLocation(x, y);
      return this;
    }

    public Password font(Font font) {
      password.setFont(font);
      isFont = true;
      return this;
    }

    public JPasswordField build() {
      if (isFont == false) password.setFont(new Font(Font.SANS_SERIF, Font.BOLD, password.getHeight()));
      password.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, false));
      return password;
    }
  }
  public static class TextArea {
    private JTextArea textArea = new JTextArea();
    private static boolean isFont = false;
    private boolean isBackground = false;
    private int DEFAULT_RADIUS;
    private boolean isForeground = false;
    private String isPlaceholder;

    public TextArea background(Color color, Integer radius) { 
      DEFAULT_RADIUS=(radius!=null && radius>=0)?radius:10;
      textArea.setBackground(color);
      isBackground = true;
      return this;
    }

    public TextArea background(Color color) {
      return background(color, 10);
    }

    public TextArea foreground(Color color) {
      textArea.setForeground(color);
      isForeground = true;
      return this;
    }

    public TextArea placeholder(Color color) {
      textArea.setForeground(color);
      isForeground = true;
      return this;
    }

    public TextArea size(int width, int height) {
      textArea.setSize(width, height);
      return this;
    }

    public TextArea location(int x, int y) {
      textArea.setLocation(x, y);
      return this;
    }

    public TextArea font(Font font) {
      textArea.setFont(font);
      isFont = true;
      return this;
    }

    public TextArea scroll(boolean editable, boolean lineWrap) {
      textArea.setEditable(editable);
      textArea.setLineWrap(lineWrap);
      textArea.setWrapStyleWord(true);
      JScrollPane scrollPane = new JScrollPane(textArea);
      scrollPane.setBounds(40, 60, 720, 400);
      return this;
    }

    public JTextArea build() {
      if (!isFont) textArea.setFont(new Font(Font.SANS_SERIF, Font.BOLD, textArea.getHeight()));
      if (!isBackground) textArea.setBackground(Color.GRAY);
      if (!isForeground) textArea.setBackground(Color.WHITE);
      textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, false));
      return textArea;
    }
  }
}