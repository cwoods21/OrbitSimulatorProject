import java.lang.Math;
public class Vector
{
  int x;
  int y;
  int magnitude;

  public Vector(int x, int y)
  {
    x = x;
    y = y;
    magnitude =  (int) (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
  }

  public Vector subtract(Vector vector)
  {
    Vector toReturn = new Vector(x - vector.x, y - vector.y);
    return toReturn;
  }
  public int getMagnitude()
  {
    return magnitude;
  }
  public void add(Vector v)
  {
    x += v.x;
    y = v.y;
  }
}
