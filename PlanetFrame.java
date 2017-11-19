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
    PlanetPanel mainInstance = new PlanetPanel();
    SettingsPanel otherInstance = new SettingsPanel();
    setContentPane(otherInstance);
    setContentPane(mainInstance);

    pack();
    setVisible(true);
  }

  public static void main(String[] arguments)
  {
    PlanetFrame frame = new PlanetFrame();

  }
}
