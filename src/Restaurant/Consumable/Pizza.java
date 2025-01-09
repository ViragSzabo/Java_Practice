package Restaurant.Consumable;

public class Pizza extends Consumable
{
    public Pizza(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateCalories() {
        return this.price * 10;
    }
}