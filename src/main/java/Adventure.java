public class Adventure
{
    Room currentRoom = null;

    public Adventure()
    {
        Room room1 = new Room(1, "Rum nummer 1");
        Room room2 = new Room(2, "Rum nummer 2");
        Room room3 = new Room(3, "Rum nummer 3");
        Room room4 = new Room(4, "Rum nummer 4");
        Room room5 = new Room(5, "Rum nummer 5");
        Room room6 = new Room(6, "Rum nummer 6");
        Room room7 = new Room(7, "Rum nummer 7");
        Room room8 = new Room(8, "Rum nummer 8");
        Room room9 = new Room(9, "Rum nummer 9");

        //TODO Navigering

        // Navigering i room1
        room1.setEast(room2);
        room1.setSouth(room4);

        // Navigering i room2
        room2.setEast(room3);
        room2.setWest(room1);

        // Navigering i room3
        room3.setWest(room2);
        room3.setSouth(room6);

        // Navigering i room4
        room4.setSouth(room7);
        room4.setNorth(room1);

        // Navigering i room5
        room5.setSouth(room8);

        // Navigering i room6
        room6.setNorth(room3);
        room6.setSouth(room9);

        // Navigering i room7
        room7.setNorth(room4);
        room7.setEast(room8);

        // Navigering i room8
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setEast(room7);

        // Navigering i room9
        room9.setNorth(room6);
        room9.setWest(room8);

        currentRoom = room1;
    }

    public boolean goEast()
    {
        if (currentRoom.getEast() == null)
        {
            return false;
        }
        else
        {
            currentRoom = currentRoom.getEast();
            return true;
        }
    }

    public boolean goWest()
    {
        if (currentRoom.getWest() == null)
        {
            return false;
        }
        else
        {
            currentRoom = currentRoom.getWest();
            return true;
        }
    }

    public boolean goNorth()
    {
        if (currentRoom.getNorth() == null)
        {
            return false;
        }
        else
        {
            currentRoom = currentRoom.getNorth();
            return true;
        }
    }

    public boolean goSouth()
    {
        if (currentRoom.getSouth() == null)
        {
            return false;
        }
        else
        {
            currentRoom = currentRoom.getSouth();
            return true;
        }
    }

    public String look()
    {
        return currentRoom.getRoomInfo();
    }
}
