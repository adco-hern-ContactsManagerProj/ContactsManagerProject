import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

interface ContactInterface {
    String directory = "./src/TxtFiles";
    String mainMenu = "mainMenu.txt";
    String contacts = "contacts.txt";
    Path menuTxtPath = Paths.get(directory, mainMenu);
    Path contactsTxtPath = Paths.get(directory, contacts);

}
