package src.module.screens.config;
import javax.swing.*;
import java.awt.*;

public class JFrameCustom {
  public static JFrame Frame(String title, int closeOperation, int width, int height, boolean resizable, Component relativeTo, Container contentPane, Color color) {
    JFrame frame = new JFrame(title);
    frame.setDefaultCloseOperation(closeOperation);
    frame.setSize(width, height);
    frame.setResizable(resizable);
    frame.setLocationRelativeTo(relativeTo);
    frame.setContentPane(contentPane);
    if(color!=null) frame.getContentPane().setBackground(color);
    return frame;
  }

  public static JFrame Frame(JFrame frame, String title, int closeOperation, int width, int height, boolean resizable, Component relativeTo, Container contentPane, Color color) {
    frame.setTitle(title);
    frame.setDefaultCloseOperation(closeOperation);
    frame.setSize(width, height);
    frame.setResizable(resizable);
    frame.setLocationRelativeTo(relativeTo);
    frame.setContentPane(contentPane);
    if(color!=null) frame.getContentPane().setBackground(color);
    return frame;
  }
}
