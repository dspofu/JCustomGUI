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
    .location(150, 5)
    .build();
    
    JTextField inputName = new JInputBuilder.Text()
    .size(200, 30)
    .location(100, 60)
    .font(new Font(Font.SANS_SERIF, Font.BOLD, 15))
    .build();

    JPasswordField inputPassword = new JInputBuilder.Password()
    .size(200, 30)
    .location(100, 110)
    .build();

    JComponent area = new JInputBuilder.TextArea()
    .size(200, 120)
    .location(100, 200)
    .borderRadius(20)
    .background(Color.decode("#D0F0F0"))
    .scroll(true, true, true)
    .build();

    JButton button = new JButtonBuilder()
    .location(160, 450)
    .size(80, 50)
    .text("Send")
    .borderRadius(10)
    .build();

    // JPanel panel = new JPanelBuilder(4)
    // .build();

    frame.add(text);
    frame.add(inputName);
    frame.add(inputPassword);
    frame.add(area);
    frame.add(button);
    // frame.add(panel);
    frame.setVisible(true);
  }
}