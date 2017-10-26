public class CanBorrow extends Item {
    private boolean isCheckedOut;
    private Person checkedOutBy;

    public CanBorrow(String type, String title, String author, int year)
    {
        super(type, title, author, year);
        this.isCheckedOut = false;
    }
    public CanBorrow(String type, String title, String author, int year, int id)
    {
        super(type, title, author, year, id);
        this.isCheckedOut = false;
    }

    public void checkOut(Person p)
    {
        isCheckedOut = true;
        checkedOutBy = p;
        p.checkOut(this);
    }
    public void syncPerson(Person p)
    {
        isCheckedOut = true;
        checkedOutBy = p;
    }
    public void checkIn()
    {
        checkedOutBy.checkIn(this);
        isCheckedOut = false;
    }

    public boolean getIsCheckedOut()
    {
        return isCheckedOut;
    }

    public String toString() {
        return super.toString();
    }
}
