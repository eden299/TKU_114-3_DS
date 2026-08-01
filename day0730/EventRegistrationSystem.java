package day0730;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class EventRegistrationSystem {
    private int capacity;
    private List<Registration> registeredList = new ArrayList<>();
    private Queue<Registration> waitlistQueue = new LinkedList<>();
    private Stack<Registration> canceledStack = new Stack<>();
    private Set<String> allIds = new HashSet<>();

    public EventRegistrationSystem(int capacity) {
        this.capacity = capacity;
    }

    public boolean register(String id, String name) {
        if (id == null || name == null) return false;

        if (allIds.contains(id)) {
            System.out.println("Error: Duplicate Registration ID (" + id + "). Registration rejected.");
            return false;
        }

        Registration reg = new Registration(id, name);
        allIds.add(id);

        if (registeredList.size() < capacity) {
            registeredList.add(reg);
            System.out.println("Successfully Registered: " + reg);
        } else {
            waitlistQueue.offer(reg);
            System.out.println("Capacity Full! Added to Waitlist: " + reg);
        }
        return true;
    }

    public boolean cancelRegistration(String id) {
        Registration target = null;
        for (Registration reg : registeredList) {
            if (reg.getId().equalsIgnoreCase(id)) {
                target = reg;
                break;
            }
        }

        if (target == null) {
            System.out.println("Error: Cancellation failed. ID (" + id + ") not found in active registrations.");
            return false;
        }

        registeredList.remove(target);
        canceledStack.push(target);
        System.out.println("Cancelled Registration: " + target);

        if (!waitlistQueue.isEmpty()) {
            Registration promoted = waitlistQueue.poll();
            registeredList.add(promoted);
            System.out.println("Promoted from Waitlist to Active: " + promoted);
        } else {
            System.out.println("Waitlist is empty. Slot left vacant.");
        }
        return true;
    }

    public boolean undoLastCancellation() {
        if (canceledStack.isEmpty()) {
            System.out.println("Undo failed: No cancelled registrations to restore.");
            return false;
        }

        Registration restored = canceledStack.pop();

        if (registeredList.size() < capacity) {
            registeredList.add(restored);
            System.out.println("Restored to Active List: " + restored);
        } else {
            Registration demoted = registeredList.remove(registeredList.size() - 1);
            ((LinkedList<Registration>) waitlistQueue).addFirst(demoted);
            registeredList.add(restored);
            System.out.println("Restored to Active List: " + restored);
            System.out.println("Demoted to Waitlist Head: " + demoted);
        }
        return true;
    }

    public void searchById(String id) {
        if (registeredList.isEmpty()) {
            System.out.println("Search failed: Registered list is empty.");
            return;
        }
        Registration[] arr = registeredList.toArray(new Registration[0]);
        RegistrationAlgorithms.mergeSortByIdAsc(arr, 0, arr.length - 1);
        Registration found = RegistrationAlgorithms.binarySearchById(arr, id);

        System.out.println("=== Binary Search ID '" + id + "' ===");
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Result: Registration ID not found.");
        }
    }

    public void searchByName(String name) {
        System.out.println("=== Sequential Search Name '" + name + "' ===");
        List<Registration> found = RegistrationAlgorithms.sequentialSearchByName(registeredList, name);
        if (found.isEmpty()) {
            System.out.println("Result: No registrations found for this name.");
        } else {
            for (Registration reg : found) {
                System.out.println(reg);
            }
        }
    }

    public void printStatus() {
        System.out.println("=== System Status ===");
        System.out.println("Active Registrations (" + registeredList.size() + "/" + capacity + "): " + registeredList);
        System.out.println("Waitlist Queue Count: " + waitlistQueue.size());
        System.out.println("Cancelled Stack Count: " + canceledStack.size());
    }

    public static void main(String[] args) {
        EventRegistrationSystem system = new EventRegistrationSystem(3);

        System.out.println("--- Test 1: Capacity & Waitlist Queue ---");
        system.register("R03", "Alice");
        system.register("R01", "Bob");
        system.register("R04", "Charlie");
        system.register("R02", "David"); 
        system.register("R05", "Eve");   
        system.printStatus();
        System.out.println();

        System.out.println("--- Test 2: Duplicate ID Check ---");
        system.register("R01", "DuplicateBob");
        System.out.println();

        System.out.println("--- Test 3: Search Functions ---");
        system.searchById("R01");
        system.searchById("R99");
        system.searchByName("Charlie");
        system.searchByName("Unknown");
        System.out.println();

        System.out.println("--- Test 4: Cancellation & Waitlist Promotion ---");
        system.cancelRegistration("R99"); 
        system.cancelRegistration("R01"); 
        system.printStatus();
        System.out.println();

        System.out.println("--- Test 5: Undo Cancellation ---");
        system.undoLastCancellation();
        system.printStatus();
    }
}
