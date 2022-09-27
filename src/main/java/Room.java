public class Room
{
    private Room roomEast;
    private Room roomWest;
    private Room roomNorth;
    private Room roomSouth;

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
}
