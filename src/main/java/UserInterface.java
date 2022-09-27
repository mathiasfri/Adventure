import java.util.Objects;
import java.util.Scanner;

public class UserInterface
{
    Scanner sc = new Scanner(System.in);
    Adventure ad = new Adventure();

    public void start()
    {
        System.out.println("""
                Welcome to your adventure! To move around, type in the following: west/w, north/n, south/s, 
                east/e.
                Type 'exit' at any time to exit the game.
                Type 'help' at any time to show a list of commands you can type.
                Type 'look' to get information about your whereabouts.
                
                """);

        String userChoice = null;

        while (!Objects.equals(userChoice, "exit"))
        {
            userChoice = sc.nextLine();

            switch (userChoice)
            {
                case "north", "n", "go north":
                    boolean canGoNorth = ad.goNorth();
                    if (canGoNorth)
                    {
                        System.out.println("You have chosen to go North.");
                        ad.goNorth();
                        System.out.println(ad.look());
                    } else
                        System.out.println("You cannot go this way!");
                    break;

                case "south", "s", "go south":
                    boolean canGoSouth = ad.goSouth();
                    if (canGoSouth)
                    {
                        System.out.println("You have chosen to go South.");
                        ad.goSouth();
                        System.out.println(ad.look());
                    } else
                        System.out.println("You cannot go this way!");
                    break;

                case "west", "w", "go west":
                    boolean canGoWest = ad.goWest();
                    if (canGoWest)
                    {
                        System.out.println("You have chosen to go West.");
                        ad.goWest();
                        System.out.println(ad.look());
                    } else
                        System.out.println("You cannot go that way!");
                    break;

                case "east", "e", "go east":
                    boolean canGoEast = ad.goEast();
                    if (canGoEast)
                    {
                        System.out.println("You have chosen to go East.");
                        ad.goEast();
                        System.out.println(ad.look());
                    } else
                        System.out.println("You cannot go that way!");
                    break;

                case "look":
                    System.out.println(ad.look());
                    break;

                case "exit":
                    System.out.println("Cheers :)");
                    System.exit(0);
            }
        }
    }
}
