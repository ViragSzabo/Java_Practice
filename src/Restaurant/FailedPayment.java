package Restaurant;

public class FailedPayment extends Exception
{
    public FailedPayment()
    {
        System.out.println("Not enough money to pay the bill.");
    }
}