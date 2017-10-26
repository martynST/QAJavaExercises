import java.util.ArrayList;
import java.util.Scanner;

public class CommandLineInterface {

    private Scanner input = new Scanner(System.in);
    Library library = new Library();
    private boolean keepGoing = true;

    public static void main(String[] args)
    {

        CommandLineInterface clm = new CommandLineInterface();
        clm.welcome();
        boolean keepGoing = true;
        while (keepGoing)
            clm.listener();

    }
    public void welcome()
    {
        System.out.println("Hello, and welcome to The Library! If you would like a list of commands type, help");
    }
    public void listener()
    {
        String userInput = input.nextLine();
        userInput = userInput.toUpperCase();
        switch (userInput)
        {
            case "HELP":
                getHelp();
                break;
            case "ADD ITEM":
                addItem();
                break;
            case "REMOVE ITEM":
                removeItem();
                break;
            case "":


        }
    }
    private void getHelp()
    {
        System.out.println("Here are a list of commands.");
        System.out.println("Add Item: Add an item to The Library.");
        System.out.println("Remove Item: Remove an item from The Library.");
        System.out.println("Check in: Check out an item from The Library.");
        System.out.println("check out: Check out an item from The Library.");
        System.out.println("Update Item: Update the information of an item.");
        System.out.println("Register Person: Register a new person at The Library.");
        System.out.println("Delete Person: Delete a person from The Library.");
        System.out.println("Update Person: Update a registered person's information.");
    }
    private void addItem()
    {
        System.out.print("What Type of item would you like to add: ");
        String type = nextLine();
        while(!isValidType(type))
        {
            System.out.print("Invalid type. Valid types are Book, Disertation, and Thesis\nPlease enter the item type: ");
            type = nextLine();
        }

        System.out.print("Title: ");
        String title = nextLine();
        System.out.print("Author: ");
        String author = nextLine();
        System.out.print("Year: ");
        String year = nextLine();
        while (!isValidNum(year))
        {
            System.out.print("Invalid year\nPlease input the year of release: ");
            year = input.nextLine();
        }

        switch (type) {
            case "BOOK":
                System.out.print("Backing: ");
                String cover = nextLine();
                while (!isValidBacking(cover))
                {
                    System.out.print("Invalid backing. Valid backings are Hardback, Paperback, Library\nPlease enter the backing type:" );
                    cover = nextLine();
                }
                System.out.print("Genre: ");
                String genre = nextLine();
                System.out.print("Fiction or Non-fiction: ");
                String fNf = nextLine();
                while (!isValidFiction(fNf))
                {
                    System.out.print("Invalid input. Type whether the book is Fiction or Non-fiction\nPlease enter the backing type: " );
                    fNf = nextLine();
                }
                boolean isFiction;
                if (fNf.equals("FICTION"))
                    isFiction = true;
                else
                    isFiction = false;
                library.addItem(new Book(title,author,Integer.parseInt(year), cover, genre, isFiction));
                System.out.println("Book added!");
                break;
            case "Disertation":
                ArrayList<Item> citationsD = getCitations();
                library.addItem(new Disertation(title, author, Integer.parseInt(year), citationsD));
                System.out.println("Disertation added!");
                break;
            case "THESIS":
                ArrayList<Item> citationsT = getCitations();
                library.addItem(new Thesis(title, author, Integer.parseInt(year), citationsT));
                System.out.println("Thesis added!");
                break;
        }
    }
    private void removeItem()
    {

        while (true)
        {
            System.out.print("Please enter the ID of the item you would like to remove:");
            String id = nextLine();
            if (id.equals("CANCEL"))
                break;
            if (isValidNum(id))
            {
                library.removeItem(library.searchById(Integer.parseInt(id)));
            }

        }

    }
    private boolean isValidType(String type)
    {
        if (type.equals("BOOK"))
            return true;
        else if (type.equals("DISERTATION"))
            return true;
        else if (type.equals("THESIS"))
            return true;
        else
            return false;
    }
    private boolean isValidNum(String year)
    {
        try
        {
            Integer.parseInt(year);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    private boolean isValidBacking(String cover)
    {
        if (cover.equals("HARDBACK"))
            return true;
        else if (cover.equals("PAPERBACK"))
            return true;
        else if (cover.equals("LIBRARY"))
            return true;
        else
            return false;
    }
    private boolean isValidFiction(String fNf)
    {
        if (fNf.equals("FICTION"))
            return true;
        else if (fNf.equals("NON-FICTION"))
            return true;
        else
            return false;
    }
    private boolean isValidYesNo(String yesNO)
    {
        if (yesNO.equals("YES"))
            return true;
        else if (yesNO.equals("NO"))
            return true;
        else
            return false;
    }
    private ArrayList<Item> getCitations()
    {
        System.out.print("Would you like to add any citations? ");
        String yesNo = nextLine();
        while(!isValidYesNo(yesNo))
        {
            System.out.print("Invalid input, please type yes or no\nWould you like to add any citations? ");
            yesNo = nextLine();
        }
        ArrayList<Item> citations = new ArrayList<Item>();
        if (yesNo.equals("YES"))
        {
            while (true)
            {
                System.out.print("please enter the ID of the book you would like to add to the citations, type Cancel to finish adding citations: ");
                String id = nextLine();
                if (id.equals("CANCEL"))
                    break;
                if (isValidNum(id))
                {
                    citations.add(library.searchById(Integer.parseInt(id)));
                    System.out.println("Citation added");
                }

            }
        }
        return citations;
    }
    private String nextLine()
    {
        return input.nextLine().toUpperCase();
    }
}
