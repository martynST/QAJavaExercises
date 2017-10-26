import java.util.ArrayList;

public class Disertation extends CanBorrow implements Academic{
    private ArrayList<Item> citations = new ArrayList<Item>();
    public Disertation (String title, String author, int year, ArrayList<Item> citations)
    {
        super("Disertation", title, author, year);
        this.citations = citations;
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
