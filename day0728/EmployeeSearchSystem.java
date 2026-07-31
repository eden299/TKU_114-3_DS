package day0728;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class EmployeeSearchSystem {
    public static int binarySearch(Employee[] employees, int targetId) {
        if (employees == null || employees.length == 0) {
            return -1;
        }

        int low = 0;
        int high = employees.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (employees[mid].getId() == targetId) {
                return mid;
            } else if (employees[mid].getId() < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static boolean hasDuplicateIds(Employee[] employees) {
        for (int i = 0; i < employees.length - 1; i++) {
            if (employees[i].getId() == employees[i + 1].getId()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Employee[] employees = {
            new Employee(1005, "Alice", "HR", "101"),
            new Employee(1001, "Bob", "IT", "102"),
            new Employee(1008, "Charlie", "Finance", "103"),
            new Employee(1003, "David", "Sales", "104"),
            new Employee(1003, "Eve", "Marketing", "105") // Duplicate ID test
        };

        // Sort employees by ID
        Arrays.sort(employees, Comparator.comparingInt(Employee::getId));

        // Check for duplicates
        if (hasDuplicateIds(employees)) {
            System.out.println("Warning: Duplicate employee IDs detected in system!");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID to search: ");
        int searchId = scanner.nextInt();

        int resultIndex = binarySearch(employees, searchId);

        if (resultIndex != -1) {
            System.out.println("Employee Found: " + employees[resultIndex]);
        } else {
            System.out.println("Employee with ID " + searchId + " not found.");
        }

        // Test Empty Array
        Employee[] emptyEmployees = {};
        System.out.println("\nTesting empty array search:");
        int emptyResult = binarySearch(emptyEmployees, 1001);
        System.out.println("Result on empty array: " + emptyResult);

        scanner.close();
    }
}
