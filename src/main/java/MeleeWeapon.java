public class MeleeWeapon extends Weapon
{
    public MeleeWeapon(String name, int damage)
    {
        super(name, damage);
    }

    @Override
    public AttackEnum attack()
    {
        return AttackEnum.ATTACK;
    }
}
