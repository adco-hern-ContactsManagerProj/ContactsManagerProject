import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactsApp extends Methods implements ContactInterface{

    public static void main(String[] args) throws IOException {
        boolean exit;
        Scanner scan = new Scanner(System.in);

        do {
            mainMenu();
            System.out.println("Enter an option (1, 2, 3, 4 or 5):");
            int userInput = scan.nextInt();

            if (userInput == 1) {
                contactsList();
                System.out.println();
            } else if (userInput == 2) {
                addContact();
                System.out.println();
            } else if (userInput == 3) {
                searchContactName();
                System.out.println();
            } else if (userInput == 4) {
                deleteContact();
                System.out.println();
            } else if (userInput == 5) {
                System.out.println("Thank you! have a nice day");
            } else {
                System.out.println();
                mainMenu();
            }
            if(userInput == 5){
                exit = false;
            }else{
                exit = true;
            }
        }while (exit);
    }
}