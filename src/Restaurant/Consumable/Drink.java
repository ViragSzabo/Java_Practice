package Restaurant.Consumable;

public class Drink extends Consumable implements CaloriesCount
{
    /** Constructor of a Drink */
    public Drink(String name, double price)
    {
        super(name, price);
    }

    /**
     * Calculate the calories of a Drink
     * @return a double amount
     */
    @Override
    public double calculateCalories()
    {
        return 50;
    }
}