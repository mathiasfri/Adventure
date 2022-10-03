import java.util.ArrayList;

public class Room
{
    private int roomNumber;
    private String roomDescription;
    private Room roomEast;
    private Room roomWest;
    private Room roomNorth;
    private Room roomSouth;
    private ArrayList<Item> items = new ArrayList<>();

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

    public void addItemToRoom(Item item)
    {
        items.add(item);
    }

    public Item searchItem(String itemName)
    {
        for (Item i : items)
        {
            if (i.getName().equalsIgnoreCase(itemName))
            {
                return i;
            }
        }
        return null;
    }

    public void removeItem(Item item)
    {
        int in = -1;
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i) == item)
            {
                in = i;
            }
            items.remove(in);
        }
    }

    public ArrayList<Item> getItems()
    {
        return items;
    }
}
