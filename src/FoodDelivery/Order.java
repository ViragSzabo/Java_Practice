package FoodDelivery;

public abstract class Order
{
    private int orderID;
    private int customerID;
    private double price;

    public Order(int orderID, int customerID)
    {
        this.orderID = orderID;
        this.customerID = customerID;
        this.price = 0.0;
    }

    public abstract double calculateTotalPrice() throws InvalidOrderException;

    public int getOrderID()
    {
        return orderID;
    }

    public void setOrderID(int orderID)
    {
        this.orderID = orderID;
    }

    public int getCustomerID()
    {
        return customerID;
    }

    public void setCustomerID(int customerID)
    {
        this.customerID = customerID;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}