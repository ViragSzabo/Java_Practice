package Business.Exceptions;

public class REMOVE_NOT_EXISTED_MEMBER extends Exception
{
    public REMOVE_NOT_EXISTED_MEMBER()
    {
        System.out.println("Invalid Operation: The member does not exist.");
    }
}
