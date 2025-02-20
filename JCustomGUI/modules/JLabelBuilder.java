package JCustomGUI.modules;

import javax.swing.*;
import java.awt.*;

public class JLabelBuilder {
  private JLabel label = new JLabel();
  private boolean DEFAULT_FONT = false;
  private boolean DEFAULT_BACKGROUND = false;
  private int DEFAULT_RADIUS;
  private boolean DEFAULT_FOREGROUND = false;
  private String text;
  private int x;
  private int y;

  public JLabelBuilder content(String text) {
    label.setText(text);
    this.text=text;
    return this;
  }

  public JLabelBuilder background(Color color, Integer radius) {
    DEFAULT_RADIUS=(radius!=null && radius>=0)?radius:10;
    label.setBackground(color);
    DEFAULT_BACKGROUND = true;
    return this;
  }

  public JLabelBuilder background(Color color) {
    return background(color, 10);
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
    this.x=x;
    this.y=y;
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

    if (!this.text.isEmpty() && this.x>=0 && this.y>=0) {
      FontMetrics metrics = label.getFontMetrics(label.getFont());
      label.setBounds(this.x, this.y, metrics.stringWidth(this.text), metrics.getHeight());
    }

    if (DEFAULT_BACKGROUND) {
      JLabel defaultLabel = label;
      label = new JLabel() {
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
      label.setText(defaultLabel.getText());
      label.setIcon(defaultLabel.getIcon());
      label.setFont(defaultLabel.getFont());
      label.setForeground(defaultLabel.getForeground());
      label.setBackground(defaultLabel.getBackground());
      label.setBounds(defaultLabel.getBounds());
    }
    return label;
  }
}