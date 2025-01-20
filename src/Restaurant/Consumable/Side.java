package Restaurant.Consumable;

public class Side extends Consumable implements CaloriesCount
{
    /** Constructor of a Side */
    public Side(String name, double price)
    {
        super(name, price);
    }

    /**
     * Calculate the calories of a Side
     * @return a double amount
     */
    @Override
    public double calculateCalories()
    {
        return 250;
    }
}