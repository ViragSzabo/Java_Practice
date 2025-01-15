package Library;

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
        this.member = new Member("Bianca");
        this.book = new Book("Alice in Wonderland", "Lewis Carroll", "9789025884659", Genre.FANTASY);
    }

    @Test
    void setName()
    {
        assertEquals("Bianca", member.getName());
        member.setName("Bia");
        assertEquals("Bia", member.getName());
    }

    @Test
    void setPayFine()
    {
        assertEquals(0.0, member.getPayFine());
        member.setPayFine(1.0);
        assertEquals(1.0, member.getPayFine());
    }

    @Test
    void borrowBook()
    {
        assertEquals(0, member.getBorrowedBooks().size());
        member.borrowBook(book);
        assertEquals(1, member.getBorrowedBooks().size());
    }

    @Test
    void returnBook()
    {
        member.borrowBook(book);
        LocalDate borrowDate = LocalDate.now().minusDays(5);
        member.getBorrowedBooks().put(book, borrowDate);
        member.returnBook(book);
        assertEquals(0, member.getBorrowedBooks().size());
        assertEquals(0.0, member.getPayFine());
        assertThrows(IllegalArgumentException.class, () -> member.returnBook(new Book("Wicked", "Dongan", "958485305", Genre.SCHOOL)));

        Book book2 = new Book("Wicked", "Dongan", "958485305", Genre.SCHOOL);
        member.borrowBook(book2);
        LocalDate borrowDate2 = LocalDate.of(2025, 01, 02);
        member.getBorrowedBooks().put(book2, borrowDate2);
        member.returnBook(book2);
        assertEquals(8.0, member.getPayFine());
    }
}