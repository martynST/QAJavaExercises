import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
    Person p;
    String name;
    int age;
    String jobTitle;

    @Before
    public void setUp()
    {
        p = new Person(name,age,jobTitle);
        String name = "jim";
        int age = 42;
        String jobTitle = "Stuff Do-er";
    }
    @Test
    public void testGetName()
    {
        assertEquals(name,p.getName());
    }
    @Test
    public void testGetAge()
    {
        assertEquals(age,p.getAge());
    }
    @Test
    public void testGetJobTitle()
    {
        assertEquals(jobTitle,p.getJobTitle());
    }
    @Test
    public void testToString()
    {
        assertEquals(name +" is "+age+" years old, and works as a(n) "+jobTitle,p.toString());
    }
}