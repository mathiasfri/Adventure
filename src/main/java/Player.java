import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Player
{
    private Room currentRoom;
    Map m;
    private ArrayList<Item> inventory = new ArrayList<>();
    private Integer health = 100;

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

    public String printInventory()
    {
        return inventory.toString();
    }

    public Item searchItemInInventory(String item)
    {
        for (Item i : inventory)
        {
            if (i.getName().equalsIgnoreCase(item))
            {
                return i;
            }
        }
        return null;
    }

    public void removeItemFromInventory(Item item)
    {
        inventory.remove(item);
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

    public void setHealth(Item item)
    {
        if (item instanceof Food)
        {
            this.health += 20;
        }

        if (health > 100)
        {
            health = 100;
        }
    }

    public FoodEnum eatFood(String itemName)
    {
        Item eatItem = searchItemInInventory(itemName);

        if (eatItem == null)
        {
            return FoodEnum.NOT_FOUND;
        }

        else if (eatItem instanceof Food)
        {
            setHealth(eatItem);
            removeItemFromInventory(eatItem);
            return FoodEnum.FOOD;
        }

        else
            return FoodEnum.NOT_FOOD;
    }

    public Integer getHealth()
    {
        return health;
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
