package starvationevasion.sim.events;

import starvationevasion.common.EnumSpecialEvent;
import starvationevasion.common.MapPoint;
import starvationevasion.sim.CropData;
import starvationevasion.sim.LandTile;
import starvationevasion.sim.Region;
import starvationevasion.sim.Territory;


/**
 * A hurricane special event
 */
public class Hurricane extends AbstractEvent
{
  public Hurricane(Territory landArea, Region region, CropData cropData, int duration)
  {
    super(landArea, region, cropData, duration);
  }

  public void applyEffects()
  {
    causeFlood();
    super.applyEffects();    
  }

  public MapPoint getLocation()
  {
    return getLandArea().getCenter();
  }
}
