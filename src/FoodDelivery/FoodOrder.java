package FoodDelivery;

import java.util.ArrayList;

public class FoodOrder extends Order implements Deliverable
{
    private final ArrayList<FoodType> foods;

    public FoodOrder(int orderID, int customerID)
    {
        super(orderID, customerID);
        this.foods = new ArrayList<>();
    }

    @Override
    public double calculateTotalPrice() throws InvalidOrderException
    {
        double totalPrice = 0;
        if(foods.isEmpty())
        {
            throw new InvalidOrderException();
        }
        for(FoodType food : foods)
        {
            totalPrice += food.getPrice();
        }
        return totalPrice + calculateDeliveryFee();
    }

    @Override
    public double calculateDeliveryFee()
    {
        double deliveryFee = 0;
        if(!foods.isEmpty() && foods.size() < 5)
        {
            deliveryFee += 0.25;
        } else if(foods.size() >= 5 && foods.size() < 10)
        {
            deliveryFee += 0.50;
        } else if(foods.size() >= 10 && foods.size() < 15)
        {
            deliveryFee += 0.75;
        }
        return deliveryFee;
    }

    public ArrayList<FoodType> getType()
    {
        return this.foods;
    }

    public void addFood(FoodType type)
    {
        this.foods.add(type);
    }
}