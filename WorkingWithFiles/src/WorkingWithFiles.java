import java.io.*;
import java.util.ArrayList;

public class WorkingWithFiles {
    public static void main(String[] args)
    {
        WorkingWithFiles myClass = new WorkingWithFiles();
        ArrayList<Person> people = myClass.makePeople();
        myClass.writeToFile(people);
        ArrayList<Person> people2 = myClass.parseLines(myClass.readFromFile());
        System.out.println(people2);

    }
    public void writeToFile(ArrayList<Person> people)
    {
        BufferedWriter bw = null;

        try {

            File file = new File("C:\\Users\\Admin\\Documents\\people.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (Person p : people)
            {
                String thisGuy = p.toString();
                bw.write(thisGuy);
                bw.newLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw!=null)
                    bw.close();
            } catch (Exception ex) {
                System.out.println("Error in closing the bufferedWritter"+ex);
            }
        }
    }
    public ArrayList<String> readFromFile()
    {
        BufferedReader br = null;
        ArrayList<String> lines = new ArrayList<String>();
        try
        {
            File file = new File("C:\\Users\\Admin\\Documents\\people.txt");
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
                System.out.println("Error in closing the bufferedReader");
            }
        }
        return lines;
    }
    public ArrayList<Person> makePeople()
    {
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("jim","stuff do-er",23));
        people.add(new Person("jimbo","person be-er",32));
        people.add(new Person("jimmy","thing thinker",24));
        people.add(new Person("jimbob","the Universe",42));
        people.add(new Person("jimithy","being old",372));
        return people;
    }
    public ArrayList<Person> parseLines(ArrayList<String> lines)
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
                people.add(new Person(inputs.get(0),inputs.get(1),Integer.parseInt(inputs.get(2))));
            } catch (Exception e) {
                System.out.println("Error parsing integer" + e);
            }
        }
        return people;
    }
}
