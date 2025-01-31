package JCustomGUI.modules;

import javax.swing.*;
import java.awt.*;

public class JLabelBuilder {
  private JLabel label = new JLabel();
  private static boolean DEFAULT_FONT = false;
  private static boolean DEFAULT_BACKGROUND = false;
  private static boolean DEFAULT_FOREGROUND = false;

  public JLabelBuilder content(String text) {
    label.setText(text);
    return this;
  }

  // public JLabelBuilder background(Color color) {
  //   label.setBackground(color);
  //   DEFAULT_BACKGROUND = true;
  //   return this;
  // }

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

  public JLabelBuilder location(int x, int y) {
    label.setLocation(x, y);
    return this;
  }

  public JLabelBuilder image(String dir) {
    ImageIcon image = new ImageIcon(new ImageIcon(dir).getImage().getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH));
    if (image.getImageLoadStatus() != MediaTracker.COMPLETE) System.err.println("Failed in loading image.");
    return this;
  }

  public JLabel build() {
    if (!DEFAULT_BACKGROUND) label.setBackground(Color.WHITE);
    if (!DEFAULT_FOREGROUND) label.setForeground(Color.BLACK);
    if (!DEFAULT_FONT) label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

    label.setSize(label.getPreferredSize());
    return label;
  }
}