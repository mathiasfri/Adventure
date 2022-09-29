public class Player
{
    Map m;

    public Player()
    {
        m = new Map();
    }

    public boolean goEast()
    {
        if (m.currentRoom.getEast() == null)
        {
            return false;
        }
        else
        {
            m.currentRoom = m.currentRoom.getEast();
            return true;
        }
    }

    public boolean goWest()
    {
        if (m.currentRoom.getWest() == null)
        {
            return false;
        }
        else
        {
            m.currentRoom = m.currentRoom.getWest();
            return true;
        }
    }

    public boolean goNorth()
    {
        if (m.currentRoom.getNorth() == null)
        {
            return false;
        }
        else
        {
            m.currentRoom = m.currentRoom.getNorth();
            return true;
        }
    }

    public boolean goSouth()
    {
        if (m.currentRoom.getSouth() == null)
        {
            return false;
        }
        else
        {
            m.currentRoom = m.currentRoom.getSouth();
            return true;
        }
    }

    public String look()
    {
        return m.currentRoom.getRoomInfo();
    }

    public void takeItem()
    {

    }
}
