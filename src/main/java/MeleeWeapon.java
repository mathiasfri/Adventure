public class MeleeWeapon extends Weapon
{
    public MeleeWeapon(String name)
    {
        super(name);
    }

    @Override
    public AttackEnum attack()
    {
        return AttackEnum.ATTACK;
    }
}
