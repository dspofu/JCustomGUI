import JCustomGUI.modules.*;
import javax.swing.*;
import java.awt.*;

public class mainT extends Frame {
  public static void main(String[] args) {
    JFrame frame = new JFrameBuilder()
    .size(400, 600)
    .location()
    .build();

    JLabel text = new JLabelBuilder()
    .text("Testando")
    .background(Color.GREEN)
    .foreground(Color.BLUE)
    .size(120, 18)
    .location(160, 20)
    .build();

    JFieldText inputName = new ;


    frame.add(text);
    frame.setVisible(true);
  }
}