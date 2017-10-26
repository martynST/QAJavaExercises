import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

public class LibraryTest {

    Library library;
    Person p1, p2;
    Book b1, b2, b3;
    ArrayList<Item> myItems = new ArrayList<Item>();
    ArrayList<Person> myPeople = new ArrayList<Person>();
    String path = "C:\\Users\\Admin\\IdeaProjects\\QAJavaExercises\\QAJavaExercises\\Library";

    @Before
    public void setup()
    {

        library = new Library();
        p1 = new Person("Martyn");
        p2 = new Person("Merril");
        b1 = new Book("The Name of the Wind", "Patrick Rothfuss", 2007, "Hard Back", "Fantasy", true);
        b2 = new Book("The Wise Mans Fear", "Patrick Rothfuss", 2011, "Hard Back", "Fantasy", true);
        b3 = new Book("The Door in the Stone", "Patrick Rothfuss", 3001, "Hard Back", "Fantasy", true);
        myItems.add(b1);
        myItems.add(b2);
        myItems.add(b3);
        myPeople.add(p1);
        myPeople.add(p2);
    }
    @Test
    public void test()
    {
        library.registerPerson(p1);
        library.addItem(b1);
        //has changed
        assertEquals("LIBRARY\n\nbook,The Name of the Wind,Patrick Rothfuss,2007,1,Hard Back,Fantasy,true\n\nMEMBERS\n\n1,Martyn,5\n",library.toString());
        library.deletePerson(p1);
        library.removeItem(b1);
        assertEquals("LIBRARY\n\n\nMEMBERS\n\n",library.toString());
    }
    @Test
    public void testCheckInOut()
    {
        library.registerPerson(p1);
        library.addItem(b1);
        library.checkOut(b1,p1);
        assertEquals(b1.toString(),p1.getBorrowed().get(0).toString());
        library.checkIn(b1);
    }
    @Test
    public void testAddItems ()
    {
        ArrayList<Item> myItems = new ArrayList<Item>();
        myItems.add(b1);
        myItems.add(b2);
        myItems.add(b3);
        library.addItems(myItems);
    }
    @Test
    public void testWrite()
    {
        library.registerPerson(p1);
        library.registerPerson(p2);
        library.addItems(myItems);
        library.checkOut(b1,p1);
        library.checkOut(b2,p1);
        library.checkOut(b3,p2);
        library.writeLibrary(path);
    }
    @Test
    public void testRead()
    {
        library.reset();
        library.readLibrary(path);
    }
    @Test
    public void testError()
    {
        library.removeItem(b1);
        library.deletePerson(p1);
    }
}