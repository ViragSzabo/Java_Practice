package Library.People;

import Library.Book;
import Library.Enums.Genre;
import Library.Exceptions.BookNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianTest {

    private Librarian librarian;
    private Book book;

    @BeforeEach
    void setUp()
    {
        this.librarian = new Librarian("Bianca", "Santiago");
        this.book = new Book("Alice in Wonderland", "Lewis Carroll", "9789025884659", Genre.FANTASY);
    }

    @Test
    void setName()
    {
        assertEquals("Bianca Santiago", librarian.getName());
        librarian.setFirstName("Bia");
        librarian.setLastName("San");
        assertEquals("Bia San", librarian.getName());
    }

    @Test
    void borrowBook()
    {
        assertEquals(0, librarian.getBorrowedBooks().size());
        librarian.borrowBook(book);
        assertEquals(1, librarian.getBorrowedBooks().size());
    }

    @Test
    void calculateFine() throws BookNotFound {
        librarian.borrowBook(book);
        librarian.getBorrowedBooks().put(book, LocalDate.now().minusDays(31));
        assertEquals(2.0, librarian.calculateFine(book));
        librarian.payFine();
        assertEquals(0.0, librarian.getPayFine());
        librarian.returnBook(book);
        assertThrows(BookNotFound.class, () -> librarian.calculateFine(book));
    }

    @Test
    void returnBook() throws BookNotFound {
        librarian.borrowBook(book);
        librarian.payFine();
        assertEquals(0.0, librarian.calculateFine(book));
        librarian.returnBook(book);
        assertThrows(BookNotFound.class, () -> librarian.returnBook(book));
    }
}