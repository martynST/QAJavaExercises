import java.util.ArrayList;

public class Library {
    private int idItem = 0;
    private int idPerson = 0;
    ArrayList<Item> library = new ArrayList<Item>();
    ArrayList<Person> members = new ArrayList<Person>();

    public void checkOut(Item i, Person p)
    {
        if (i instanceof CanBorrow)
        {
            if (!((CanBorrow) i).getIsCheckedOut() && p.getMaxBorrow() > p.getBorrowed().size())
                ((CanBorrow) i).checkOut(p);
        } else {

        }
    }
    public void checkIn(Item i)
    {
        if (i instanceof CanBorrow)
            ((CanBorrow) i).checkIn();
    }
    public void addItem(Item i)
    {
        library.add(i);
        i.setId(++idItem);
    }
    public void removeItem(Item i)
    {
        library.remove(i);
        i.setId(0);
    }

    public void registerPerson(Person p, int maxBorrow)
    {
        if (!p.getIsRegistered())
        {
            members.add(p);
            p.register(++idPerson, maxBorrow);
        }
    }
    public void registerPerson(Person p)
    {
        registerPerson(p,5);
    }
    public void deletePerson(Person p)
    {
        if (p.getIsRegistered())
        {
            members.remove(p);
            p.removed();
        }
    }

    public void updateItemTitle(Item i, String title)
    {
        i.updateTitle(title);
    }
    public void updateItemAuthor(Item i, String author)
    {
        i.updateAuthor(author);
    }
    public void updateItemYear(Item i, int year)
    {
        i.updateYear(year);
    }
    public void updateItemType(Item i, String type)
    {
        i.updateType(type);
    }
    public void update(Item i, String title, String author, int year, String type)
    {
        i.update(title,author,year,type);
    }

    public void updatePerson(Person p, String name)
    {
        p.update(name);
    }
    public void updatePerson(Person p, int maxBorrow)
    {
        p.update(maxBorrow);
    }
    public void updatePerson(Person p, String name, int maxBorrow)
    {
        p.update(name, maxBorrow);
    }

    public String toString()
    {
        String returnString = "LIBRARY\n\n";
        for (Item i : library)
        {
            returnString += i.toString() + "\n";
        }
        returnString += "\n\nMEMBERS\n\n";
        for (Person p : members)
        {
            returnString += p.toString() + "\n";
        }
        return returnString;
    }
}
