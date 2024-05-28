package src.module.screens.config;
import javax.swing.*;
import java.awt.*;
// import javax.swing.border.LineBorder;

public class JButtonCustom {
  private static JButton buttonEdit() {
    return new JButton() {
    // Sobrescreve o método paintComponent para desenhar o fundo arredondado
      @Override
      protected void paintComponent(Graphics g) {
        // Prepara o gráfico para um desenho suave (anti-aliasing)
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10); // Cantos arredondados
        g2.dispose();

        super.paintComponent(g);
      }
    };
  }

  public static JButton Button(String text, int x, int y, int width, int height, int size, Color background, Color foreground) {
    JButton button = buttonEdit();

    button.setText(text);
    button.setBorder(BorderFactory.createEmptyBorder());
    button.setBounds(x, y, width, height);
    button.setFont(new Font(Font.MONOSPACED , Font.BOLD, size));
    button.setBackground(background);
    button.setForeground(foreground);
    button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    button.setFocusPainted(false);
    button.setContentAreaFilled(false);
    button.setOpaque(false);
    return button;
  }

  public static JButton Button(String text, int x, int y, int width, int height, int size) {
    return Button(text, x, y, width, height, size, Color.GRAY, Color.WHITE);
  }

  public static JButton Button(ImageIcon filename, int x, int y, int width, int height, Color background, Color foreground) {
    JButton button = buttonEdit();
    filename = new ImageIcon(filename.getImage().getScaledInstance(width/2, width/2,  java.awt.Image.SCALE_SMOOTH));
    button.setIcon(filename);
    button.setBorder(BorderFactory.createEmptyBorder());
    button.setBounds(x, y, width, height);
    button.setBackground(background);
    button.setForeground(foreground);
    button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    button.setFocusPainted(false); // Desativa a pintura do foco do botão para manter a estética
    button.setContentAreaFilled(false);
    if(filename.getImageLoadStatus() != MediaTracker.COMPLETE) { System.err.println("Failed in loading image."); }
    return button;
  }

  public static JButton Button(ImageIcon filename, int x, int y, int width, int height) {
    return Button(filename, x, y, width, height, Color.GRAY, Color.WHITE);
  }
}