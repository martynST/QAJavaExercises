import java.util.LinkedList;

public class Person {
    private String name;
    private int id;
    private boolean isRegistered = false;
    private int maxBorrow;
    private LinkedList<Item> borrowed = new LinkedList<Item>();

    public Person (String name)
    {
        this.name = name;
    }
    public Person (int id, String name, int maxBorrow, LinkedList<Item> borrowed)
    {
        this.name = name;
        this.id = id;
        this.maxBorrow = maxBorrow;
        this.borrowed = borrowed;
        this.isRegistered = true;
    }

    public void checkOut(Item i)
    {
        borrowed.add(i);
    }
    public void checkIn(Item i)
    {
        borrowed.remove(i);
    }
    public void register(int id, int maxBorrow)    {
        this.isRegistered = true;
        this.id = id;
        this.maxBorrow = maxBorrow;
    }
    public void removed()
    {
        isRegistered = false;
        this.id = 0;
    }

    public void update(String name)
    {
        this.name = name;
    }
    public void update(int maxBorrow)
    {
        this.maxBorrow = maxBorrow;
    }
    public void update(String name, int maxBorrow)
    {
        this.name = name;
        this.maxBorrow = maxBorrow;
    }

    public String toString()
    {
        String returnString;
        if (isRegistered)
        {
            returnString =  id + "," + name + "," + maxBorrow;
            if (borrowed.size() != 0)
            {
                returnString += ",";
                for (int i = 0; i < borrowed.size(); i++)
                {
                    returnString += borrowed.get(i).getId();
                    if (i != borrowed.size() -1 )
                        returnString += ",";
                }
            }
            return returnString;
        }
        else
            return name;
    }
    public void syncWithItems()
    {
        for (Item i : borrowed)
        {
            ((CanBorrow)i).syncPerson(this);
        }
    }


    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public int getMaxBorrow()
    {
        return maxBorrow;
    }
    public LinkedList<Item> getBorrowed()
    {
        return borrowed;
    }
    public boolean getIsRegistered ()
    {
        return isRegistered;
    }
}
