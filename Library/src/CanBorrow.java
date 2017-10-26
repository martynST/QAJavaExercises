public class CanBorrow extends Item {
    private boolean isCheckedOut;
    private Person checkedOutBy;

    public CanBorrow(String title, String author, int year, String type)
    {
        super(title, author, year, type);
        this.isCheckedOut = false;
    }

    public void checkOut(Person p)
    {
        isCheckedOut = true;
        checkedOutBy = p;
        p.checkOut(this);
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
}
