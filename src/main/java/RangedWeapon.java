public class RangedWeapon extends Weapon
{
    Integer ammo = 5;
    public RangedWeapon(String name)
    {
        super(name);
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
