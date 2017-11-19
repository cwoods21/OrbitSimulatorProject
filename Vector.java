import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
public class Vector
{
  double x;
  double y;
  double magnitude;

  public Vector(double x, double y)
  {
    this.x = x;
    this.y = y;
    magnitude = (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
  }

  public Vector difference(Vector vector)
  {
    Vector toReturn = new Vector(this.x - vector.x, this.y - vector.y);
    return toReturn;
  }
  public Vector sum(Vector vector)
  {
    Vector toReturn = new Vector(this.x - vector.x, this.y - vector.y);
    return toReturn;
  }

  public double getMagnitude()
  {
    return magnitude;
  }
  public void add(Vector v)
  {
    this.x += v.x;
    this.y += v.y;
  }

  public static Vector calculateAcceleration(Planet planet1, Planet planet2)
  {
      Vector toReturn = new Vector (0, 0);
      Vector distance = planet1.getDistance(planet2);
      toReturn.x += (distance.x * planet2.mass) / (Math.pow(distance.getMagnitude(), 3));
      toReturn.y += (distance.y * planet2.mass) / (Math.pow(distance.getMagnitude(), 3));
      return toReturn;
  }
}
