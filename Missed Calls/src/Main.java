import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        PhoneContacts phoneContacts = new PhoneContacts();
        MissedCalls missedCalls = new MissedCalls();
        Scanner scanner = new Scanner(System.in);
        int chooseAction;
        String input = "";
        while (!"6".equals(input)) {
            System.out.println("Menu:\n" +
                    "1. Add contact\n" +
                    "2. Add missed call\n" +
                    "3. Display all missed calls\n" +
                    "4. Clear missed calls\n" +
                    "5. Find contact by phone\n" +
                    "6. Exit\n"+
                    "Select an item from the menu (1-5):");
            input = scanner.nextLine();
            try {
                chooseAction = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Choose action 1-5. Try again");
                continue;
            }
            Contact contact;
            switch (chooseAction) {
                case 1:
                    System.out.println("Enter new contact.\n" +
                            "Write his *Name Surname PhoneNumber Group* separated by 'space'.");

                    String contactBIO = scanner.nextLine();
                    String[] contactInfo = contactBIO.split(" ");
                    if (contactInfo.length == 4) {
                        contact = new Contact(contactInfo[0], contactInfo[1],
                                contactInfo[2], Group.valueOf(contactInfo[3]));
                        if (phoneContacts.getContacts().containsValue(contact)) {
                            System.out.println("This contact exists");
                        } else {
                            phoneContacts.addContact(contactInfo[2], contact);
                            phoneContacts.displayContacts();
                        }
                    } else {
                        System.out.println("Write his Name, Surname, Phone number, Group. Try again");
                        continue;
                    }
                    break;
                case 2:
                    System.out.println("Add missed call number");
                    String ring = scanner.nextLine();
                    missedCalls.addMissedCall(ring);
                    break;
                case 3:
                    System.out.println("Missed calls:");
                    missedCalls.displayMissedCalls(phoneContacts, missedCalls);
                    break;
                case 4:
                    missedCalls.clearContact();
                    System.out.println("Missed calls has been cleared");
                    break;
                case 5:
                    System.out.println("Write number to find Contact by number");
                    String number = scanner.nextLine();
                    contact = phoneContacts.searchContactByPhoneNumber(number);
                    System.out.println(contact);
                    break;
            }
        }
    }
}
