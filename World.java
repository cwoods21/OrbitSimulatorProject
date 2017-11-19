public class World
{
  Planet[] planets;
  public World()
  {

  }
  public Planets getNumberOfPlanets()
  {
    return planets.length;
  }



  public void updatePlanets()
  {
    for(int i = 0; i < planets.length; i ++)
    {
      planet.position.add(planet.velocity);
      planet.velocity.add(planet.acceleration);
      planet.calculateInteractions();
    }
  }
}
