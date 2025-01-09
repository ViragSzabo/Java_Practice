package Restaurant.Consumable;

public class Drink extends Consumable
{
    public Drink(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateCalories() {
        return this.price * 2;
    }
}