package FoodDelivery.Orders;

import FoodDelivery.Exceptions.InvalidGivenID;
import FoodDelivery.Exceptions.InvalidOrderException;

public abstract class Order
{
    /** Parameters of the Order */
    private int orderID;
    private int customerID;
    private final double price;

    /** Constructor of the Order with parameter validation */
    public Order(int orderID, int customerID) throws InvalidGivenID
    {
        if (orderID <= 0 || customerID <= 0)
        {
            throw new InvalidGivenID();
        }
        this.orderID = orderID;
        this.customerID = customerID;
        this.price = 0.0;
    }

    /** Calculate the total price of the order */
    public abstract double calculateTotalPrice() throws InvalidOrderException;

    /**
     * Get the order ID
     * @return an int is the ID
     */
    public int getOrderID()
    {
        return orderID;
    }

    /**
     * Set the order ID
     * @param orderID is the new ID
     */
    public void setOrderID(int orderID) throws InvalidGivenID
    {
        if(orderID <= 0)
        {
            throw new InvalidGivenID();
        }
        this.orderID = orderID;
    }

    /**
     * Get the customer ID
     * @return an int is the ID
     */
    public int getCustomerID()
    {
        return customerID;
    }

    /**
     * Set the customer ID
     * @param customerID is the new ID
     */
    public void setCustomerID(int customerID) throws InvalidGivenID
    {
        if(customerID <= 0)
        {
            throw new InvalidGivenID();
        }
        this.customerID = customerID;
    }

    /**
     * Get the price
     * @return a double is the price
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Provide readable summary of the object
     * For debugging and logging purposes only
     * @return a string of summary info
     */
    public abstract String toString();
}