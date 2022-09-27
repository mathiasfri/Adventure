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

        switch (userChoice)
        {
            case "north", "n", "go north":
                ad.goNorth();
            case "south", "s", "go south":
                ad.goSouth();
            case "west", "w", "go west":
                ad.goWest();
            case "east", "e", "go east":
                ad.goEast();
        }
    }
}
