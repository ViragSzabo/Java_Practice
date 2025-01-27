package FoodDelivery.Orders;

import FoodDelivery.Deliverable;
import FoodDelivery.Exceptions.FoodTypeCannotBeNull;
import FoodDelivery.Exceptions.InvalidOrderException;
import FoodDelivery.FoodType;

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
        int size = foods.size();
        if(size >= 15) return 0.95;
        if(size >= 10) return 0.75;
        if(size >= 5) return 0.50;
        return 0.25;
    }

    @Override
    public String toString() {
        return "Order ID: " + this.getOrderID() + " - Customer ID: " + this.getCustomerID() + ": Price: " + this.getPrice();
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
    public void addFood(FoodType type) throws FoodTypeCannotBeNull
    {
        if(type == null)
        {
            throw new FoodTypeCannotBeNull();
        }
        this.foods.add(type);
    }
}