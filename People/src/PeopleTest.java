import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class PeopleTest {
    ArrayList<Person> people;
    @Before
    public void makePeople()
    {
        people = new ArrayList<Person>();
        people.add(new Person("jim",23,"Stuff Do-er"));
        people.add(new Person("jimmy",24,"Person Be-er"));
        people.add(new Person("jimbob",88,"Thing Thinker"));
    }
    @Test
    public void test1()
    {
        People myPeople = new People();
        for (Person p : people)
        {
            assertEquals(p,myPeople.findPerson(people,p.getName()));
        }
    }
    @Test
    public void test2()
    {
        People myPeople = new People();
        assertEquals(null, myPeople.findPerson(people,"jimithy"));
    }
}