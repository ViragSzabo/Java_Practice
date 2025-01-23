package Business.Exceptions;

public class CALCULATE_EARNINGS_WITHOUT_SALE extends Exception
{
    public CALCULATE_EARNINGS_WITHOUT_SALE()
    {
        System.out.println("Invalid calculation without sales.");
    }
}