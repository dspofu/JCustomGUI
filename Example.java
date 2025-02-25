import JCustomGUI.modules.*;
import javax.swing.*;
import java.awt.*;

public class Example extends Frame {
  public static void main(String[] args) {
    JFrame frame = new JFrameBuilder()
    .size(400, 600)
    .location()
    .build();

    JLabel text = new JLabelBuilder()
    .content("Login")
    .foreground(Color.GRAY)
    .font(new Font(Font.MONOSPACED, Font.BOLD, 30))
    .background(Color.BLACK, 10)
    .location(150, 5)
    .build();

    JTextField inputName = new JInputBuilder.Text()
    .size(200, 30)
    .location(100, 60)
    .build();
  
    JPasswordField inputPassword = new JInputBuilder.Password()
    .size(200, 30)
    .location(100, 110)
    .build();


    JPanel panel = new JPanelBuilder(4)
    .build();

    frame.add(text);
    frame.add(inputName);
    frame.add(inputPassword);
    frame.add(panel);
    frame.setVisible(true);
  }
}