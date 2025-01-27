package FoodDelivery;

public enum FoodType
{
    PIZZA(25.0),
    BURGER(12.0),
    SUSHI(15.0),
    DESSERT(5.0);

    private final double price;

    FoodType(double price)
    {
        this.price = price;
    }

    public double getPrice()
    {
        return this.price;
    }
}