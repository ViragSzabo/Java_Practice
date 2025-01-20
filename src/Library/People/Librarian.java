package Library.People;

import Library.Book;
import Library.Exceptions.BookNotFound;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Librarian extends Person
{
    /**
     * Parameters of the member
     */
    private final int MINIMUM_BORROWED_DAYS = 30;

    /**
     * Constructor of the member
     * @param firstName, lastName
     */
    public Librarian(String firstName, String lastName)
    {
        super(firstName, lastName);
    }

    /**
     * Get the amount that needs to be paid by the librarian
     * @return a double
     */
    @Override
    public double calculateFine(Book book) throws BookNotFound
    {
        if(!getBorrowedBooks().containsKey(book))
        {
            throw new BookNotFound();
        }

        LocalDate borrowedDate = getBorrowedBooks().get(book);
        LocalDate deadline = borrowedDate.plusDays(MINIMUM_BORROWED_DAYS);

        if (LocalDate.now().isAfter(deadline)) {
            long daysLate = ChronoUnit.DAYS.between(deadline, LocalDate.now());
            setPayFine(daysLate * 2.0);
        }
        return getPayFine();
    }
}