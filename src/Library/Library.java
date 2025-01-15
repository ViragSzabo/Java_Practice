package Library;

import java.util.HashMap;

public class Library
{
    private String name;
    private HashMap<Book, Integer> books;

    public Library(String name)
    {
        this.name = name;
        this.books = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Book, Integer> getBooks() {
        return books;
    }

    public void addBook(Book book)
    {
        if(books.containsKey(book))
        {
            throw new IllegalArgumentException("Book already exists");
        }
        else {
            books.put(book, 1);
        }
    }

    public void removeBook(Book book)
    {
        if(books.containsKey(book))
        {
            books.remove(book);
        }
        else
        {
            throw new IllegalArgumentException("Book not found");
        }
    }
}