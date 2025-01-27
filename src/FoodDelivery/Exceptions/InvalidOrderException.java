package FoodDelivery.Exceptions;

public class InvalidOrderException extends Exception
{
    public InvalidOrderException()
    {
        System.out.println("Invalid order");
    }
}