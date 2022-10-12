import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Player
{
    private Room currentRoom;
    Map m;
    private ArrayList<Item> inventory = new ArrayList<>();
    private Integer health = 100;
    private Weapon equippedWeapon;
    private Enemy enemy;

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
            this.health += ((Food) item).getHealthGain();
        }

        if (health > 100)
        {
            health = 100;
        }
    }

    public FoodEnum eatFood(String itemName)
    {
        Item eatItem = searchItemInInventory(itemName);

        if (eatItem instanceof Food)
        {
            setHealth(eatItem);
            removeItemFromInventory(eatItem);
            return FoodEnum.FOOD;
        }

        else if (eatItem == null)
        {
            return FoodEnum.NOT_FOUND;
        }

        else
            return FoodEnum.NOT_FOOD;
    }

    public void setEquippedWeapon(Weapon equippedWeapon)
    {
        this.equippedWeapon = equippedWeapon;
    }

    public WeaponEnum equipWeapon(String itemName)
    {
        Weapon weaponEquip = (Weapon) searchItemInInventory(itemName);

        if (weaponEquip == null)
        {
            return WeaponEnum.NOT_FOUND;
        }

        else if (weaponEquip instanceof Weapon)
        {
            setEquippedWeapon(weaponEquip);
            return WeaponEnum.WEAPON;
        }
        else
            return WeaponEnum.NOT_WEAPON;
    }

    private AttackEnum attackMethod()
    {
        if (enemy.enemyIsAlive())
        {
            health -= enemy.getWeapon().getDamage();

            if(enemy.attack() == AttackEnum.NO_AMMO)
            {
                return AttackEnum.ENEMY_OUT_OF_AMMO;
            }

            else
            {
                enemy.setHealth(enemy.getHealth() - equippedWeapon.getDamage());
                if (playerIsAlive())
                {
                    return AttackEnum.ATTACK;
                }

                else
                    return AttackEnum.PLAYER_DEAD;
            }
        }

        else
        {
            currentRoom.addItemToRoom(enemy.getWeapon());
            currentRoom.removeEnemyFromRoom(enemy);
            return AttackEnum.ENEMY_DEAD;
        }
    }

    public AttackEnum attack(String enemyName)
    {
        setCurrentEnemy(enemyName);

        if (equippedWeapon == null)
        {
            return AttackEnum.NOTHING_EQUIPPED;
        }

        if (currentRoom.searchEnemy(enemyName) == null)
        {
            return AttackEnum.NO_ENEMY_FOUND;
        }

        if (equippedWeapon.attack() == AttackEnum.NO_AMMO)
        {
            return AttackEnum.NO_AMMO;
        }

        else
            return attackMethod();
    }


    public boolean playerIsAlive()
    {
        if (health > 0)
        {
            return true;
        }

        else
            return false;
    }

    public void setCurrentEnemy(String enemyName)
    {
        Enemy currentEnemy = currentRoom.searchEnemy(enemyName);
        if (currentEnemy != null)
        {
            this.enemy = currentEnemy;
        }
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
