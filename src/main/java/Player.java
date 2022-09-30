public class Player
{
    private Room currentRoom;
    Map m;

    public Player()
    {
        m = new Map();
        setCurrentRoom(m.getStarterRoom());
    }

    public boolean goEast()
    {
        if (getCurrentRoom().getEast() == null)
        {
            return false;
        }
        else
        {
            setCurrentRoom(getCurrentRoom().getEast());
            return true;
        }
    }

    public boolean goWest()
    {
        if (getCurrentRoom().getWest() == null)
        {
            return false;
        }
        else
        {
            setCurrentRoom(getCurrentRoom().getWest());
            return true;
        }
    }

    public boolean goNorth()
    {
        if (getCurrentRoom().getNorth() == null)
        {
            return false;
        }
        else
        {
            setCurrentRoom(getCurrentRoom().getNorth());
            return true;
        }
    }

    public boolean goSouth()
    {
        if (getCurrentRoom().getSouth() == null)
        {
            return false;
        }
        else
        {
            setCurrentRoom(getCurrentRoom().getSouth());
            return true;
        }
    }


    public String look()
    {
        return currentRoom.getRoomInfo();
    }

    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom)
    {
        this.currentRoom = currentRoom;
    }
}
