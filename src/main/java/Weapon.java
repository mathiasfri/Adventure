public abstract class Weapon extends Item
{
    Integer damage;
    public Weapon(String name, Integer damage)
    {
        super(name);
        this.damage = damage;
    }

    public abstract AttackEnum attack();

    public Integer getDamage()
    {
        return damage;
    }
}
