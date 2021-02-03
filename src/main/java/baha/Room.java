package baha;



public class Room implements MapSite {
    private boolean dark;
    private boolean switchLightExists;
    private final int roomNo;
    int playerDirction=0;


    private MapSite[] mapSites= new MapSite[5];
    public Room(int roomNo){
        this.roomNo=roomNo;

    }


    public boolean isDark() {
        return dark;
    }
    public void setDark(boolean dark) {
        this.dark = dark;
    }
    public boolean isSwitchLightExists() {
        return switchLightExists;
    }
    public void setSwitchLightExists(boolean switchLightExists) {
        this.switchLightExists = switchLightExists;
    }
    public void turnLightOn(){if (isSwitchLightExists()) setDark(false);}
    public void turnLightOff(){if (isSwitchLightExists()) setDark(true);}

    public int getRoomNo() {
        return roomNo;
    }

    public MapSite[] getMapSites() {
        return mapSites;
    }

    public void setMapSites(MapSite mapSite,int side) {
        this.mapSites[side] =mapSite ;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public void enter(Maze maze) {

    }

}