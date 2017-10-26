import java.util.ArrayList;

public class Thesis extends CantBorrow implements Academic{
    private ArrayList<Item> citations = new ArrayList<Item>();

    public Thesis (String title, String author, int year)
    {
        super(title, author, year, "Thesis");
    }
    public void addCitation(Item i)
    {
        this.citations.add(i);
    }
    public void removeCitation(Item i)
    {
        this.citations.remove(i);
    }

}
