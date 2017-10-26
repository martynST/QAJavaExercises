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
        if (isRegistered)
            return "ID: " + id + ", Name: " + name + ", Max Borrow Allowance: " + maxBorrow + ".";
        else
            return "Name: " + name + ".";
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
