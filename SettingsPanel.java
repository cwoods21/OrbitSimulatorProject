import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
public class SettingsPanel extends JPanel
{
  JTextField xVelocity = new JTextField(20);
  JTextField yVelocity = new JTextField(20);
  public SettingsPanel()
  {
    this.setLayout(new GridBagLayout());
    this.setPreferredSize(new Dimension(200, 540));
    this.add(xVelocity);
    this.add(yVelocity);
  }
}
