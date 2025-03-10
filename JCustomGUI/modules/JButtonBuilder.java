package JCustomGUI.modules;
import javax.swing.*;
import java.awt.*;

public class JButtonBuilder {
  private JButton button = new JButton();
  private int RADIUS;
  private boolean isBackground;
  private boolean isForeground;
  private boolean isFont;
  private boolean isCursor;
  
  public JButtonBuilder location(int x, int y) {
    button.setLocation(x, y);
    return this;
  }

  public JButtonBuilder size(int width, int height) {
    button.setSize(width, height);
    return this;
  }
  
  public JButtonBuilder background(Color color) {
    isBackground=true;
    button.setBackground(color);
    return this;
  }
  
  public JButtonBuilder foreground(Color color) {
    isForeground=true;
    button.setForeground(color);
    return this;
  }
  
  public JButtonBuilder cursor(int pointer) {
    isForeground=true;
    button.setCursor(new Cursor(pointer));
    return this;
  }

  public JButtonBuilder font(Font font) {
    button.setFont(font);
    isFont = true;
    return this;
  }

  public JButtonBuilder text(String text) {
    button.setText(text);
    return this;
  }
  public JButtonBuilder icon(ImageIcon dir) {
    if(dir.getImageLoadStatus() != MediaTracker.COMPLETE) { System.err.println("Failed in loading image.\nParam: " + dir); }
    button.setIcon(new ImageIcon(dir.getImage().getScaledInstance(button.getWidth()/2, button.getWidth()/2,  java.awt.Image.SCALE_SMOOTH)));
    return this;
  }

  public JButtonBuilder borderRadius(Integer radius) {
    RADIUS=(radius!=null && radius>=0)?radius:10;
    return this;
  }

  public JButton build() {
    if (!isBackground) button.setBackground(Color.GRAY);
    if (!isForeground) button.setForeground(Color.WHITE);
    if (!isCursor) button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    if (!isFont) button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, button.getHeight()<300&&button.getHeight()>20?15:button.getHeight()/30));
    if (RADIUS>0) {
      JButton defaultButton = button;
      button = new JButton() {
        @Override
        protected void paintComponent(Graphics g) {
          Graphics2D g2 = (Graphics2D) g.create();
          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          g2.setColor(getBackground());
          g2.fillRoundRect(0, 0, getWidth(), getHeight(), RADIUS, RADIUS);
          g2.dispose();
          super.paintComponent(g);
        }
      };
      button.setIcon(defaultButton.getIcon());
      button.setText(defaultButton.getText());
      button.setFont(defaultButton.getFont());
      button.setBounds(defaultButton.getBounds());
      button.setBackground(defaultButton.getBackground());
      button.setForeground(defaultButton.getForeground());
      button.setBorder(BorderFactory.createEmptyBorder());
      button.setCursor(defaultButton.getCursor());
      button.setFocusPainted(false);
      button.setContentAreaFilled(false);
    }
    return button;
  }
}