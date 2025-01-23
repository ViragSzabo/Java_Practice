package Business.Exceptions;

public class ADD_EXISTED_MEMBER extends Exception
{
    public ADD_EXISTED_MEMBER()
    {
        System.out.println("Invalid Operation: The member is already existing.");
    }
}