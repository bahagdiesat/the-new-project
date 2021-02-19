package baha;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import container.Container;
import items.Item;
@JsonDeserialize(as = Mirror.class)
public class Mirror extends Container implements MapSite {
  private String containsKeyName;
  private Item keyItem;
  private final String name="Mirror";


  public String getName() {
    return name;
  }

  public Mirror() {
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return null;
  }


  @Override
  public String check() {
    return null;
  }

  @Override
  public String look() {
    return "You See a silhouette of you";
  }
}
