public class Map
{
    private Room starterRoom;
    private Enemy enemy;

    public Map()
    {
        // TODO Create rooms

        Room room1 = new Room(1, "Room number 1");
        Room room2 = new Room(2, "Room number 2");
        Room room3 = new Room(3, "Room number 3");
        Room room4 = new Room(4, "Room number 4");
        Room room5 = new Room(5, "Room number 5");
        Room room6 = new Room(6, "Room number 6");
        Room room7 = new Room(7, "Room number 7");
        Room room8 = new Room(8, "Room number 8");
        Room room9 = new Room(9, "Room number 9");

        //TODO Navigation

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
        room8.setWest(room7);

        // Navigering i room9
        room9.setNorth(room6);
        room9.setWest(room8);

        this.starterRoom = room1;


        // TODO Items

        room1.getItems().add(new Item("Lamp"));
        room2.getItems().add(new Item("Key"));
        room3.getItems().add(new Item("Candle"));
        room4.getItems().add(new Item("Map"));
        room5.getItems().add(new Item("Bag"));
        room6.getItems().add(new Item("Matches"));
        room7.getItems().add(new Item("Elixir"));
        room8.getItems().add(new Item("Masterkey"));
        room9.getItems().add(new Item("Trophy"));


        // TODO Food

        room1.getItems().add(new Food("Apple", 20));
        room2.getItems().add(new Food("Chocolate", 25));
        room5.getItems().add(new Food("Corn", 15));
        room7.getItems().add(new Food("Energybar", 40));
        room9.getItems().add(new Food("Beef", 50));


        // TODO Weapons
        room1.getItems().add(new MeleeWeapon("Sword", 40));
        room3.getItems().add(new RangedWeapon("Slingshot", 20));
        room5.getItems().add(new RangedWeapon("Bow", 30));
        room7.getItems().add(new MeleeWeapon("Machete", 35));
        room9.getItems().add(new RangedWeapon("Revolver", 50));


        // TODO Enemies
        MeleeWeapon spear = new MeleeWeapon("Spear", 30);
        room2.getEnemies().add(new Enemy("Bigboy", "A very big tanky monster", 100, spear));

        RangedWeapon rockThrow = new RangedWeapon("Rocks", 15);
        room4.getEnemies().add(new Enemy("Usain", "Very fast monster that throws rocks", 60, rockThrow));

        MeleeWeapon teeth = new MeleeWeapon("Teeth", 60);
        room6.getEnemies().add(new Enemy("Cannibal", "Former human with bloodlust", 30, teeth));
    }

    public Room getStarterRoom()
    {
        return starterRoom;
    }
}
