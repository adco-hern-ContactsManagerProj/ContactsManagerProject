import javax.lang.model.util.ElementScanner6;
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

    public static List<String> contactsList() throws IOException {
        List<String> contactList = Files.readAllLines(contactsTxtPath);
        for (String Contacts : contactList) {
            System.out.println(Contacts);
        }
        return contactList;
    }

    public static List<String> contactStrings() throws IOException {
        return Files.readAllLines(contactsTxtPath);
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

    public static void searchContactName() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Who would you like to search for: ");
        String userSearch = scanner.next();
        List<String> searchList = contactStrings();
        if (userSearch.length() <= 1){
            for(String contact : searchList){
                if(contact.contains(userSearch)){
                    System.out.println("Great! We found who you were looking for: ");
                    System.out.println(contact);
                }else{
                    continue;
                }
            }
        } else {
            System.out.println("Sorry we did not find who you were looking for, Please try again.");
        }
    }

    public static void deleteContact() throws IOException {

        System.out.println(contactsList());

    }
}
