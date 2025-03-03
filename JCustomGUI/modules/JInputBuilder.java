package JCustomGUI.modules;

import javax.swing.*;
import java.awt.*;

public class JInputBuilder {
  // private static JTextField TextEdit(int radius) {
  // return new JTextField() {
  // @Override
  // protected void paintComponent(Graphics g) {
  // Graphics2D g2 = (Graphics2D) g.create();
  // g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
  // RenderingHints.VALUE_ANTIALIAS_ON);
  // g2.setColor(getBackground());
  // g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
  // g2.dispose();

  // super.paintComponent(g);
  // }
  // };
  // }

  // private static JPasswordField PassEdit(int radius) {
  // return new JPasswordField() {
  // @Override
  // protected void paintComponent(Graphics g) {
  // Graphics2D g2 = (Graphics2D) g.create();
  // g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
  // RenderingHints.VALUE_ANTIALIAS_ON);
  // g2.setColor(getBackground());
  // g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
  // g2.dispose();

  // super.paintComponent(g);
  // }
  // };
  // }

  public static class Text {
    private JTextField text = new JTextField();
    private static boolean isFont = false;
    private boolean isBackground = false;
    // private int DEFAULT_RADIUS;
    private boolean isForeground = false;

    public Text background(Color color, Integer radius) {
      // DEFAULT_RADIUS = (radius != null && radius >= 0) ? radius : 10;
      text.setBackground(color);
      isBackground = true;
      return this;
    }

    public Text background(Color color) {
      return background(color, 10);
    }

    public Text foreground(Color color) {
      text.setForeground(color);
      isForeground = true;
      return this;
    }

    public Text size(int width, int height) {
      text.setSize(width, height);
      return this;
    }

    // public Text placeholder(String placeholder) {
    //   PLACEHOLDER = placeholder;
    //   return this;
    // }

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
      if (!isFont) text.setFont(new Font(Font.SANS_SERIF, Font.BOLD, text.getHeight()-4));
      if (!isBackground) text.setBackground(Color.WHITE);
      if (!isForeground) text.setForeground(Color.GRAY);
      // if (!PLACEHOLDER.isEmpty()) OnFocusEventHelper.setOnFocusText();
      text.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
      return text;
    }
  }

  public static class Password {
    private JPasswordField password = new JPasswordField();
    private static boolean isFont = false;
    private boolean isBackground = false;
    // private int DEFAULT_RADIUS;
    private boolean isForeground = false;

    public Password background(Color color, Integer radius) {
      // DEFAULT_RADIUS = (radius != null && radius >= 0) ? radius : 10;
      password.setBackground(color);
      isBackground = true;
      return this;
    }

    public Password background(Color color) {
      return background(color, 10);
    }

    public Password foreground(Color color) {
      password.setForeground(color);
      isForeground = true;
      return this;
    }

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
      if (!isFont) password.setFont(new Font(Font.SANS_SERIF, Font.BOLD, password.getHeight()-4));
      if (!isBackground) password.setBackground(Color.WHITE);
      if (!isForeground) password.setForeground(Color.BLACK);
      // if (!PLACEHOLDER.isEmpty()) OnFocusEventHelper.setOnFocusText();
      password.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
      return password;
    }
  }

  public static class TextArea {
    private JTextArea textArea = new JTextArea();
    private JScrollPane scrollPane;
    private boolean isFont = false;
    private boolean isBackground = false;
    private int DEFAULT_RADIUS;
    private boolean isForeground = false;
    private boolean isScroll = false;

    public TextArea background(Color color) {
      textArea.setBackground(color);
      isBackground = true;
      return this;
    }

    public TextArea foreground(Color color) {
      textArea.setForeground(color);
      isForeground = true;
      return this;
    }

    public TextArea borderRadius(Integer radius) {
      DEFAULT_RADIUS=(radius!=null && radius>=0)?radius:10;
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

    public TextArea scroll(boolean editable, boolean lineWrap, boolean textWrapLine) {
      textArea.setEditable(editable);
      textArea.setLineWrap(lineWrap);
      textArea.setWrapStyleWord(textWrapLine);
      scrollPane = new JScrollPane(textArea);
      scrollPane.setBounds(textArea.getX(), textArea.getY(), textArea.getWidth(), textArea.getHeight());
      isScroll = true;
      return this;
    }
    public TextArea scroll() {
      scroll(true, true, true);
      return this;
    }

    public JComponent build() {
      textArea.setBorder(BorderFactory.createEmptyBorder());
      if (!isFont) textArea.setFont(new Font(Font.SANS_SERIF, Font.BOLD, textArea.getHeight()<300&&textArea.getHeight()>20?15:textArea.getHeight()/30));
      if (!isBackground) textArea.setBackground(Color.WHITE);
      if (!isForeground) textArea.setForeground(Color.GRAY);
      textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

      if (DEFAULT_RADIUS>=0) {
        JTextArea defaultArea = textArea;
        textArea = new JTextArea() {
          @Override
          protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), DEFAULT_RADIUS, DEFAULT_RADIUS);
            g2.dispose();
            super.paintComponent(g);
          }
        };
        textArea.setOpaque(false);
        textArea.setFont(defaultArea.getFont());
        textArea.setForeground(defaultArea.getForeground());
        textArea.setBackground(defaultArea.getBackground());
        textArea.setBounds(defaultArea.getBounds());
        if (isScroll) scrollPane.setViewportView(textArea);
      }
      if (isScroll) return scrollPane;
      else return textArea;
    }
  }
}