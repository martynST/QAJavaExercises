import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

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
    public void addItems(ArrayList<Item> myItems)
    {
        for (Item i : myItems)
            this.addItem(i);
    }
    public void removeItems(ArrayList<Item> myItems)
    {
        for (Item i : myItems)
            this.removeItem(i);
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
        returnString += "\nMEMBERS\n\n";
        for (Person p : members)
        {
            returnString += p.toString() + "\n";
        }
        return returnString;
    }
    public Item searchById(int id)
    {
        for (Item i : library)
        {
            if (i.getId() == id)
                return i;
        }
        return null;
    }

    public void writeLibrary(String path)
    {
        write(library.toArray(), path+"\\Library.txt");
        write(members.toArray(), path+"\\Members.txt");
    }
    private void write(Object[] myList, String path)
    {
        BufferedWriter bw = null;
        try {

            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (Object o : myList)
            {
                String thisElement = o.toString();
                bw.write(thisElement);
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
        ArrayList<String> itemString = read(path+"\\Library.txt");
        ArrayList<String> memberString = read(path+"\\Members.txt");
        importItems(parseString(itemString));
        importMembers(parseString(memberString));
        syncLibrary();
    }
    private ArrayList<String> read(String path)
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
        return lines;
    }
    private ArrayList<ArrayList<String>> parseString(ArrayList<String> lines)
    {
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < lines.size(); i++)
        {
            listOfLists.add((new ArrayList<String>()));
            while (lines.get(i).indexOf(",") != -1)
            {
                listOfLists.get(i).add(lines.get(i).substring(0,lines.get(i).indexOf(",")));
                lines.set(i,lines.get(i).substring(lines.get(i).indexOf(",")+1));
            }
            listOfLists.get(i).add(lines.get(i));
        }
        return listOfLists;
    }
    private void importItems(ArrayList<ArrayList<String>> myItems)
    {
        library.removeAll(library);
        for (ArrayList<String> arr : myItems)
        {
            try {
                int year = Integer.parseInt(arr.get(3));
                int id = Integer.parseInt(arr.get(4));
                boolean isFiction = Boolean.parseBoolean(arr.get(7));
                library.add(new Book(arr.get(0),arr.get(1),arr.get(2),year,id,arr.get(5),arr.get(6),isFiction));
            } catch (Exception e) {
                System.out.println("Import error");
            }
        }
    }
    private void importMembers(ArrayList<ArrayList<String>> myItems)
    {
        members.removeAll(members);
        for (ArrayList<String> arr : myItems)
        {
            try {
                LinkedList<Item> borrowed = new LinkedList<>();
                for (int i = 3; i < arr.size(); i++)
                {
                    borrowed.add(this.searchById(Integer.parseInt(arr.get(i))));
                }
                members.add(new Person(Integer.parseInt(arr.get(0)),arr.get(1),Integer.parseInt(arr.get(2)), borrowed));
            } catch (Exception e) {
                System.out.println("Import error");
            }
        }
    }
    public void reset()
    {
        library.removeAll(library);
        members.removeAll(members);
    }
    public void syncLibrary()
    {

    }
}
