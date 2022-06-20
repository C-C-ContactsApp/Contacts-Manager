public class ContactsManagerTest {
    public static void main(String[] args) {
        ContactsManager contactList = new ContactsManager();

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");

        contactList.createContactList();
    }
}
