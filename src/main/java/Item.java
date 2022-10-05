public class Item
{
    private String name;


    public Item(String name)
    {
        this.name = name;
    }

    public Item(Item item)
    {
        this.name = item.name;
    }

    public String getName()
    {
        return name;
    }

    public String toString()
    {
        return name;
    }
}
