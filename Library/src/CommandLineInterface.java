import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandLineInterface {

    private Scanner input = new Scanner(System.in);
    Library library = new Library();
    private boolean keepGoing;

    public static void main(String[] args)
    {

        CommandLineInterface clm = new CommandLineInterface();
        clm.keepGoing = true;
        clm.welcome();
        while (clm.keepGoing)
            clm.listener();

    }
    public void welcome()
    {
        System.out.println("Hello, and welcome to The Library! If you would like a list of commands type, help");
    }
    public void listener()
    {
        System.out.print("Please enter command: ");
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
            case "CHECK OUT":
                checkOut();
                break;
            case "CHECK IN":
                checkIn();
                break;
            case "ADD PERSON":
                registerPerson();
                break;
            case "REMOVE PERSON":
                removePerson();
                break;
            case "EDIT ITEM":
                editItem();
                break;
            case "EDIT PERSON":
                editPerson();
                break;
            case "SAVE LIBRARY":
                saveLibrary();
                break;
            case "LOAD LIBRARY":
                loadLibrary();
                break;
            case "DISPLAY ITEMS":
                displayItems();
                break;
            case "QUIT":
            keepGoing = false;
            break;
            case "EXIT":
            keepGoing = false;
            break;
            default:
                System.out.println("Invalid input");
                break;
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
        System.out.println("Add Person: Register a new person at The Library.");
        System.out.println("Remove Person: Delete a person from The Library.");
        System.out.println("Update Person: Update a registered person's information.");
        System.out.println("Save Library: Save the library to a file.");
        System.out.println("Load Library: Load the library from a file.");
        System.out.println("Display Items: Display the items in The Library.");
        System.out.println("Exit/Quit: End the program");
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
        System.out.print("Please enter the ID of the item you would like to remove: ");
        String id = nextLine();
        if (isValidNum(id))
        {
            if (library.searchByIdItem(Integer.parseInt(id)) == null)
            {
                System.out.println("Item does not exist.");
            } else {
                System.out.println("Please confirm you would like to delete this item:\n" + library.searchByIdItem(Integer.parseInt(id)));
                String yesNo = nextLine();
                while (!isValidYesNo(yesNo))
                {
                    System.out.println("Invalid input, type yes or no.\nPlease confirm you would like to delete this item:\n" + library.searchByIdItem(Integer.parseInt(id)));
                    yesNo = nextLine();
                }
                if (yesNo.equals("YES"))
                {
                    library.removeItem(library.searchByIdItem(Integer.parseInt(id)));
                    System.out.println("Item removed!");
                }
                else
                    System.out.println("Canceled removing item.");

            }
        }
    }
    private void checkOut()
    {
        Person p = checkOutPerson();
        if (p == null)
            return;
        Item i = checkOutItem();
        if (i == null)
            return;
        library.checkOut(i,p);
        System.out.println("Item checked out!");
    }
    private Person checkOutPerson()
    {
        System.out.print("Please enter the ID of the person who is checking out an item: ");
        String idP = nextLine();
        Person p;
        if (isValidNum(idP)) {
            if (library.searchByIdPerson(Integer.parseInt(idP)) == null) {
                System.out.println("Person does not exist.");
                return null;
            } else {
                p = library.searchByIdPerson(Integer.parseInt(idP));
                System.out.println("Please confirm this correct user:\n" + p.getId() + ": " + p.getName());
                String yesNo = nextLine();
                while (!isValidYesNo(yesNo)) {
                    System.out.println("Please confirm this correct user:\n" + p.getId() + ": " + p.getName());
                    yesNo = nextLine();
                }
                if (yesNo.equals("YES")) {
                    if (p.getBorrowed().size() < p.getMaxBorrow()) {

                    } else {
                        System.out.println("Person has too many items borrowed at the moment. Please return some to take out more.");
                        return null;
                    }
                } else {
                    System.out.println("Canceled checking out item.");
                    return null;
                }
            }
        } else {
            System.out.println("Invalid id.");
            return null;
        }
        return p;
    }
    private Item checkOutItem()
    {
        System.out.print("Please enter the ID of the book you would like to check out: ");
        String idI = nextLine();
        Item i;
        if (isValidNum(idI)) {
            if (library.searchByIdItem(Integer.parseInt(idI)) == null) {
                System.out.println("Item, does not exist.");
                return null;
            } else {
                i = library.searchByIdItem(Integer.parseInt(idI));
                System.out.println("Please confirm this correct item:\n" + i.getId() + ": " + i.getTitle() + " by " + i.getAuthor());
                String yesNo = nextLine();
                while (!isValidYesNo(yesNo)) {
                    System.out.println("Please confirm this correct item:\n" + i.getId() + ": " + i.getTitle());
                    yesNo = nextLine();
                }
                if (yesNo.equals("YES")) {
                    if (i instanceof CanBorrow) {
                        if (((CanBorrow) i).getIsCheckedOut() == false) {

                        } else {
                            System.out.println("This item is current check out.");
                            return null;
                        }
                    } else {
                        System.out.println("This type of item cannot be taken out.");
                        return null;
                    }
                } else {
                    System.out.println("Canceled checking out item.");
                    return null;
                }
            }
        } else {
            System.out.println("Invalid id.");
            return null;
        }
        return i;
    }
    private void checkIn()
    {
        Person p = checkInPerson();
        Item i = checkInItem();
        if (p.inBorrowed(i))
            library.checkIn(i);
        else
            System.out.println("This person has not borrowed this item");
    }
    private Person checkInPerson()
    {
        System.out.print("Please enter the ID of the person who is checking in an item: ");
        String idP = nextLine();
        Person p;
        if (isValidNum(idP)) {
            if (library.searchByIdPerson(Integer.parseInt(idP)) == null) {
                System.out.println("Person does not exist.");
                return null;
            } else {
                p = library.searchByIdPerson(Integer.parseInt(idP));
                System.out.println("Please confirm this correct user:\n" + p.getId() + ": " + p.getName());
                String yesNo = nextLine();
                while (!isValidYesNo(yesNo)) {
                    System.out.println("Please confirm this correct user:\n" + p.getId() + ": " + p.getName());
                    yesNo = nextLine();
                }
                if (yesNo.equals("YES")) {
                    return p;
                } else {
                    System.out.println("Canceled checking in item.");
                    return null;
                }
            }
        } else {
            System.out.println("Invalid id.");
            return null;
        }
    }
    private Item checkInItem()
    {
        System.out.print("Please enter the ID of the book you would like to check in: ");
        String idI = nextLine();
        Item i;
        if (isValidNum(idI)) {
            if (library.searchByIdItem(Integer.parseInt(idI)) == null) {
                System.out.println("Item, does not exist.");
                return null;
            } else {
                i = library.searchByIdItem(Integer.parseInt(idI));
                System.out.println("Please confirm this correct item:\n" + i.getId() + ": " + i.getTitle() + " by " + i.getAuthor());
                String yesNo = nextLine();
                while (!isValidYesNo(yesNo)) {
                    System.out.println("Please confirm this correct item:\n" + i.getId() + ": " + i.getTitle());
                    yesNo = nextLine();
                }
                if (yesNo.equals("YES")) {
                    if (((CanBorrow) i).getIsCheckedOut() == true) {
                        return i;
                    } else {
                        System.out.println("This item is current not check out.");
                        return null;
                    }
                } else {
                    System.out.println("Canceled checking out item.");
                    return null;
                }
            }
        } else {
            System.out.println("Invalid id.");
            return null;
        }
    }
    private void registerPerson()
    {
        System.out.print("Please enter the name of the person: ");
        String name = input.nextLine();
        library.registerPerson(new Person(name));
        System.out.println("Person registered!");
    }
    private void removePerson()
    {
        System.out.print("Please enter the ID of the person you would like to remove: ");
        String id = nextLine();
        if (isValidNum(id))
        {
            if (library.searchByIdPerson(Integer.parseInt(id)) == null)
            {
                System.out.println("Person does not exist.");
            } else {
                System.out.println("Please confirm you would like to delete this person:\n" + library.searchByIdPerson(Integer.parseInt(id)));
                String yesNo = nextLine();
                while (!isValidYesNo(yesNo))
                {
                    System.out.println("Invalid input, type yes or no.\nPlease confirm you would like to delete this person:\n" + library.searchByIdPerson(Integer.parseInt(id)));
                    yesNo = nextLine();
                }
                if (yesNo.equals("YES"))
                {
                    library.deletePerson(library.searchByIdPerson(Integer.parseInt(id)));
                    System.out.println("Person removed!");
                }
                else
                    System.out.println("Canceled removing person.");

            }
        }
    }
    private void displayItems()
    {
        library.displayLibrary();
    }
    private void editItem()
    {
        System.out.println("PLace Holder");
    }
    private void editPerson()
    {
        System.out.println("Please enter the ");
    }
    private void saveLibrary()
    {
        System.out.print("Please enter the path of the location you would like to save the library: ");
        String path = nextLine();

        if (library.writeLibrary(path))
            System.out.println("Library saved!");
    }
    private void loadLibrary()
    {
        System.out.print("Please enter the path of the library you would like to load. Warning, this will delete your current library");
        String path = nextLine();

        if (library.readLibrary(path))
            System.out.println("Library loaded!");
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
                    citations.add(library.searchByIdItem(Integer.parseInt(id)));
                    System.out.println("Citation added");
                }

            }
        }
        return citations;
    }
    private String nextLine()
    {
        String returnString = input.nextLine().toUpperCase();
        return returnString;
    }
}
