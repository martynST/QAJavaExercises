public class Book extends CanBorrow{
    private String cover;
    private boolean isFiction;
    private String genre;


    public Book (String title, String author, int year, String cover, String genre, boolean isFiction)
    {
        super("book", title, author, year);
        this.cover = cover;
        this.genre = genre;
        this.isFiction = isFiction;
    }
    public Book (String type, String title, String author, int year, int id, String cover, String genre, boolean isFiction)
    {
        super("book", title, author, year, id);
        this.cover = cover;
        this.genre = genre;
        this.isFiction = isFiction;

    }
    public String toString()
    {
        return super.toString() + "," + cover + "," + genre + "," + isFiction;
    }
}
