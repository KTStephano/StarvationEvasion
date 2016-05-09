package starvationevasion.sim.events;


import starvationevasion.common.*;
import starvationevasion.sim.*;


/**
 * A drought special event
 */
public class Drought extends AbstractEvent
{
  Region region;
  public Drought(Territory landArea, Region region, CropData cropData, int duration)
  {
    super(landArea, region, cropData, duration);
  }

  public void applyEffects()
  {
    reduceRainFall();
    super.applyEffects();
  }

  public MapPoint getLocation()
  {
    return region.getCenter();
  }
}
