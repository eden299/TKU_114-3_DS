package day0730;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class RepairSchedulingSystem {
    private List<RepairTask> allTasks = new ArrayList<>();
    private Queue<RepairTask> pendingQueue = new LinkedList<>();
    private Stack<RepairTask> completedStack = new Stack<>();
    private int autoOrderCounter = 1;

    public boolean addRepairTask(String id, String deviceName, int priority) {
        for (RepairTask t : allTasks) {
            if (t.getId().equalsIgnoreCase(id)) {
                System.out.println("Error: Duplicate Task ID (" + id + "). Task rejected.");
                return false;
            }
        }
        RepairTask task = new RepairTask(id, deviceName, priority, autoOrderCounter++);
        allTasks.add(task);
        pendingQueue.offer(task);
        System.out.println("Registered Task: " + task);
        return true;
    }

    public RepairTask processNextTask() {
        if (pendingQueue.isEmpty()) {
            System.out.println("Process failed: No pending tasks in queue.");
            return null;
        }
        RepairTask task = pendingQueue.poll();
        completedStack.push(task);
        System.out.println("Processed Task: " + task);
        return task;
    }

    public RepairTask undoLastCompletedTask() {
        if (completedStack.isEmpty()) {
            System.out.println("Undo failed: Completed stack is empty.");
            return null;
        }
        RepairTask task = completedStack.pop();
        pendingQueue.offer(task);
        System.out.println("Undone Task (Returned to Pending): " + task);
        return task;
    }

    public void sortPendingTasksByPriority() {
        if (pendingQueue.isEmpty()) {
            System.out.println("Queue is empty, nothing to sort.");
            return;
        }
        RepairTask[] tasksArr = pendingQueue.toArray(new RepairTask[0]);
        RepairAlgorithms.mergeSortByPriorityDesc(tasksArr, 0, tasksArr.length - 1);
        
        pendingQueue.clear();
        for (RepairTask t : tasksArr) {
            pendingQueue.offer(t);
        }
        System.out.println("=== Pending Queue Sorted by Priority (Stable) ===");
        for (RepairTask t : pendingQueue) {
            System.out.println(t);
        }
    }

    public void searchTaskById(String id) {
        System.out.println("=== Search Task by ID '" + id + "' ===");
        RepairTask found = RepairAlgorithms.searchById(allTasks, id);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Result: Task not found.");
        }
    }

    public void searchTaskByDeviceName(String deviceName) {
        System.out.println("=== Search Task by Device Name '" + deviceName + "' ===");
        List<RepairTask> results = RepairAlgorithms.searchByDeviceName(allTasks, deviceName);
        if (results.isEmpty()) {
            System.out.println("Result: No tasks found for this device.");
        } else {
            for (RepairTask t : results) {
                System.out.println(t);
            }
        }
    }

    public void displayStatistics() {
        System.out.println("=== System Statistics ===");
        System.out.println("Total Registered Tasks : " + allTasks.size());
        System.out.println("Pending Tasks Queue    : " + pendingQueue.size());
        System.out.println("Completed Tasks Stack  : " + completedStack.size());
    }

    public static void main(String[] args) {
        RepairSchedulingSystem system = new RepairSchedulingSystem();

        System.out.println("--- Test 1: System Statistics & Empty State Operations ---");
        system.displayStatistics();
        system.processNextTask();
        system.undoLastCompletedTask();
        System.out.println();

        System.out.println("--- Test 2: Add Tasks (Including Same Priority & Duplicates) ---");
        system.addRepairTask("T01", "Laptop", 2);
        system.addRepairTask("T02", "Server", 5);
        system.addRepairTask("T03", "Printer", 2);
        system.addRepairTask("T04", "Router", 5);
        system.addRepairTask("T05", "Monitor", 1);
        system.addRepairTask("T01", "Duplicate Laptop", 3);
        System.out.println();

        System.out.println("--- Test 3: Stable Merge Sort Verification ---");
        system.sortPendingTasksByPriority();
        System.out.println();

        System.out.println("--- Test 4: Queue, Stack & Restore (Undo) Functionality ---");
        system.processNextTask();
        system.processNextTask();
        system.displayStatistics();
        system.undoLastCompletedTask();
        system.displayStatistics();
        System.out.println();

        System.out.println("--- Test 5: Search Functions (ID & Device Name) ---");
        system.searchTaskById("T03");
        system.searchTaskById("T99");
        system.searchTaskByDeviceName("Laptop");
        system.searchTaskByDeviceName("Projector");
    }
}
