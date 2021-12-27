import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public  static void main(String[] args) {
        PhoneContacts phoneContacts = new PhoneContacts();
        addGroup(phoneContacts);
        phoneContacts.displayContacts();
        addContact(phoneContacts);
        phoneContacts.displayContacts();
    }

    public static   void addGroup(PhoneContacts phoneContacts) {
        Scanner scanner = new Scanner(System.in);
        String s = "";
        while (!"end".equals(s)) {
            System.out.println("Write group's name for add. For exit enter 'end'.");
            s = scanner.next();
            if ("end".equals(s)) {
                break;
            }
            phoneContacts.addGroup(s);
        }
    }

    private static void addContact(PhoneContacts phoneContacts) {
        Scanner scanner = new Scanner(System.in);
        String inputGroup = "";
        String inputContact = "";
        while (!"end".equals(inputGroup)) {
            System.out.println("Write lists of groups divided by space (Could be more than 1)." +
                    " For exit enter 'end'.");
            inputGroup = scanner.nextLine();
            if ("end".equals(inputGroup)) {
                break;
            }
            String[] groups = inputGroup.split(" ");
            phoneContacts.displayContacts();
            System.out.println("Write *lastName firstName mobileNumber*");
            inputContact = scanner.nextLine();
            String[] contactBIO = inputContact.split(" ");
            Contact contact;
            if (contactBIO.length == 3) {
                contact = new Contact(contactBIO[0] + " " + contactBIO[1], contactBIO[2]);
            } else {
                System.out.println("Try again. Should be name a phone number");
                continue;
            }
            phoneContacts.addContact(contact, groups);
        }
    }
}

