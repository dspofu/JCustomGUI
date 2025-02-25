package JCustomGUI.modules;

import javax.swing.*;
import java.awt.*;

public class JPanelBuilder {
  private JPanel panel = new JPanel();
  private Color BACKGROUND = Color.GRAY;
  private int DEFAULT_BORDER = 4;
  private int RADIUS;
  private int x;
  private int y;

  // public JPanel 
  
  public JPanelBuilder(int borders) {
    this.DEFAULT_BORDER=borders>=0?borders:0;
  }
  
    public JPanelBuilder() {
      new JPanelBuilder(4);
    }
  
  // public static JPanel JCustom(int x, int y, int width, int height, Color background) {
  //   JPanel component = new JPanel();
  //   component.setBounds(x, y, width, height);
  //   component.setBackground(background);
  //   return component;
  // }

  // public static JPanel JCustomMap(int MapX, int MapY, int MapWidth, int MapHeight, int radius, Color background) {
  //   return JCustom(MapX-2, MapY-2, MapWidth+4, MapHeight+4, radius, background);
  // }

  public JPanel build() {
    if (this.DEFAULT_BORDER == 4) {
      JPanel defaultPanel = panel;
      JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
          Graphics2D g2 = (Graphics2D) g.create();
          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          g2.setColor(getBackground());
          g2.fillRoundRect(0, 0, getWidth(), getHeight(), RADIUS + 5, RADIUS + 5);
          g2.dispose();

          super.paintComponent(g);
        }
      };
      panel.setBorder(BorderFactory.createEmptyBorder());
      panel.setBackground(defaultPanel.getBackground());
      panel.setBounds(defaultPanel.getBounds());
      panel.setOpaque(false);
    }
    return panel;
  }
}