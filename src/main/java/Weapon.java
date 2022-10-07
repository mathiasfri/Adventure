public abstract class Weapon extends Item
{
    public Weapon(String name)
    {
        super(name);
    }

    public abstract AttackEnum attack();
}
