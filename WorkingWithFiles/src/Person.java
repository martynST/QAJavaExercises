public class Person {
    private String name;
    private String occupation;
    private int age;

    public Person(String name, String occupation, int age)
    {
        this.name = name;
        this.occupation = occupation;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }
    public String toString()
    {
        return "Name: " + name + ", Occupation: " + occupation + ", Age: " + age+".";
    }
}
