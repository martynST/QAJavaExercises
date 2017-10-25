import java.util.ArrayList;

public class People {
    public static void main(String[] args)
    {

    }
    public Person findPerson(ArrayList<Person> people, String name)
    {
        for (Person p : people)
        {
            if (p.getName().equals(name))
            {
                return p;
            }
        }
        return null;
    }
}
