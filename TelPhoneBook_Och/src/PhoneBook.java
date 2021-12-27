import java.util.*;

public class PhoneBook {
    private HashMap<String, LinkedList<Contact>> groups;

    public PhoneBook() {
        this.groups = new HashMap<String, LinkedList<Contact>>();
    }



    public void addGroup(String groupName) {
        if (groups.containsKey(groupName)) {
            System.out.println("!!! Such a group '" + groupName + "' already exists !!!");
        } else {
            groups.put(groupName, new LinkedList<Contact>());
        }

    }

    public void addContactToGroup(Contact newContact, String[] groupNames) {
        for (String groupName : groupNames) {
            if (groups.containsKey(groupName)) {
                LinkedList<Contact>  groupContacts = null;
                groupContacts.add(newContact);
            } else {
                System.out.println("!!! Such a group '" + groupName + "' doesn't exist !!!");
                addGroup(groupName);
                System.out.println("New group '" + groupName + "' was created and it will contain contact: " + newContact.toString());
                addContactToGroup(newContact, new String[]{groupName});
            }
        }
    }

    public void displayPhoneBook() {
        if (groups.isEmpty()) {
            System.out.println("Phone Book is empty");
        } else {
            System.out.println("My Phone Book:");
            for (Map.Entry<String, LinkedList<Contact>> myGroupsEntry : groups.entrySet()) {
                System.out.println(" Group:" + myGroupsEntry.getKey());
                Iterator it = myGroupsEntry.getValue().iterator();
                while (it.hasNext()) {
                    System.out.println(it.next().toString());
                }
            }
        }
    }
}