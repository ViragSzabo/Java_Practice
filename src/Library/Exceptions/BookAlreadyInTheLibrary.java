package Library.Exceptions;

public class BookAlreadyInTheLibrary extends Exception
{
    public BookAlreadyInTheLibrary()
    {
        super("Book already exist in the library");
    }
}