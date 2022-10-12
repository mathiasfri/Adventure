import java.util.ArrayList;

public class Enemy
{
    String name;
    String description;
    Integer health;
    Weapon weapon;
    private ArrayList<Enemy> enemy = new ArrayList<>();

    public Enemy(String name, String description, Integer health, Weapon weapon)
    {
        this.name = name;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public Integer getHealth()
    {
        return health;
    }

    public AttackEnum attack()
    {
        return AttackEnum.ENEMY_ATTACKED;
    }

    public Weapon getWeapon()
    {
        return weapon;
    }

    public String getName()
    {
        return name;
    }

    public boolean enemyIsAlive()
    {
        if (health > 0)
        {
            return true;
        }

        else
            return false;
    }

    @Override
    public String toString()
    {
        return  "\n" + "Name: " + name + "\n" +
                "Description: " + description + "\n" +
                "Health: " + health + "\n" +
                "Weapon: " + weapon + "\n";
    }
}
