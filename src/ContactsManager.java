import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ContactsManager {
    Scanner scanner = new Scanner(System.in);

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
                Files.write(contactFile, contactText);
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void addContact(){
        try{
            Path contactDirectory = Paths.get(directory);
            Path contactFile = Paths.get(directory, fileName);
            System.out.println("Please enter name:");
            String nameInput = scanner.nextLine();
            System.out.println("Please enter number:");
            String numInput =scanner.nextLine();
            numInput = addDashes(numInput);

            Files.write(contactFile, List.of(nameInput + " | " + numInput + " |"), StandardOpenOption.APPEND);

        }catch(IOException e){
            e.printStackTrace();
        }


    }

    public void deleteContact(){
        try{
            List<String> contactData = Files.readAllLines(Paths.get(directory, fileName));
            System.out.println("Please enter name to be deleted:");
            String input = scanner.nextLine();
            List<String> newList = new ArrayList<>();

            for(String contact: contactData){
                if(contact.contains(input)){
                    continue;
                }
                newList.add(contact);
            }

            Files.write(Paths.get(directory, fileName), newList);
            contactData = Files.readAllLines(Paths.get(directory, fileName));
            printList();

        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void printList(){
        try{
            List<String> contactData = Files.readAllLines(Paths.get(directory, fileName));
            System.out.println("Name | Phone Number\n");

            for (String contact: contactData){
                System.out.println(contact);
            }
            System.out.println("");

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void searchContact(){
        try{
            List<String> contactData = Files.readAllLines(Paths.get(directory, fileName));
            System.out.println("Please enter name to be searched:");
            String input = scanner.nextLine();
            System.out.println("Name | Phone Number\n");

            for(String contact: contactData) {
                if (contact.contains(input)) {
                    System.out.println(contact);
                }
            }
            System.out.println("");
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    //got info for pattern from: https://howtodoinjava.com/java/string/format-phone-number/#:~:text=Given%20below%20is%20a%20Java,%2D%23%23%23%23%20format.&text=String%20input%20%3D%20%221234567890%22%20%3B,%241)%20%242%2D%243%22%20)%3B
    public String addDashes(String num){
        try {
            if(num.length() == 10){
               String one = num.substring(0,3);
               String two = num.substring(3,6);
               String three = num.substring(6);
//                System.out.printf("(%s) %s-%s%n",one,two,three);
                return "(" + one + ") " + two + "-" + three;
            }

            if(num.length() == 7){
                return num.replaceFirst("(\\d{3})(\\d+)", "$1-$2");
            }


        }catch(Exception e){
            e.printStackTrace();
        }
        return num;
    }

}
