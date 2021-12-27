import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MissedCalls {
    private Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void addMissedCall(String missedNumber) {
        LocalDateTime lt = LocalDateTime.now();
        missedCalls.put(lt, missedNumber);
    }

    public void clearContact() {
        missedCalls.clear();
    }

    public void displayMissedCalls(PhoneContacts phoneContacts, MissedCalls _missedCalls) {
        System.out.println("Missed calls list: ");
        for (Map.Entry<LocalDateTime, String> entry : _missedCalls.getMissedCalls()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd");
            String formatDateTime = entry.getKey().format(formatter);
            String name = phoneContacts.getContacts().get(entry.getValue()).getName();
            String surName = phoneContacts.getContacts().get(entry.getValue()).getSurname();
            if (phoneContacts.getContacts().containsKey(entry.getValue())) {
                System.out.format("%s%5s%8s\n", formatDateTime,name,surName);
            } else {
                System.out.println(formatDateTime+" "+entry.getValue());
            }
        }
    }

    public Set<Map.Entry<LocalDateTime, String>> getMissedCalls() {
        return missedCalls.entrySet();
    }
}
