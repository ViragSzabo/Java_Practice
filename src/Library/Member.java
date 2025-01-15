package Library;

import java.time.*;
import java.util.*;

public class Member
{
    private String name;
    private final HashMap<Book, LocalDate> borrowedBooks;
    private final int MINIMUM_BORROWED_DAYS = 5;
    private double payFine;

    public Member(String name)
    {
        this.name = name;
        this.borrowedBooks = new HashMap<>();
        this.payFine = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Book, LocalDate> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book)
    {
        this.borrowedBooks.put(book, LocalDate.now());
    }

    public double getPayFine() {
        return payFine;
    }

    public void setPayFine(double payFine) {
        this.payFine = payFine;
    }

    public void returnBook(Book book)
    {
        if(borrowedBooks.containsKey(book))
        {
            LocalDate borrowedDate = borrowedBooks.get(book);
            LocalDate deadline = borrowedDate.plusDays(MINIMUM_BORROWED_DAYS);
            if (LocalDate.now().isAfter(deadline)) {
                long daysLate = Period.between(deadline, LocalDate.now()).getDays();
                payFine += daysLate * 1.0;
            }
            borrowedBooks.remove(book);
        }
        else
        {
            throw new IllegalArgumentException("Book is not found");
        }
    }
}