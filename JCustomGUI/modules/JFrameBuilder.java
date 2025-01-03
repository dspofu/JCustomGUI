package JCustomGUI.modules;

import javax.swing.*;
import java.awt.*;

public class JFrameBuilder {
  private JFrame frame = new JFrame();
  private static boolean DEFAULT_SIZE = false;
  private static boolean DEFAULT_RESIZABLE = false;
  private static boolean DEFAULT_OPERATION = false;

  public JFrameBuilder title(String title) {
    frame.setTitle(title);
    return this;
  }

  public JFrameBuilder size(int width, int height) {
    frame.setSize(width, height);
    DEFAULT_SIZE = true;
    return this;
  }

  public JFrameBuilder closeOperation(int operation) {
    frame.setDefaultCloseOperation(operation);
    DEFAULT_OPERATION = true;
    return this;
  }

  public JFrameBuilder resizable(boolean resizable) {
    frame.setResizable(resizable);
    DEFAULT_RESIZABLE = true;
    return this;
  }

  public JFrameBuilder background(Color color) {
    if (color != null) frame.getContentPane().setBackground(color);
    else frame.setBackground(color);
    return this;
  }

  public JFrameBuilder location(int x, int y) {
    frame.setLocation(x, y);
    return this;
  }

  public JFrameBuilder location() {
    frame.setLocationRelativeTo(null);
    return this;
  }

  public JFrameBuilder icon(String dir) {
    frame.setIconImage(new ImageIcon(System.getProperty("user.dir")+dir).getImage());
    return this;
  }

  public JFrame build() {
    if (DEFAULT_SIZE == false)
      try {
        throw new IllegalAccessException("The 'size' method was not called correctly!");
      } catch (IllegalAccessException e) { e.printStackTrace(); }
    if (DEFAULT_OPERATION == false) frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(DEFAULT_RESIZABLE);
    frame.setLayout(null);
    return frame;
  }
}