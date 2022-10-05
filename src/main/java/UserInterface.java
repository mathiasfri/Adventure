import java.util.Objects;
import java.util.Scanner;

public class UserInterface
{
    Scanner sc = new Scanner(System.in);
    Player player;
    Map map;
    Adventure ad;

    public UserInterface()
    {
        player = new Player();
        map = new Map();
        ad = new Adventure();
    }

    public void start()
    {
        System.out.println("""
                Welcome to your adventure! To move around, type in the following:
                west/w/go west - to go west
                north/n/go north - to go north
                south/s/go south - to go south
                east/e/go east - to go east
                
                Helpful commands:
                Type 'look' to get information about your whereabouts.
                Type 'inventory' or 'inv' to show your current inventory
                Type 'take' to pick up an item in your current room
                Type 'drop' to drop an item in your inventory
                Type 'health' or 'hp' to see your current health
                
                Other commands:
                Type 'exit' at any time to exit the game.
                Type 'help' at any time to show a list of commands you can type.
                
                """);

        String userChoice = null;

        System.out.println(player.look());
        System.out.println("Item in this room: \n" + player.getCurrentRoom().getItems());

        while (!Objects.equals(userChoice, "exit"))
        {
            userChoice = sc.nextLine().toLowerCase();

            switch (userChoice)
            {
                case "north", "n", "go north":
                    boolean canGoNorth = player.goNorth();
                    if (canGoNorth)
                    {
                        System.out.println("You have chosen to go North.");
                        System.out.println(player.look());
                        System.out.println("Item in this room: \n" + player.getCurrentRoom().getItems());
                    } else
                        System.out.println("You cannot go this way!");
                    break;

                case "south", "s", "go south":
                    boolean canGoSouth = player.goSouth();
                    if (canGoSouth)
                    {
                        System.out.println("You have chosen to go South.");
                        System.out.println(player.look());
                        System.out.println("Item in this room: \n" + player.getCurrentRoom().getItems());
                    } else
                        System.out.println("You cannot go this way!");
                    break;

                case "west", "w", "go west":
                    boolean canGoWest = player.goWest();
                    if (canGoWest)
                    {
                        System.out.println("You have chosen to go West.");
                        System.out.println(player.look());
                        System.out.println("Item in this room: \n" + player.getCurrentRoom().getItems());
                    } else
                        System.out.println("You cannot go that way!");
                    break;

                case "east", "e", "go east":
                    boolean canGoEast = player.goEast();
                    if (canGoEast)
                    {
                        System.out.println("You have chosen to go East.");
                        System.out.println(player.look());
                        System.out.println("Item in this room: \n" + player.getCurrentRoom().getItems());
                    } else
                        System.out.println("You cannot go that way!");
                    break;

                case "look":
                    System.out.println(player.look());
                    break;

                case "take":
                    System.out.println("Which item do you want to pickup?");
                    String pickupItem = sc.nextLine();
                    boolean itemTaken = player.takeItem(pickupItem);
                    if (itemTaken)
                    {
                        System.out.println("You have taken: " + pickupItem);
                    }
                    else
                    {
                        System.out.println(pickupItem + " Cannot be found in the room.");
                    }
                    break;

                case "inventory", "inv":
                    System.out.println("Your inventory: ");
                    System.out.println(player.printInventory());
                    break;

                case "drop":
                    System.out.println("Which item do you wish to drop?");
                    String removeItem = sc.nextLine();
                    boolean itemDropped = player.dropItem(removeItem);
                    if (itemDropped)
                    {
                        System.out.println("You have droppet item: " + removeItem);
                    }
                    else
                        System.out.println("Could not find " + removeItem + " in your inventory");
                    break;

                case "eat":
                    System.out.println("Here is your inventory: ");
                    System.out.println(player.printInventory());
                    System.out.println("What would you like to eat?");
                    FoodEnum determineFood = player.eatFood(sc.nextLine());
                    switch (determineFood)
                    {
                        case FOOD:
                            System.out.println("You have eaten " + determineFood + " and it is no longer in your inventory.");
                            System.out.println(player.getHealth());
                            break;

                        case NOT_FOUND:
                            System.out.println("Could not find " + determineFood + " in your inventory.");
                            break;

                        case NOT_FOOD:
                            System.out.println("Why are you trying to eat a " + determineFood + "? That is not possible.");
                    }

                case "health", "hp":
                    Integer health = player.getHealth();
                    if (health > 0 && 24 > health)
                        System.out.println("Health: " + health + " - You are dying and should eat before moving forward.");
                    if (health > 25 && 49 > health)
                        System.out.println("Health: " + health + " - You are good, but should probably eat now.");
                    if (health > 50 && 74 > health)
                        System.out.println("Health: " + health + " - You are in good health and can take a few hits before eating.");
                    if (health > 75 && 100 >= health)
                        System.out.println("Health: " + health + " - You are in peak condition and ready to fight.");
                    break;

                case "help":
                    System.out.println("""
                            Commands available:
                            west/w/go west - to go west
                            north/n/go north - to go north
                            south/s/go south - to go south
                            east/e/go east - to go east
                
                            Helpful commands:
                            Type 'look' to get information about your whereabouts.
                            Type 'inventory' or 'inv' to show your current inventory
                            Type 'take' to pick up an item in your current room
                            Type 'drop' to drop an item in your inventory
                            Type 'health' or 'hp' to see your current health
                
                            Other commands:
                            Type 'exit' at any time to exit the game.
                            Type 'help' at any time to show a list of commands you can type.
                            """);
                    break;

                case "exit":
                    System.out.println("Cheers :)");
                    System.exit(0);
            }
        }
    }
}
