import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class PlanetPanel extends JPanel implements MouseListener
{
  public static final int WIDTH = 1024;
  public static final int HEIGHT = 540;
  public static final int FPS = 120;
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
    public PlanetPanel()
    {
      world = new World();
      world.addPlanet(new Vector(350, 50), new Vector(1, 0), .001, 5);
      world.addPlanet(new Vector(512, 270), new Vector(0, 0), 300, 20);
      this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
      addMouseListener(this);
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
      System.out.println(xPos + ", " + yPos);
      Vector pos = new Vector((double) xPos, (double) yPos);
      world.addPlanet(pos, new Vector(1, 0), .001, 5);
    }

    public void mousePressed(MouseEvent e)
    {
      System.out.println("mousePressed");

    }
    public void mouseReleased(MouseEvent e)
    {
      System.out.println("mouseReleased");
    }
    public void mouseEntered(MouseEvent e)
    {
      System.out.println("mouseEntered");
    }
    public void mouseExited(MouseEvent e)
    {
      System.out.println("mouseExited");
    }
}
