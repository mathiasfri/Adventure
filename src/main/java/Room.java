import java.util.ArrayList;

public class Room
{
    private int roomNumber;
    private String roomDescription;
    private Room roomEast;
    private Room roomWest;
    private Room roomNorth;
    private Room roomSouth;
    ArrayList<String> items = new ArrayList<>();

    public Room(int roomNumber, String roomDescription)
    {
        this.roomNumber = roomNumber;
        this.roomDescription = roomDescription;
    }

    public void setEast(Room room)
    {
        this.roomEast = room;
    }

    public void setWest(Room room)
    {
        this.roomWest = room;
    }

    public void setNorth(Room room)
    {
        this.roomNorth = room;
    }

    public void setSouth(Room room)
    {
        this.roomSouth = room;
    }

    public Room getEast()
    {
        return roomEast;
    }

    public Room getWest()
    {
        return roomWest;
    }

    public Room getNorth()
    {
        return roomNorth;
    }

    public Room getSouth()
    {
        return roomSouth;
    }

    public String getRoomInfo()
    {
        return roomDescription;
    }

    public String getItems()
    {
        return items.get(roomNumber - 1);
    }
}
