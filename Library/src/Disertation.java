import java.util.ArrayList;

public class Disertation extends CanBorrow implements Academic{
    private ArrayList<Item> citations = new ArrayList<Item>();
    public Disertation (String title, String author, int year)
    {
        super(title, author, year, "Disertation");
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
