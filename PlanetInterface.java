import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
public class PlanetInterface extends JPanel // implements EventListener
{
  public static final int WIDTH = 768;
  public static final int HEIGHT = 1024;
  public static final int FPS = 60;
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
    public PlanetInterface()
    {
      world = new World();
      world.addPlanet(new Vector(100, 100), new Vector(2, -2), 12, 15);
        world.addPlanet(new Vector(200, 200), new Vector(-4, 3), 12, 15);
      this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
      Thread mainThread = new Thread(new Runner());
      mainThread.start();
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.WHITE);
        world.drawPlanets(g);
    }

    public static void main(String[] arguments)
    {
      JFrame frame = new JFrame("Work?");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      PlanetInterface mainInstance = new PlanetInterface();
      frame.setContentPane(mainInstance);
      frame.pack();
      frame.setVisible(true);
    }
}
