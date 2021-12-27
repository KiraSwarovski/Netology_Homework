import java.util.*;
import java.util.Collections;

public class PhoneContacts {
    private Map<String, LinkedList<Contact>> listOfContacts = new HashMap<>();



    public void addGroup(String group) {
        if (listOfContacts.containsKey(group)) {
            System.out.printf("This %s is already exist", group);
        } else {
            listOfContacts.put(group, new LinkedList<>());
        }
    }

    public void addContact(Contact contact, String[] contactsInfo) {
        Comparable comparable = new Comparable();
        for (String checkName : contactsInfo) {
            if (listOfContacts.containsKey(checkName)) {
                int indexOf = Math.abs(Collections.binarySearch
                        (listOfContacts.get(checkName), contact, comparable)) - 1;
                listOfContacts.get(checkName).add(indexOf,contact);
            } else {
                System.out.println("This group doesn't exist");
            }
        }
    }

    public void displayContacts() {
        if (listOfContacts.isEmpty()) {
            System.out.println("Empty List");
        } else {
            System.out.println("Phone Book:");
            for (Map.Entry<String, LinkedList<Contact>> myGroupsEntry : listOfContacts.entrySet()) {
                System.out.println(" Group:" + myGroupsEntry.getKey());
                System.out.println("People: ");
                Iterator it = myGroupsEntry.getValue().iterator();
                while (it.hasNext()) {
                    System.out.println(it.next().toString());
                }
            }
        }
    }
}
