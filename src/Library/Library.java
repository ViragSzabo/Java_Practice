package Library;

import Library.Exceptions.BookAlreadyInTheLibrary;
import Library.Exceptions.BookNotFound;

import java.util.*;

public class Library
{
    /**
     * Parameters of the library
     */
    private String name;
    private final ArrayList<Book> books;

    /**
     * Constructor of the library
     * @param name
     */
    public Library(String name)
    {
        this.name = name;
        this.books = new ArrayList<>();
    }

    /**
     * Get the name of the library
     * @return a string
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Change the name of the library
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get all the books from the library
     * @return a list of books
     */
    public ArrayList<Book> getBooks()
    {
        return this.books;
    }

    /**
     * Add a new book to the library
     * @param book
     * @throws BookAlreadyInTheLibrary
     */
    public void addBook(Book book) throws BookAlreadyInTheLibrary
    {
        if(this.books.contains(book))
        {
            throw new BookAlreadyInTheLibrary();
        }
        else {
            this.books.add(book);
        }
    }

    /**
     * Remove a book from the library
     * @param book
     * @throws BookNotFound
     */
    public void removeBook(Book book) throws BookNotFound
    {
        if(this.books.contains(book))
        {
            this.books.remove(book);
        }
        else
        {
            throw new BookNotFound();
        }
    }
}