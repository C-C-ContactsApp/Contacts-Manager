import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsManager {

    protected String directory = "Contacts";
    protected String fileName = "contacts.text";

    public void createContactList(){

        try{
            Path contactDirectory = Paths.get(directory);
            Path contactFile = Paths.get(directory, fileName);

            if(Files.notExists(contactDirectory)){
                System.out.println("Creating new " + contactDirectory + " directory");
                Files.createDirectories(contactDirectory);
            }

            if(Files.notExists(contactFile)){
                System.out.println("[New file created]");
                Files.createFile(contactFile);
            }

            List<String> contactText = new ArrayList<>();
            contactText.add("Cody Jinks | 2812579971 |");
            contactText.add("Steve Tyler | 8325574693 |");
            contactText.add("Keith Richards | 5679843217 |");
            contactText.add("Ned Ledoux | 2814598793 |");
            contactText.add("Ward Davis | 4687224399 |");
            contactText.add("Cody Johnson | 2813753339 |");
            contactText.add("Aaron Watson | 9786354212 |");
            contactText.add("Tammy Wynette | 2579982554 |");
            contactText.add("Aaron Lewis | 2812548871 |");
            contactText.add("Billy Gibbons | 2818704453 |");

            if(Files.exists(contactFile)) {
                System.out.println("Importing Contacts");
                Files.write(contactFile, contactText);
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
