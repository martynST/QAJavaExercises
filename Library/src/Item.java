public abstract class Item {
    private String title;
    private String author;
    private int id;
    private int year;
    private String type;

    public Item (String title, String author, int year, String type)
    {
        this.title = title;
        this.author = author;
        this.year = year;
        this.type = type;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void updateTitle(String title)
    {
        this.title = title;
    }
    public void updateAuthor(String author)
    {
        this.author = author;
    }
    public void updateYear(int year)
    {
        this.year = year;
    }
    public void updateType(String type)
    {
        this.type = type;
    }
    public void update(String title, String author, int year, String type)
    {
        this.title = title;
        this.author = author;
        this.year = year;
        this.type = type;
    }


    public int getId()
    {
        return id;
    }

    public int getYear()
    {
        return year;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getTitle()
    {
        return title;
    }

    public String getType()
    {
        return type;
    }

    public String toString()
    {
        return type + ", ID: " + id + ", Title: " + title + ", Author: " + author + ", Year: " + year;
    }
}
