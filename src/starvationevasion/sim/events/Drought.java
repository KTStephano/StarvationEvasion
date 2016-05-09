package starvationevasion.sim.events;


import starvationevasion.common.*;
import starvationevasion.sim.*;


/**
 * A drought special event
 */
public class Drought extends AbstractEvent
{
  Region region;
  public Drought(Region landArea)
  {
    super(landArea, 4);
    region = landArea;
  }

  public void applyEffects()
  {
    for (Territory territory : region.getTerritoryList())
    {
      for (starvationevasion.sim.LandTile tile : territory.getLandTiles())
      {
        //tile.setRainfall(tile.getRainfall() / 3);
      }
    }
    super.applyEffects();
  }

  public MapPoint getLocation()
  {
    return region.getCenter();
  }
}
