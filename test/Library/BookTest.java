package Library;

import Library.Enums.Genre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book;

    @BeforeEach
    void setUp() {
        this.book = new Book("Alice in Wonderland", "Lewis Carroll", "9789025884659", Genre.FANTASY);
    }

    @Test
    void setTitle() {
        assertEquals("Alice in Wonderland", book.getTitle());
        book.setTitle("Wicked");
        assertEquals("Wicked", book.getTitle());
    }

    @Test
    void setAuthor() {
        assertEquals("Lewis Carroll", book.getAuthor());
        book.setAuthor("Gregory Maguire");
        assertEquals("Gregory Maguire", book.getAuthor());
    }

    @Test
    void setISBN() {
        assertEquals("9789025884659", book.getISBN());
        book.setISBN("9780062852847");
        assertEquals("9780062852847", book.getISBN());
    }

    @Test
    void setGenre() {
        assertEquals(Genre.FANTASY, book.getGenre());
        book.setGenre(Genre.SCHOOL);
        assertEquals(Genre.SCHOOL, book.getGenre());
    }
}