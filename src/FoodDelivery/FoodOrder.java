package FoodDelivery;

import java.util.ArrayList;

public class FoodOrder extends Order implements Deliverable
{
    /** Parameter of the FoodOrder */
    private final ArrayList<FoodType> foods;

    /** Constructor */
    public FoodOrder(int orderID, int customerID)
    {
        super(orderID, customerID);
        this.foods = new ArrayList<>();
    }

    /**
     * Calculate the total price of the order
     * @return a double
     * @throws InvalidOrderException if there is no order
     */
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

    /**
     * Calculate the total delivery fee based on the quantity of the order
     * @return a double
     */
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

    /**
     * Get the order list
     * @return a list
     */
    public ArrayList<FoodType> getType()
    {
        return this.foods;
    }

    /**
     * Add a new order to the list
     * @param type is the new order
     */
    public void addFood(FoodType type)
    {
        this.foods.add(type);
    }
}