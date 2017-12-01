import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class PlanetPanel extends JPanel implements MouseListener
{
  public static final int WIDTH = 1000;
  public static final int HEIGHT = 540;
  public static final int FPS = 200;
  public SettingsPanel settingspanel;
  World world;

  class Runner implements Runnable
  {
        public void run(){
            while(true){
                world.updatePlanets();
                repaint();
                try{
                    Thread.sleep(1000/FPS);
                }
                catch(InterruptedException e){}
            }
        }
    }
    public PlanetPanel(SettingsPanel sp)
    {
      world = new World();
      this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
      addMouseListener(this);
      settingspanel = sp;
      Thread mainThread = new Thread(new Runner());
      mainThread.start();
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        world.drawPlanets(g);
    }




     public void mouseClicked(MouseEvent e)
    {
      System.out.println("mouseClicked");

      int xPos = e.getX();
      int yPos = e.getY();
      Vector clickPos = new Vector(xPos, yPos);
      int planetIndex = -1;
      for(int i = 0; i < world.planets.size(); i ++)
      {
        Vector dFromC = world.planets.get(i).position.difference(clickPos);
        if(dFromC.getMagnitude() < world.planets.get(i).radius)
          {

            planetIndex = i;
            break;
          }
      }
      if(planetIndex != -1)
      {
        world.removePlanet(planetIndex);
      }
      else
      {
        Vector pos = new Vector((double) xPos, (double) yPos);
        Vector vel = settingspanel.getVelocityVector();
        double mass = settingspanel.getMass();
        double radius = settingspanel.getRadius();
        if(vel != null && mass > 0 && radius > 0)
        {
          world.addPlanet(pos, vel, mass, radius);
        }

      }

      //System.out.println(xPos + ", " + yPos);


    }

    public void mousePressed(MouseEvent e)
    {
    //  System.out.println("mousePressed");

    }
    public void mouseReleased(MouseEvent e)
    {
    //  System.out.println("mouseReleased");
    }
    public void mouseEntered(MouseEvent e)
    {
    //  System.out.println("mouseEntered");
    }
    public void mouseExited(MouseEvent e)
    {
    //  System.out.println("mouseExited");
    }

}
