import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
public class World
{
  ArrayList<Planet> planets;
  public World()
  {
    planets = new ArrayList<Planet>();
  }
  public int getNumberOfPlanets()
  {
    return planets.size();
  }
  public ArrayList<Planet> getPlanets()
  {
    return planets;
  }


  public void drawPlanets(Graphics g)
  {
    for(int i = 0; i < planets.size(); i ++)
    {
      planets.get(i).draw(g);

      //System.out.println(planets.get(i).arrayPos + ": " + planets.get(i).toString());

    }
  }

  public void updatePlanets()
  {
    for(int i = 0; i < planets.size(); i ++)
    {

      planets.get(i).position.add(planets.get(i).velocity);
      planets.get(i).velocity.add(planets.get(i).acceleration);
      planets.get(i).calculateInteractions(i);
    }
  }
  public void addPlanet(Vector pos, Vector vel, double m, double rad)
  {
    Planet planet = new Planet(pos, vel, m, rad, this);
    planets.add(planet);
  }
  public void removePlanet(int i)
  {
    planets.remove(i);
  }
}
