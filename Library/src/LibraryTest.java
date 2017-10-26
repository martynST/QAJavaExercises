import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class LibraryTest {

    Library library;
    Person p;
    Book b;
    @Before
    public void setup()
    {
        library = new Library();
        p = new Person("Martyn");
        b = new Book("The Name of the Wind", "Patrick Rothfuss", 2007, "Hard Back", "Fantasy", true);
    }
    @Test
    public void test()
    {
        library.registerPerson(p);
        library.addItem(b);
        assertEquals("LIBRARY\n\nHard Back Book, ID: 1, Title: The Name of the Wind, Author: Patrick Rothfuss, Year: 2007, Genre: Fantasy\n\n\nMEMBERS\n\nID: 1, Name: Martyn, Max Borrow Allowance: 5.\n",library.toString());
        library.deletePerson(p);
        library.removeItem(b);
        assertEquals("LIBRARY\n\n\n\nMEMBERS\n\n",library.toString());
    }
    @Test
    public void testCheckInOut()
    {
        library.registerPerson(p);
        library.addItem(b);
        library.checkOut(b,p);
        assertEquals(b.toString(),p.getBorrowed().get(0).toString());
        library.checkIn(b);
    }
    @Test
    public void testReadWrite()
    {
        String path = "C:\\Users\\Admin\\IdeaProjects\\QAJavaExercises\\QAJavaExercises\\Library\\Library.txt";
    }
}