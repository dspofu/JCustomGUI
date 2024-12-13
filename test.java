import JCustomGUI.modules.*;
import javax.swing.*;
import java.awt.*;

public class test extends Frame {
  public static void main(String[] args) {
    JFrame frame = new JFrameBuilder()
    .size(400, 600)
    .location()
    .build();

    JLabel text = new JLabelBuilder()
    .content("Login")
    .foreground(Color.GRAY)
    .size(120, 30)
    .location(140, 20)
    .build();

    JTextField inputName = new JFieldBuilder.Text()
    .size(200, 30)
    .location(100, 60)
    .build();
  
    JPasswordField inputPassword = new JFieldBuilder.Password()
    .size(200, 30)
    .location(100, 110)
    .build();

    frame.add(text);
    frame.add(inputName);
    frame.add(inputPassword);
    frame.setVisible(true);
  }
}