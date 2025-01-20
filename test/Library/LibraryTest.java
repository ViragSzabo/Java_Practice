package Library;

import Library.Enums.Genre;
import Library.Exceptions.BookAlreadyInTheLibrary;
import Library.Exceptions.BookNotFound;
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
        try {
            assertEquals(0, library.getBooks().size());
            library.addBook(book);
            library.addBook(book1);
            assertEquals(2, library.getBooks().size());
            library.addBook(book2);
            library.addBook(book3);
            assertEquals(4, library.getBooks().size());
        } catch (BookAlreadyInTheLibrary e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void removeBook() throws BookAlreadyInTheLibrary, BookNotFound {
            assertEquals(0, library.getBooks().size());
            library.addBook(book);
            library.addBook(book1);
            library.addBook(book2);
            library.addBook(book3);
            assertEquals(4, library.getBooks().size());

            library.removeBook(book);
            library.removeBook(book1);
            assertEquals(2, library.getBooks().size());

            assertThrows(BookNotFound.class, () -> library.removeBook(book));
            assertThrows(BookNotFound.class, () -> library.removeBook(book1));
            assertThrows(BookAlreadyInTheLibrary.class, () -> library.addBook(book2));
            assertThrows(BookAlreadyInTheLibrary.class, () -> library.addBook(book3));
    }
}