package day0728;

import java.util.Scanner;

public class AllOccurrenceSearch {
    public static void main(String[] args) {
        int[] data = {15, 42, 8, 42, 91, 42, 10, 8, 33, 42};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter target value to search: ");
        int target = scanner.nextInt();

        int occurrences = 0;
        int comparisons = 0;

        System.out.print("Found indices: ");
        for (int i = 0; i < data.length; i++) {
            comparisons++;
            if (data[i] == target) {
                System.out.print(i + " ");
                occurrences++;
            }
        }

        System.out.println();
        if (occurrences == 0) {
            System.out.println("Target " + target + " was not found in the array.");
        } else {
            System.out.println("Total occurrences: " + occurrences);
        }

        System.out.println("Total comparisons made: " + comparisons);

        scanner.close();
    }
}
