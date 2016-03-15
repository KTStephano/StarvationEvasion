package starvationevasion.common;

import com.oracle.javafx.jmx.json.JSONDocument;
import starvationevasion.server.io.JSON;

/**
 * Simple data class for specifying a location on the Earth's Surface.
 */
public class MapPoint implements JSON
{
  /**
   * Specifies the north-south position of a point on the Earth's surface.
   * Latitude is an angle in degrees which ranges from 0 degrees at the Equator to +-90 degrees
   * (+North to-South) at the poles.
   * Lines of constant latitude, or parallels, run east-west as circles parallel to the equator.
   */
  public double latitude;

  /**
   * Specifies the east-west position of a point on the Earth's surface.
   * It is an angular measurement expressed in degrees.
   * The 0 degrees longitude line (Prime Meridian), passes through the Royal Observatory,
   * Greenwich, England.
   * The longitude of other places as the angle east or west from the Prime Meridian, ranging
   * from 0 degrees at the Prime Meridian to +180 degrees eastward and ?180 degrees westward.
   * Points with the same longitude lie in lines running from the North Pole to the South Pole.
   */
  public double longitude;

  public MapPoint(double longitude, double latitude)
  {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  
  @Override
  public String toString()
  {
    return String.format("Location{%.2f, %.2f}", latitude, longitude);
  }


  @Override
  public String toJSONString ()
  {
    return toJSON().toString();
  }

  @Override
  public JSONDocument toJSON()
  {
    JSONDocument json = JSONDocument.createObject();

    json.setNumber("latitude", latitude);
    json.setNumber("longitude", longitude);

    return json;
  }

  public MapPoint(JSONDocument json)
  {
    latitude = (double) json.getNumber("latitude");
    longitude = (double) json.getNumber("longitude");
  }

  @Override
public boolean equals(Object o)
{
  if (o == this)
    return true;
  if(!(o instanceof MapPoint))
    return false;
  MapPoint map = (MapPoint) o;
  if(Double.compare(map.longitude, this.longitude) != 0)
    return false;
  if(Double.compare(map.latitude, this.latitude) != 0)
    return false;
  return true;
}
}
