package Library;

public class Book
{
    private String title;
    private String author;
    private String ISBN;
    private Genre genre;

    public Book(String title, String author, String ISBN, Genre genre)
    {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}