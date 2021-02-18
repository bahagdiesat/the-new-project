package baha;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import items.FlashLight;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

@JsonDeserialize(as = Room.class)
public class Room implements MapSite, Observer {
    private final int roomNo;
    private final MapSite[] mapSites = new MapSite[5];
    int playerDirection = 0;
    private boolean LightsOn;
    private boolean roomLightPrevState = true;
    private boolean switchLightExists;
    private String name="Room";

    public Room() {
        roomNo=-1;
    }
    public Room(int n) {
        roomNo=n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSwitchLightExists() {
        return switchLightExists;
    }



    public boolean isLightsOn() {
        return LightsOn;
    }

    public void setLightsOn(boolean lightsState) {
        this.LightsOn = lightsState;
    }

    public void switchLight() {
        if (switchLightExists) {
            roomLightPrevState = !roomLightPrevState;
        }
    }

    public int getRoomNo() {
        return roomNo;
    }

    public MapSite[] getMapSites() {
        return mapSites;
    }

    public void setMapSites(MapSite mapSite, int side) {
        this.mapSites[side] = mapSite;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }


    @Override
    public String toString() {
        return "Room{" +
                "roomNo=" + roomNo +
                ", mapSites=" + Arrays.toString(mapSites) +
                ", playerDirection=" + playerDirection +
                ", dark=" + LightsOn +
                ", switchLightExists=" + switchLightExists +
                '}';
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof FlashLight) {
            boolean isFlashOn = ((FlashLight) o).getStatus();
            LightsOn = isFlashOn || roomLightPrevState;
        }
    }
}
