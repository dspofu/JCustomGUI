package src.module.screens.config;
import javax.swing.*;
import java.awt.*;

public class JLabelCustom {
  public static JLabel Label(String text, int x, int y, int width, int height, int size, Color color) {
    JLabel labelUser = new JLabel(text);
    labelUser.setBounds(x, y, width, height);
    labelUser.setForeground(color);
    labelUser.setFont(new Font(Font.MONOSPACED, Font.BOLD, size));
    return labelUser;
  }

  public static JLabel Label(String text, int x, int y, int width, int height, int size) {
    return Label(text, x, y, width, height, size, Color.BLACK);
  }

  public static JLabel Icon(ImageIcon filename, int x, int y, int width, int height) {
    filename = new ImageIcon(filename.getImage().getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH));
    JLabel labelUser = new JLabel(filename);
    labelUser.setBounds(x, y, width, height);
    if(filename.getImageLoadStatus() != MediaTracker.COMPLETE) { System.err.println("Failed in loading image."); }
    return labelUser;
  }

  public class Label {
  }
}