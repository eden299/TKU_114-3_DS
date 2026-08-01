package day0729;

import java.util.Arrays;

public class InsertionSortPractice {
    public static void main(String[] args) {
        int[] original = {30, 10, 20, 50, 40, 5};
        int[] sorted = {5, 10, 20, 30, 40, 50};
        int[] reverseSorted = {50, 40, 30, 20, 10, 5};

        System.out.println("=== 1. Original Data ===");
        insertionSort(original.clone());

        System.out.println("\n=== 2. Already Sorted Data ===");
        insertionSort(sorted.clone());

        System.out.println("\n=== 3. Reverse Sorted Data ===");
        insertionSort(reverseSorted.clone());

        System.out.println("\n=== Summary ===");
        System.out.println("The reverse sorted data requires the most shift operations because every element must be moved to the front.");
    }

    public static void insertionSort(int[] arr) {
        int comparisons = 0;
        int shifts = 0;

        System.out.println("Initial Array: " + Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;

            System.out.println("Round " + i + " -> key: " + key + ", inserted position: " + (j + 1) + ", array: " + Arrays.toString(arr));
        }

        System.out.println("Final Sorted Array: " + Arrays.toString(arr));
        System.out.println("Total Comparisons: " + comparisons + ", Total Shifts: " + shifts);
    }
}
