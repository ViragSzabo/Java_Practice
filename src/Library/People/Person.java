package Library.People;

import Library.Book;
import Library.Exceptions.BookNotFound;

import java.time.LocalDate;
import java.util.HashMap;

public abstract class Person
{
    /**
     * Parameters of the member
     */
    private String firstName;
    private String lastName;
    private HashMap<Book, LocalDate> borrowedBooks;
    private double payFine;

    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        borrowedBooks = new HashMap<>();
        payFine = 0.0;
    }

    /**
     * Get the name of the library
     * @return a string
     */
    public String getName()
    {
        return firstName + " " + lastName;
    }

    /**
     * Change the first name of the member
     * @param firstName
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Change the last name of the member
     * @param lastName
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Get the list of the borrowed books by the member
     * @return a hashmap with the date that it was borrowed out each book
     */
    public HashMap<Book, LocalDate> getBorrowedBooks()
    {
        return borrowedBooks;
    }

    /**
     * Borrow a book
     * @param book
     */
    public void borrowBook(Book book)
    {
        this.borrowedBooks.put(book, LocalDate.now());
    }

    /**
     * The book is returned by the member
     * @param book
     * @throws BookNotFound
     */
    public void returnBook(Book book) throws BookNotFound
    {
        if(borrowedBooks.containsKey(book))
        {
            borrowedBooks.remove(book);
        }
        else
        {
            throw new BookNotFound();
        }
    }

    /**
     * Get the pay fine
     * @return a double amount
     */
    public double getPayFine() {
        return payFine;
    }

    /**
     * Change the pay fine
     * @param payFine
     */
    public void setPayFine(double payFine) {
        this.payFine = payFine;
    }

    /**
     * Pay the fine by the member
     * @return a clear double amount
     */
    public void payFine()
    {
        System.out.println("Pay Fine: " + this.payFine);
        this.setPayFine(0.0);
    }

    public abstract double calculateFine(Book book) throws BookNotFound;
}