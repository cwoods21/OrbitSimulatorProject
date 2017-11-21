import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
public class SettingsPanel extends JPanel
{
  JTextField xVelocity = new JTextField(10);
  JLabel xVelLabel = new JLabel("X velocity: ");
  JTextField yVelocity = new JTextField(10);
  JLabel yVelLabel = new JLabel("Y velocity: ");
  JTextField mass = new JTextField(10);
  JLabel massLabel = new JLabel("Mass: ");
  JTextField radius = new JTextField(10);
  JLabel radiusLabel = new JLabel("Radius: ");
  GridBagConstraints c;
  public SettingsPanel()
  {
    this.setLayout(new GridBagLayout());
    c = new GridBagConstraints();
    this.setPreferredSize(new Dimension(200, 540));
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0; c.gridy = 0; c.weightx = .5; c.ipadx = 0; c.ipady = 5;
    this.add(xVelLabel, c);
    c.gridx = 1; c.ipadx = 10;
    this.add(xVelocity, c);
    c.gridx = 0; c.gridy = 1; c.ipadx = 0;
    this.add(yVelLabel, c);
    c.gridx = 1; c.ipadx = 10;
    this.add(yVelocity, c);
    c.gridx = 0; c.gridy = 2; c.ipadx = 0;
    this.add(massLabel, c);
    c.gridx = 1; c.ipadx = 10;
    this.add(mass, c);
    c.gridx = 0; c.gridy = 3; c.ipadx = 0;
    this.add(radiusLabel, c);
    c.gridx = 1; c.ipadx = 10;
    this.add(radius, c);


  }


  public Vector getVelocityVector()
  {
    double xValue = -1;
    double yValue = -1;
    try
    {
      xValue = Double.parseDouble(xVelocity.getText());
      yValue = Double.parseDouble(yVelocity.getText());
    }
    catch(NumberFormatException nfe)
    {
      JOptionPane.showMessageDialog(null, "Improper Velocity Parameters");
      return null;
    }
    Vector toReturn = new Vector(xValue, yValue);
    return toReturn;
  }
  public double getMass()
  {
    double massValue = -1;
    try
    {
      massValue = Double.parseDouble(mass.getText());
    }
    catch(NumberFormatException nfe)
    {
      JOptionPane.showMessageDialog(null, "Improper Mass Parameter");
    }
    return massValue;
  }
  public double getRadius()
  {
    double radiusValue = -1;
    try
    {
      radiusValue = Double.parseDouble(radius.getText());
    }
    catch(NumberFormatException nfe)
    {
      JOptionPane.showMessageDialog(null, "Improper Radius Paramater");
    }
    return radiusValue;
  }

}
