public class RangedWeapon extends Weapon
{
    Integer ammo = 3;
    public RangedWeapon(String name, int damage)
    {
        super(name, damage);
    }

    @Override
    public AttackEnum attack()
    {
        if (ammo == 0)
        {
            return AttackEnum.NO_AMMO;
        }

        ammo--;

        return AttackEnum.FIRE;
    }
}
