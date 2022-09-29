import java.util.Objects;
import java.util.Scanner;

public class UserInterface
{
    Scanner sc = new Scanner(System.in);
    Player player;
    Map map;
    Adventure ad;
    Items items;

    public UserInterface()
    {
        player = new Player();
        map = new Map();
        ad = new Adventure();
        items = new Items();
    }

    public void start()
    {
        System.out.println("""
                Welcome to your adventure! To move around, type in the following: 
                west/w/go west - to go west
                north/n/go north - to go north
                south/s/go south - to go south
                east/e/go east - to go east
                
                Other commands are available as well here:
                Type 'exit' at any time to exit the game.
                Type 'look' to get information about your whereabouts.
                Type 'help' at any time to show a list of commands you can type.
                
                """);

        String userChoice = null;

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
                        System.out.println("Items in this room: \n" + items.printItems());
                    } else
                        System.out.println("You cannot go this way!");
                    break;

                case "south", "s", "go south":
                    boolean canGoSouth = player.goSouth();
                    if (canGoSouth)
                    {
                        System.out.println("You have chosen to go South.");
                        System.out.println(player.look());
                        System.out.println("Items in this room: \n" + items.printItems());
                    } else
                        System.out.println("You cannot go this way!");
                    break;

                case "west", "w", "go west":
                    boolean canGoWest = player.goWest();
                    if (canGoWest)
                    {
                        System.out.println("You have chosen to go West.");
                        System.out.println(player.look());
                        System.out.println("Items in this room: \n" + items.printItems());
                    } else
                        System.out.println("You cannot go that way!");
                    break;

                case "east", "e", "go east":
                    boolean canGoEast = player.goEast();
                    if (canGoEast)
                    {
                        System.out.println("You have chosen to go East.");
                        System.out.println(player.look());
                        System.out.println("Items in this room: \n" + items.printItems());
                    } else
                        System.out.println("You cannot go that way!");
                    break;

                case "look":
                    System.out.println(player.look());
                    break;

                case "exit":
                    System.out.println("Cheers :)");
                    System.exit(0);
            }
        }
    }
}
