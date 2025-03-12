package JCustomGUI.modules;

import javax.swing.*;
import java.awt.*;

public class JFrameBuilder {
  private JFrame frame = new JFrame();
  private boolean isSize = false;
  private boolean isResizeble = false;
  private boolean isOperation = false;
  // private boolean isVisible = false;

  public JFrameBuilder title(String title) {
    frame.setTitle(title);
    return this;
  }

  public JFrameBuilder size(int width, int height) {
    frame.setSize(width, height);
    isSize = true;
    return this;
  }

  public JFrameBuilder closeOperation(int operation) {
    frame.setDefaultCloseOperation(operation);
    isOperation = true;
    return this;
  }

  public JFrameBuilder resizable(boolean resizable) {
    frame.setResizable(resizable);
    isResizeble = true;
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

  // public JFrameBuilder visible(boolean visible) {
  //   frame.setVisible(visible);
  //   isVisible = true;
  //   return this;
  // }

  public JFrameBuilder icon(String dir) {
    frame.setIconImage(new ImageIcon(System.getProperty("user.dir")+dir).getImage());
    return this;
  }

  public JFrame build() {
    if (!isSize)
      try {
        throw new IllegalAccessException("The 'size' method was not called correctly!");
      } catch (IllegalAccessException e) { e.printStackTrace(); }
    if (!isOperation) frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(isResizeble);
    frame.setLayout(null);
    // if (isVisible == false) frame.setVisible(true);
    return frame;
  }
}