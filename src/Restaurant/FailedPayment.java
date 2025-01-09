package Restaurant;

public class FailedPayment extends Exception
{
    public FailedPayment(String message)
    {
        super(message);
    }
}