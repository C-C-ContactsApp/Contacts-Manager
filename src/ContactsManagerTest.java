import java.util.Scanner;

public class ContactsManagerTest {
    public static void main(String[] args) {
        ContactsManager contactList = new ContactsManager();
        boolean willRun = true;
        do {
            System.out.println("1. View contacts.\n" +
                    "2. Add a new contact.\n" +
                    "3. Search a contact by name.\n" +
                    "4. Delete an existing contact.\n" +
                    "5. Exit.\n" +
                    "Enter an option (1, 2, 3, 4 or 5):");

            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> contactList.printList();
                case "2" -> contactList.addContact();
                case "3" -> contactList.searchContact();
                case "4" -> contactList.deleteContact();
                default -> willRun = false;

            }
        } while (willRun);

    }
}
