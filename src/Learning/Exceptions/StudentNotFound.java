package Learning.Exceptions;

public class StudentNotFound extends Exception
{
    public StudentNotFound(String message)
    {
        super(message);
    }
}