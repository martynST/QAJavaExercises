import java.io.*;
import java.util.ArrayList;

public class Library {
    private int idItem = 0;
    private int idPerson = 0;
    ArrayList<Item> library = new ArrayList<Item>();
    ArrayList<Person> members = new ArrayList<Person>();

    public void checkOut(Item i, Person p)
    {
        if (i instanceof CanBorrow)
        {
            if (!((CanBorrow) i).getIsCheckedOut() && p.getMaxBorrow() > p.getBorrowed().size())
                ((CanBorrow) i).checkOut(p);
        } else {

        }
    }
    public void checkIn(Item i)
    {
        if (i instanceof CanBorrow)
            ((CanBorrow) i).checkIn();
    }
    public void addItem(Item i)
    {
        library.add(i);
        i.setId(++idItem);
    }
    public void removeItem(Item i)
    {
        library.remove(i);
        i.setId(0);
    }

    public void registerPerson(Person p, int maxBorrow)
    {
        if (!p.getIsRegistered())
        {
            members.add(p);
            p.register(++idPerson, maxBorrow);
        }
    }
    public void registerPerson(Person p)
    {
        registerPerson(p,5);
    }
    public void deletePerson(Person p)
    {
        if (p.getIsRegistered())
        {
            members.remove(p);
            p.removed();
        }
    }

    public void updateItemTitle(Item i, String title)
    {
        i.updateTitle(title);
    }
    public void updateItemAuthor(Item i, String author)
    {
        i.updateAuthor(author);
    }
    public void updateItemYear(Item i, int year)
    {
        i.updateYear(year);
    }
    public void updateItemType(Item i, String type)
    {
        i.updateType(type);
    }
    public void update(Item i, String title, String author, int year, String type)
    {
        i.update(title,author,year,type);
    }

    public void updatePerson(Person p, String name)
    {
        p.update(name);
    }
    public void updatePerson(Person p, int maxBorrow)
    {
        p.update(maxBorrow);
    }
    public void updatePerson(Person p, String name, int maxBorrow)
    {
        p.update(name, maxBorrow);
    }

    public String toString()
    {
        String returnString = "LIBRARY\n\n";
        for (Item i : library)
        {
            returnString += i.toString() + "\n";
        }
        returnString += "\n\nMEMBERS\n\n";
        for (Person p : members)
        {
            returnString += p.toString() + "\n";
        }
        return returnString;
    }

    public void writeLibrary(String path)
    {
        BufferedWriter bw = null;

        try {

            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (Item i : library)
            {
                String thisItem = i.toString();
                bw.write(thisItem);
                bw.newLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw!=null)
                    bw.close();
            } catch (Exception ex) {
                System.out.println("Error in closing the buffered Writer"+ex);
            }
        }
    }
    public void readLibrary(String path)
    {
        BufferedReader br = null;
        ArrayList<String> lines = new ArrayList<String>();
        try
        {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);

            String holder;

            while ((holder = br.readLine()) != null) {
                lines.add(holder);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (Exception ex){
                System.out.println("Error in closing the buffered Reader");
            }
        }
        parseLines(lines);
    }
    private void parseLines(ArrayList<String> lines)
    {
        ArrayList<Person> people = new ArrayList<Person>();
        ArrayList<String> inputs = new ArrayList<String>();
        for (String s : lines)
        {
            while (s.indexOf(",") != -1)
            {
                inputs.add(s.substring(s.indexOf(":")+2,s.indexOf(",")));
                s = s.replace(s,s.substring(s.indexOf(",") + 2));
            }
            inputs.add(s.substring(s.indexOf(":")+2,s.indexOf(".")));
            try {
                //people.add(new Person(inputs.get(0),inputs.get(1),Integer.parseInt(inputs.get(2))));
            } catch (Exception e) {
                System.out.println("Error parsing integer" + e);
            }
        }
    }
}
