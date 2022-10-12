import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserInterface
{
    Scanner sc = new Scanner(System.in);
    String userInput;
    Player player;
    Map map;
    Adventure ad;
    Enemy enemy;

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
                Type 'health' or 'hp' to see your current health
                Type 'take (name of item)' to pick up a specified item in the current room
                Type 'drop (name of item)' to drop a specified item in your inventory
                Type 'equip (name of weapon)' to equip a specified weapon
                Type 'attack (name of enemy)' to attack a specified enemy
                
                Other commands:
                Type 'exit' or 'stop' at any time to exit the game.
                Type 'help' at any time to show a list of commands you can type.
                
                """);

        System.out.println(player.look());
        System.out.println("Item in this room: \n" + player.getCurrentRoom().getItems());
        System.out.println("\n");

        while (true)
        {
            try
            {
                userInput = sc.nextLine().toLowerCase();
                String[] input = userInput.split(" ");

                switch (input[0])
                {
                    case "north", "n", "go north":
                        boolean canGoNorth = player.goNorth();
                        if (canGoNorth)
                        {
                            System.out.println("You have chosen to go North.");
                            System.out.println(player.look());
                            System.out.println("Enemies in this room: \n" + player.getCurrentRoom().getEnemies());
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
                            System.out.println("Enemies in this room: \n" + player.getCurrentRoom().getEnemies());
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
                            System.out.println("Enemies in this room: \n" + player.getCurrentRoom().getEnemies());
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
                            System.out.println("Enemies in this room: \n" + player.getCurrentRoom().getEnemies());
                            System.out.println("Item in this room: \n" + player.getCurrentRoom().getItems());
                        } else
                            System.out.println("You cannot go that way!");
                        break;

                    case "look":
                        System.out.println(player.look());
                        break;

                    case "take":
                        boolean itemTaken = player.takeItem(input[1]);
                        if (itemTaken)
                        {
                            System.out.println("You have taken: " + input[1]);
                        } else
                        {
                            System.out.println(input[1] + " Cannot be found in the room.");
                        }
                        break;

                    case "inventory", "inv":
                        System.out.println("Your inventory: ");
                        System.out.println(player.printInventory());
                        break;

                    case "drop":
                        boolean itemDropped = player.dropItem(input[1]);
                        if (itemDropped)
                        {
                            System.out.println("You have droppet item: " + input[1]);
                        } else
                            System.out.println("Could not find " + input[1] + " in your inventory");
                        break;

                    case "eat":
                        FoodEnum determineFood = player.eatFood(input[1]);
                        switch (determineFood)
                        {
                            case NOT_FOUND:
                                System.out.println("Could not find " + input[1] + " in your inventory.");
                                break;

                            case FOOD:
                                System.out.println("You have eaten " + input[1] + " and it is no longer in your inventory.");
                                getHealth();
                                break;

                            case NOT_FOOD:
                                System.out.println("Why are you trying to eat a " + input[1] + "? That is not possible.");
                                break;
                        }
                        break;

                    case "equip":
                        WeaponEnum determineWeapon = player.equipWeapon(input[1]);
                        switch (determineWeapon)
                        {
                            case WEAPON:
                                System.out.println("You have equipped: " + input[1]);
                                break;

                            case NOT_FOUND:
                                System.out.println("Could not find " + input[1] + " in your inventory");
                                break;

                            case NOT_WEAPON:
                                System.out.println("You cannot equip " + input[1] + " as a weapon!?");
                                break;
                        }
                        break;

                    case "attack":
                        AttackEnum determineAttack = player.attack(input[1]);
                        switch (determineAttack)
                        {
                            case NO_AMMO:
                                System.out.println("You have no more ammo!");
                                break;

                            case FIRE:
                                System.out.println("You have shot your weapon.");
                                break;

                            case ATTACK:
                                System.out.println("You have swung your weapon at the enemy.");
                                break;

                            case NOTHING_EQUIPPED:
                                System.out.println("You do not have a weapon equipped!");
                                break;

                            case ENEMY_ATTACKED:
                                System.out.println("Your enemy striked back! They did " + enemy.getWeapon().getDamage() + " damage.");
                                break;

                            case PLAYER_DEAD:
                                System.out.println("You have died! Game over. Closing game.");
                                break;

                            case ENEMY_DEAD:
                                System.out.println("You have killed the enemy and they have dropped their weapon!");
                                break;

                            case NO_ENEMY_FOUND:
                                System.out.println("Could not find enemy you are searching for.");
                                break;
                        }
                        break;

                    case "health", "hp":
                        getHealth();
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
                                Type 'health' or 'hp' to see your current health
                                Type 'take (name of item)' to pick up a specified item in the current room
                                Type 'drop (name of item)' to drop a specified item in your inventory
                                Type 'equip (name of weapon)' to equip a specified weapon
                                Type 'attack (name of enemy)' to attack a specified enemy
                                                
                                Other commands:
                                Type 'exit' or 'stop' at any time to exit the game.
                                Type 'help' at any time to show a list of commands you can type.
                                """);
                        break;

                    case "exit", "stop", "quit":
                        System.out.println("Cheers :)");
                        System.exit(0);

                    default:
                        System.out.println("Command not found.");
                }
            }

            catch (Exception e)
            {
            System.out.println("Non-valid input. Try again.");
            }
        }
    }


    private void getHealth()
    {
        Integer health = player.getHealth();
        if (health > 0 && 24 > health)
            System.out.println("Health: " + health + " - You are dying and should eat before moving forward.");
        if (health > 25 && 49 > health)
            System.out.println("Health: " + health + " - You are good, but should probably eat now.");
        if (health > 50 && 74 > health)
            System.out.println("Health: " + health + " - You are in good health and can take a few hits before eating.");
        if (health > 75 && 100 >= health)
            System.out.println("Health: " + health + " - You are in peak condition and ready to fight.");
    }
}
