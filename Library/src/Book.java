public class Book extends CanBorrow{
    private String cover;
    private boolean isFiction;
    private String genre;


    public Book (String title, String author, int year, String cover, String genre, boolean isFiction)
    {
        super(title, author, year, "Book");
        this.cover = cover;
        this.genre = genre;
        this.isFiction = isFiction;
    }
    public String toString()
    {
        return cover + " " + super.toString() + ", Genre: " + genre;
    }
}
