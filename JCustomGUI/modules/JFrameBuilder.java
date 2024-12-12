package JCustomGUI.modules;

import javax.swing.*;
import java.awt.*;

public class JFrameBuilder {
  private JFrame frame = new JFrame();
  private static boolean DEFAULT_TITLE = false;
  private static boolean DEFAULT_SIZE = false;
  private static boolean DEFAULT_OPERATION = false;

  public JFrameBuilder title(String title) {
    frame.setTitle(title);
    DEFAULT_TITLE = true;
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
    return this;
  }

  public JFrameBuilder background(Color color) {
    if (color != null) frame.getContentPane().setBackground(color);
    else frame.setBackground(color);
    return this;
  }

  public JFrameBuilder position(int x, int y) {
    if (DEFAULT_SIZE == false) frame.setBounds(x, y, 720, 550);
    else frame.setBounds(x, y, frame.getWidth(), frame.getHeight());
    return this;
  }

  public JFrameBuilder icon(String dir) {
    frame.setIconImage(new ImageIcon(System.getProperty("user.dir")+dir).getImage());
    return this;
  }
  // frame.setHorizontalAlignment(SwingConstants.CENTER)
  public JFrame build() {
    if (DEFAULT_TITLE == false) frame.setTitle("Sem título");
    if (DEFAULT_SIZE == false) frame.setSize(720, 550);
    if (DEFAULT_OPERATION == false) frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);
    return frame;
  }
}