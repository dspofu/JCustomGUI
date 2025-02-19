package JCustomGUI.modules;

import javax.swing.*;
import java.awt.*;

public class JLabelBuilder {
  private JLabel label = new JLabel();
  private static boolean DEFAULT_FONT = false;
  private static boolean DEFAULT_BACKGROUND = false;
  private static int BACKGROUND_RADIUS;
  private static boolean DEFAULT_FOREGROUND = false;

  public JLabelBuilder content(String text) {
    label.setText(text);
    return this;
  }

  public JLabelBuilder background(Color color, Integer radius) {
    BACKGROUND_RADIUS=radius<0?10:radius;
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
    if (!DEFAULT_FOREGROUND) label.setForeground(Color.BLACK);
    if (!DEFAULT_FONT) label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    label.setSize(label.getPreferredSize());

    if (DEFAULT_BACKGROUND) {
      JLabel original = label;
      label = new JLabel() {
        @Override
        protected void paintComponent(Graphics g) {
          Graphics2D g2 = (Graphics2D) g.create();
          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          g2.setColor(getBackground());
          g2.fillRoundRect(0, 0, getWidth(), getHeight(), BACKGROUND_RADIUS, BACKGROUND_RADIUS);
          g2.dispose();
          super.paintComponent(g);
        }
      };
      label.setText(original.getText());
      label.setIcon(original.getIcon());
      label.setFont(original.getFont());
      label.setForeground(original.getForeground());
      label.setBackground(original.getBackground());
      label.setBounds(original.getBounds());
    }

    return label;
  }
}