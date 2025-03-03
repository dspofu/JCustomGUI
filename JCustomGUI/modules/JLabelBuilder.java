package JCustomGUI.modules;

import javax.swing.*;
import java.awt.*;

public class JLabelBuilder {
  private JLabel label = new JLabel();
  private boolean isFont = false;
  private boolean isBackground = false;
  private int DEFAULT_RADIUS;
  private boolean isForeground = false;
  private int paddingX = 0;
  private int paddingY = 0;
  private String text;
  private int x;
  private int y;

  public JLabelBuilder content(String text) {
    label.setText(text);
    this.text=text;
    return this;
  }

  public JLabelBuilder padding(int x, int y) {
    paddingX = x;
    paddingY = y;
    return this;
  }
  
  public JLabelBuilder padding(int size) {
    return padding(size, size);
  }

  public JLabelBuilder borderRadius(Integer radius) {
    DEFAULT_RADIUS=(radius!=null && radius>=0)?radius:10;
    return this;
  }

  public JLabelBuilder background(Color color) {
    label.setBackground(color);
    isBackground = true;
    return this;
  }

  public JLabelBuilder foreground(Color color) {
    label.setForeground(color);
    isForeground = true;
    return this;
  }

  public JLabelBuilder font(Font font) {
    label.setFont(font);
    isFont = true;
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
    if (!isForeground) label.setForeground(Color.BLACK);
    if (!isFont) label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    label.setSize(label.getPreferredSize());
  
    if (!this.text.isEmpty() && this.x >= 0 && this.y >= 0) {
      FontMetrics metrics = label.getFontMetrics(label.getFont());
      label.setBounds(this.x - paddingX/2, this.y, metrics.stringWidth(this.text) + 2 + paddingX, metrics.getHeight()+paddingY);
    }
    
    if (isBackground) {
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
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setVerticalAlignment(SwingConstants.CENTER);
    }
    return label;
  }
}