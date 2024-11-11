package swing.modules;
import javax.swing.*;
import java.awt.*;

public class JShapeCustom {
  private static JPanel shapeEdit(int x[], int y[], int points) {
    if (x.length != points || y.length != points) throw new IllegalArgumentException("The \"Px and Py\" parameter must have"+ points +"elements.");
    return new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillPolygon(x, y, points);
        g2.dispose();

        super.paintComponent(g);
      }
    };
  }
  private static JPanel retangleEdit(int radius[]) {
    if (radius.length != 2) throw new IllegalArgumentException("The \"radius\" parameter must have"+ 2 +"elements.");
    return new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius[0], radius[1]);
        g2.dispose();

        super.paintComponent(g);
      }
    };
  }

  public static JPanel Custom(int x, int y, int width, int height, int points, int Px[], int Py[]) {
    JPanel custom = shapeEdit(Px, Py, points);
    custom.setBorder(BorderFactory.createEmptyBorder());
    custom.setBounds(x, y, width, height);
    custom.setBackground(Color.GRAY);
    custom.setOpaque(false);
    return custom;
  }

  public static JPanel Cube(int x, int y, int width, int height, int radius[]) {
    JPanel custom = retangleEdit(radius);
    custom.setBorder(BorderFactory.createEmptyBorder());
    custom.setBounds(x, y, width, height);
    custom.setBackground(Color.GRAY);
    custom.setOpaque(false);
    return custom;
  }

  public static JPanel Cube(int x, int y, int width, int height) {
    JPanel custom = retangleEdit(new int[]{ 0, 0, 0, 0 });
    custom.setBorder(BorderFactory.createEmptyBorder());
    custom.setBounds(x, y, width, height);
    custom.setBackground(Color.GRAY);
    custom.setOpaque(false);
    return custom;
  }

  public static JPanel Triangle(int x, int y, int width, int height, int Px[], int Py[]) {
    if (Px.length != 3 || Py.length != 3) throw new IllegalArgumentException("The \"Px and Py\" parameter must have"+ 3 +"elements.");
    JPanel custom = shapeEdit(Px, Py, 3);
    custom.setBorder(BorderFactory.createEmptyBorder());
    custom.setBounds(x, y, width, height);
    custom.setBackground(Color.GRAY);
    custom.setOpaque(false);
    return custom;
  }

  public static JPanel Cicle(int x, int y, int sizeShape) {
    JPanel custom = retangleEdit(new int[]{ sizeShape, sizeShape });
    custom.setBorder(BorderFactory.createEmptyBorder());
    custom.setBounds(x, y, sizeShape, sizeShape);
    custom.setBackground(Color.GRAY);
    custom.setOpaque(false);
    return custom;
  }
}