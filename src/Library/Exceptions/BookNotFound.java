package Library.Exceptions;

public class BookNotFound extends Exception
{
    public BookNotFound()
    {
        super("Book not found");
    }
}