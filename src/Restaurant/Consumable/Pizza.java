package Restaurant.Consumable;

public class Pizza extends Consumable implements CaloriesCount
{
    /** Constructor of a Pizza */
    public Pizza(String name, double price)
    {
        super(name, price);
    }

    /**
     * Calculate the calories of a Pizza
     * @return a double amount
     */
    @Override
    public double calculateCalories()
    {
        return 500;
    }
}