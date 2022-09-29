import java.util.ArrayList;

public class Items
{
    Map m;
    Room room;

    public Items()
    {
        m = new Map();
    }

    public String printItems()
    {
        return m.currentRoom.getItems();
    }
}
