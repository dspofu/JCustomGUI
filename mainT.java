import JCustomGUI.modules.*;
import javax.swing.*;
import java.awt.*;

public class mainT extends Frame {
  public static void main(String[] args) {
    JFrame frame = new JFrameBuilder()
    .size(400, 600)
    .build();

    JLabel text = new JLabelBuilder()
    .text("Testando")
    .size(120, 18)
    .position(160, 20)
    .build();

    frame.add(text);
    frame.setVisible(true);
  }
}