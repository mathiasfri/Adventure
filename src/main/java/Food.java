public class Food extends Item
{
    int healthGain;

    public Food(String name, int healthGain)
    {
        super(name);
        this.healthGain = healthGain;
    }

    public Integer getHealthGain()
    {
        return healthGain;
    }

    public String toString()
    {
        return super.toString();
    }
}
