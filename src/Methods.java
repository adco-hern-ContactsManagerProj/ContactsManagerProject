import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;


public abstract class Methods implements ContactInterface {
    public static void mainMenu() throws IOException{

        List<String> MainMenu = Arrays.asList(
                "View contacts.",
                "Add a new contact.",
                "Search a contact by name.",
                "Delete an existing contact.",
                "Exit."
        );

        Files.write(menuTxtPath, MainMenu);

        List<String> menuList = Files.readAllLines(menuTxtPath);

        for(int i = 0; i < menuList.size(); i += 1){
            System.out.println((i + 1) + ": " + menuList.get(i));
        }

    }

    public static String contactsList() throws IOException {
//        List<String> contact = Arrays.asList(
//                "Name | Phone number",
//                "-------------------",
//                "Lebron James | 210-199-1999",
//                "Michael Jordan | 210-299-2999",
//                "Carmelo Anthony | 210-399-3999"
//        );
//
//        Files.write(contactsTxtPath, contact);

        List<String> contactList = Files.readAllLines(contactsTxtPath);
        String listOfContacts = "";
        for (String Contacts : contactList) {
            System.out.println(Contacts);
            listOfContacts = Contacts;
        }
        return listOfContacts;
    }

    public static void addContact() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in the new contact you want to add:");
        String userStringInput = scanner.nextLine();
        System.out.println("Type in the new phone number for your new contact:");
        long userIntegerInput = scanner.nextInt();
        Files.write(
                Paths.get(directory, contacts),
                Arrays.asList(userStringInput + " | " + userIntegerInput),
                StandardOpenOption.APPEND
        );

        List<String> contactList = Files.readAllLines(contactsTxtPath);
        for (String newContactList : contactList) {
            System.out.println(newContactList);

        }
    }

    public static String searchContactName() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String userSearch = scanner.next();
        System.out.println("Who would you like to search for: ");
        if(contactsList().contains(userSearch)){
            System.out.println("Great! We found who you were looking for: ");

        }else{
            System.out.println("Sorry we could not find a user with that name, please try again");
            searchContactName();
        }
        return userSearch;
    }

    public static void deleteContact(){

    }
}
