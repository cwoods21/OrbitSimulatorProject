import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
public class PlanetInterface extends JPanel // implements EventListener
{
  public static final int WIDTH = 768;
  public static final int HEIGHT = 1024;
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
    public PlanetInterface()
    {
      world = new World();
      world.addPlanet(new Vector(350, 50), new Vector(1, 0), .001, 5);
      world.addPlanet(new Vector(350, 350), new Vector(0, 0), 300, 20);
      this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
      Thread mainThread = new Thread(new Runner());
      mainThread.start();
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
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


     /*void mouseClicked(MouseEvent e)
    {
      int xPos = e.getX();
      int yPos = e.getY();
      Vector pos = new Vector((double) xPos, (double) yPos);
      world.addPlanet(pos, new Vector(Math.random(), Math.random()), .001, 5);
    }

    void mousePressed(MouseEvent e)
    {

    }
    void mouseReleased(MouseEvent e)
    {

    }
    void mouseEntered(MouseEvent e)
    {

    }
    void mouseExited(MouseEvent e)
    {

    } */
}
