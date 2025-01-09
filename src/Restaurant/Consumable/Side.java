package Restaurant.Consumable;

public class Side extends Consumable
{
    public Side(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateCalories() {
        return this.price * 5;
    }
}