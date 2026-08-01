package day0730;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class OrderManagementPractice {
    private Map<String, Order> masterData = new HashMap<>();
    private Queue<Order> pendingQueue = new LinkedList<>();
    private Stack<Order> completedStack = new Stack<>();

    public boolean addOrder(Order order) {
        if (order == null || order.getId() == null) {
            return false;
        }
        if (masterData.containsKey(order.getId())) {
            System.out.println("Error: Duplicate Order ID (" + order.getId() + ")");
            return false;
        }
        masterData.put(order.getId(), order);
        pendingQueue.offer(order);
        System.out.println("Added: " + order);
        return true;
    }

    public void peekNextPendingOrder() {
        if (pendingQueue.isEmpty()) {
            System.out.println("No pending orders available.");
        } else {
            System.out.println("Next Pending Order: " + pendingQueue.peek());
        }
    }

    public Order processNextOrder() {
        if (pendingQueue.isEmpty()) {
            System.out.println("Cannot process: Pending Queue is empty.");
            return null;
        }
        Order order = pendingQueue.poll();
        completedStack.push(order);
        System.out.println("Processed: " + order);
        return order;
    }

    public void printSortedOrdersByAmount() {
        Order[] ordersArr = masterData.values().toArray(new Order[0]);
        OrderAlgorithms.mergeSortByAmountDesc(ordersArr, 0, ordersArr.length - 1);
        System.out.println("=== Orders Sorted by Amount (Desc) ===");
        for (Order o : ordersArr) {
            System.out.println(o);
        }
    }

    public void searchOrdersByCustomer(String customerName) {
        Order[] ordersArr = masterData.values().toArray(new Order[0]);
        List<Order> found = OrderAlgorithms.searchByCustomerName(ordersArr, customerName);
        System.out.println("=== Search Results for Customer '" + customerName + "' ===");
        if (found.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            for (Order o : found) {
                System.out.println(o);
            }
        }
    }

    public static void main(String[] args) {
        OrderManagementPractice system = new OrderManagementPractice();

        System.out.println("--- Test 1: Empty Queue & Stack Operations ---");
        system.peekNextPendingOrder();
        system.processNextOrder();
        system.searchOrdersByCustomer("Alice");
        System.out.println();

        System.out.println("--- Test 2: Adding Orders & Duplicate Check ---");
        system.addOrder(new Order("O101", "Alice", 250.0));
        system.addOrder(new Order("O102", "Bob", 450.5));
        system.addOrder(new Order("O103", "Alice", 120.0));
        system.addOrder(new Order("O101", "Charlie", 300.0)); 
        System.out.println();

        System.out.println("--- Test 3: Peek & Process Orders ---");
        system.peekNextPendingOrder();
        system.processNextOrder();
        system.peekNextPendingOrder();
        System.out.println();

        System.out.println("--- Test 4: Merge Sort by Amount (Desc) ---");
        system.printSortedOrdersByAmount();
        System.out.println();

        System.out.println("--- Test 5: Customer Search (Existing & Missing) ---");
        system.searchOrdersByCustomer("Alice");
        system.searchOrdersByCustomer("David");
    }
}
