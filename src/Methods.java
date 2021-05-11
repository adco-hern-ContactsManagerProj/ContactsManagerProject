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

    public static void contactsList() throws IOException {
        List<String> contact = Arrays.asList(
                "Name | Phone number",
                "-------------------",
                "Lebron James | 210-199-1999",
                "Michael Jordan | 210-299-2999",
                "Carmelo Anthony | 210-399-3999"
        );

        Files.write(contactsTxtPath, contact);

        List<String> contactList = Files.readAllLines(contactsTxtPath);

        for (String Contacts : contactList) {
            System.out.println(Contacts);
        }
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

    public static void searchContactName(){

    }

    public static void deleteContact(){

    }
}
