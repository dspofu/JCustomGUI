package JCustomGUI.modules;

import javax.swing.*;
import java.awt.*;

public class JLabelBuilder {
  private JLabel label = new JLabel();
  private static boolean DEFAULT_FONT = false;
  private static boolean DEFAULT_BACKGROUND = false;
  private static boolean DEFAULT_FOREGROUND = false;
  // private static JLabel labelEdit(int radius) {
  //   return new JLabel() {
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
  public JLabelBuilder text(String text) {
    label.setText(text);
    return this;
  }

  public JLabelBuilder background(Color color) {
    label.setBackground(color);
    DEFAULT_BACKGROUND = true;
    return this;
  }

  public JLabelBuilder foreground(Color color) {
    label.setForeground(color);
    DEFAULT_FOREGROUND = true;
    return this;
  }
  
  public JLabelBuilder font(Font font) {
    label.setFont(font);
    DEFAULT_FONT = true;
    return this;
  }
  
  public JLabelBuilder size(int width, int height) {
    label.setSize(width, height);
    return this;
  }

  public JLabelBuilder location(int x, int y) {
    label.setLocation(x, y);
    return this;
  }

  public JLabelBuilder image(String dir) {
    ImageIcon image = new ImageIcon(new ImageIcon(dir).getImage().getScaledInstance(label.getWidth(), label.getHeight(),  java.awt.Image.SCALE_SMOOTH));
    if (image.getImageLoadStatus() != MediaTracker.COMPLETE) { System.err.println("Failed in loading image."); }
    return this;
  }

  public JLabel build() {
    if (DEFAULT_BACKGROUND == false) label.setBackground(Color.WHITE);
    if (DEFAULT_FOREGROUND == false) label.setForeground(Color.BLACK);
    if (DEFAULT_FONT == false) label.setFont(new Font(Font.MONOSPACED, Font.BOLD, label.getHeight()));
    return label;
  }
}