import java.util.ArrayList;

public class Player
{
    private Room currentRoom;
    Map m;
    private ArrayList<Item> inventory = new ArrayList<>();

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

    public void addItemToInventory(Item item)
    {
        inventory.add(item);
    }

    public boolean takeItem(String itemName)
    {
        boolean takenItem = false;
        Item pickupItem = currentRoom.searchItem(itemName);
        if (pickupItem != null)
        {
            addItemToInventory(pickupItem);
            currentRoom.removeItem(pickupItem);
            takenItem = true;
        }
        return takenItem;
    }

    public Item printInventory()
    {
        for (Item item : inventory)
        {
            return item;
        }
        return null;
    }

    public Item searchItemInInventory(String item)
    {
        for (Item i : inventory)
        {
            if (i.getName().equals(item))
            {
                return i;
            }
        }
        return null;
    }

    public void removeItemFromInventory(Item item)
    {
        int in = -1;
        for (int i = 0; i < inventory.size(); i++)
        {
            if (inventory.get(i) == item)
            {
                in = i;
            }
            inventory.remove(in);
        }
    }

    public boolean dropItem(String itemName)
    {
        boolean droppedItem = false;
        Item dropItem = searchItemInInventory(itemName);
        if (dropItem != null)
        {
            getCurrentRoom().addItemToRoom(dropItem);
            removeItemFromInventory(dropItem);
            droppedItem = true;
        }
        return droppedItem;
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
