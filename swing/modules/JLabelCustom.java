package swing.modules;
import javax.swing.*;
import java.awt.*;

public class JLabelCustom {
  private static JLabel labelEdit(int radius) {
    return new JLabel() {
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
  public static JLabel Label(String text, int x, int y, int width, int height, int size) {
    JLabel custom = new JLabel(text);
    custom.setBounds(x, y, width, height);
    custom.setForeground(Color.BLACK);
    custom.setFont(new Font(Font.MONOSPACED, Font.BOLD, size));
    return custom;
  }

  public static JLabel Label(String text, int x, int y, int width, int height, int size, int radius) {
    JLabel custom = labelEdit(radius);
    custom.setBounds(x, y, width, height);
    custom.setBackground(Color.WHITE);
    custom.setForeground(Color.BLACK);
    custom.setFont(new Font(Font.MONOSPACED, Font.BOLD, size));
    return custom;
  }

  public static JLabel Icon(ImageIcon filename, int x, int y, int width, int height) {
    filename = new ImageIcon(filename.getImage().getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH));
    JLabel custom = new JLabel(filename);
    custom.setBounds(x, y, width, height);
    custom.setForeground(Color.BLACK);
    if(filename.getImageLoadStatus() != MediaTracker.COMPLETE) { System.err.println("Failed in loading image."); }
    return custom;
  }

  public static JLabel Icon(ImageIcon filename, int x, int y, int width, int height, int radius) {
    filename = new ImageIcon(filename.getImage().getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH));
    JLabel custom = labelEdit(radius);
    custom.setIcon(filename);
    custom.setBackground(Color.WHITE);
    custom.setForeground(Color.BLACK);
    custom.setBounds(x, y, width, height);
    if(filename.getImageLoadStatus() != MediaTracker.COMPLETE) { System.err.println("Failed in loading image."); }
    return custom;
  }

}