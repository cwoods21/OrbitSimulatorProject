import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.awt.*;


public class PlanetFrame extends JFrame
{
  public PlanetFrame()
  {
    super("Orbit Simulator");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    SettingsPanel settingspanel = new SettingsPanel();
    PlanetPanel planetpanel = new PlanetPanel(settingspanel);
    mainPanel.add(planetpanel, BorderLayout.CENTER);
    mainPanel.add(settingspanel, BorderLayout.EAST);
    setContentPane(mainPanel);
    pack();
    setVisible(true);
  }

  public static void main(String[] arguments)
  {
    PlanetFrame frame = new PlanetFrame();

  }
}
