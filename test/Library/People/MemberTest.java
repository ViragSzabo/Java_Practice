package Library.People;

import Library.Book;
import Library.Enums.Genre;
import Library.Exceptions.BookNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest
{
    private Member member;
    private Book book;

    @BeforeEach
    void setUp()
    {
        this.member = new Member("Bianca", "Santiago");
        this.book = new Book("Alice in Wonderland", "Lewis Carroll", "9789025884659", Genre.FANTASY);
    }

    @Test
    void setName()
    {
        assertEquals("Bianca Santiago", member.getName());
        member.setFirstName("Bia");
        assertEquals("Bia Santiago", member.getName());
    }

    @Test
    void borrowBook()
    {
        assertEquals(0, member.getBorrowedBooks().size());
        member.borrowBook(book);
        assertEquals(1, member.getBorrowedBooks().size());
    }

    @Test
    void calculateFine() throws BookNotFound {
        member.borrowBook(book);
        member.getBorrowedBooks().put(book, LocalDate.now().minusDays(8));
        assertEquals(15.0, member.calculateFine(book));
        member.payFine();
        assertEquals(0.0, member.getPayFine());
        member.returnBook(book);
        assertThrows(BookNotFound.class, () -> member.calculateFine(book));
    }

    @Test
    void returnBook() throws BookNotFound {
        member.borrowBook(book);
        member.payFine();
        assertEquals(0.0, member.calculateFine(book));
        member.returnBook(book);
        assertThrows(BookNotFound.class, () -> member.returnBook(book));
    }
}