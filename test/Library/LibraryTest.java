package Library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest
{
    private Library library;
    private Book book;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    void setUp()
    {
        this.library = new Library("Sunshine");
        this.book = new Book("Alice in Wonderland", "Lewis Carroll", "9789025884659", Genre.FANTASY);
        this.book1 = new Book("Alice in Wonderland 2", "Lewis Carroll", "9789025884659", Genre.FANTASY);
        this.book2 = new Book("Wicked", "Gregory Maguire", "9780062852847", Genre.SCHOOL);
        this.book3 = new Book("Wicked 2", "Gregory Maguire", "9780062852847", Genre.SCHOOL);
    }

    @Test
    void setName()
    {
        assertEquals("Sunshine", library.getName());
        library.setName("Too Sunny To Shine");
        assertEquals("Too Sunny To Shine", library.getName());
    }

    @Test
    void addBook()
    {
        assertEquals(0, library.getBooks().size());
        library.addBook(book);
        library.addBook(book1);
        assertEquals(2, library.getBooks().size());
        library.addBook(book2);
        library.addBook(book3);
        assertEquals(4, library.getBooks().size());
        assertThrows(IllegalArgumentException.class, () -> library.addBook(book));
        assertThrows(IllegalArgumentException.class, () -> library.addBook(book1));
        assertThrows(IllegalArgumentException.class, () -> library.addBook(book2));
        assertThrows(IllegalArgumentException.class, () -> library.addBook(book3));
    }

    @Test
    void removeBook()
    {
        assertEquals(0, library.getBooks().size());
        library.addBook(book);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        assertEquals(4, library.getBooks().size());
        library.removeBook(book);
        library.removeBook(book1);
        assertEquals(2, library.getBooks().size());
        assertThrows(IllegalArgumentException.class, () -> library.removeBook(book));
    }
}