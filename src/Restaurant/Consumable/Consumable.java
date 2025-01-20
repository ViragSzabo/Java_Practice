package Restaurant.Consumable;

public abstract class Consumable
{
    /** Common parameters of Consumables */
    protected String name;
    protected double price;

    /**
     * Constructor of Consumables
     * with parameters all consumables have
     */
    public Consumable(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    /**
     * Get the name of the consumable
     * @return a string
     */
    public String getName() {
        return name;
    }

    /** Change the name of the consumable */
    public void setName(String name) {
        this.name = name;
    }

    /** Get the price of the consumable */
    public double getPrice() {
        return price;
    }

    /** Change the price of the consumable */
    public void setPrice(double price) {
        this.price = price;
    }
}