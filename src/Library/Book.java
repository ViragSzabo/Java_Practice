package Library;

import Library.Enums.Genre;

public class Book
{
    /**
     * Parameters of the library
     */
    private String title;
    private String author;
    private String ISBN;
    private Genre genre;

    /**
     * Constructor of the bookj
     * @param title
     * @param author
     * @param ISBN
     * @param genre
     */
    public Book(String title, String author, String ISBN, Genre genre)
    {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
    }

    /**
     * Get the title of the book
     * @return a string
     */
    public String getTitle() {
        return title;
    }

    /**
     * Change the title of the book
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the author of the book
     * @return a string
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Change the author of the book
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Get the ISBN of the book
     * @return a string
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Change the isbn of the book
     * @param ISBN
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Get the genre of the book
     * @return a string
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Change the genre of the book
     * @param genre
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}