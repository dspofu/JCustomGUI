package swing.modules;
import javax.swing.*;
import java.awt.*;

public class JPanelCustom {
  private static JPanel PanelEdit(int radius) {
    return new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius+5, radius+5);
        g2.dispose();

        super.paintComponent(g);
      }
    };
  }

  public static JPanel JCustom(int x, int y, int width, int height, int radius, Color background) {
    JPanel component = PanelEdit(radius);
    component.setBorder(BorderFactory.createEmptyBorder());
    component.setBounds(x, y, width, height);
    component.setBackground(background);
    component.setOpaque(false);
    return component;
  }

  public static JPanel JCustom(int x, int y, int width, int height, Color background) {
    JPanel component = new JPanel();
    component.setBounds(x, y, width, height);
    component.setBackground(background);
    return component;
  }

  public static JPanel JCustomMap(int MapX, int MapY, int MapWidth, int MapHeight, int radius, Color background) {
    return JCustom(MapX-2, MapY-2, MapWidth+4, MapHeight+4, radius, background);
  }
}