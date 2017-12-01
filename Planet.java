import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.awt.*;

public class Planet {
  World world;
  Vector position;
  Vector velocity;
  Vector acceleration;
  final double mass;
  final double radius;
  //final int arrayPos;
  Color color;
  public Planet(Vector pos, Vector vel, double m, double rad, World w)
  {
    position = pos;
    radius = rad;
    velocity = vel;
    acceleration = new Vector(0, 0);
    mass = m;
    world = w;
    //arrayPos = world.getNumberOfPlanets();
    color = new Color(255, 255, 255);
  }
  public void calculateInteractions(int i)
  {
    ArrayList<Planet> planets = world.getPlanets();
    Vector newAcceleration = new Vector(0, 0);

    for(int index = 0; index < planets.size(); index++)
    {
        if(index != i)
        {

          Vector v =  Vector.calculateAcceleration(this, planets.get(index));
          newAcceleration.add(v);
        }

    }
    acceleration = newAcceleration;
  }


  public Vector getDistance(Planet planet)
  {
    Vector distance = planet.position.difference(position);
    return distance;

  }
  public void calculateCollision(Planet planet)
  {

  }
  public void draw(Graphics g)
  {
    Color c = g.getColor();
    g.setColor(color);
    g.fillOval((int) (position.x - radius), (int) (position.y - radius), (int) (2*radius), (int) (2*radius));
    g.setColor(c);
  }

  /*public Vector calculateAcceleration(Planet planet, Vector newAcceleration)
  {
    newAcceleration.x += (int) (distance.x * planet.mass) / (Math.pow(Math.pow(distance.x, 2) + Math.pow(distance.y, 2), 1.5 ));
    newAcceleration.y += (int) (distance.y * planet.mass) / (Math.pow(Math.pow(distance.x, 2) + Math.pow(distance.y, 2), 1.5 ));
    return newAcceleration;
  } */
  public String toString()
  {
    String toReturn = "Position: (" + position.x + ", " + position.y + ") Velocity: (" + velocity.x + ", "
     + velocity.y + ")  Mass: " + mass + " Radius: " + radius;
     return toReturn;
  }


}
