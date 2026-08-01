package day0729;

import java.util.Arrays;

public class SelectionSortPractice {
    public static void main(String[] args) {
        int[] data = {42, 18, 35, 7, 29, 14};
        
        System.out.println("=== Testing Normal Array ===");
        selectionSort(data);

        System.out.println("\n=== Testing Empty Array ===");
        selectionSort(new int[]{});

        System.out.println("\n=== Testing Single-Element Array ===");
        selectionSort(new int[]{99});
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            System.out.println("Array length is " + (arr == null ? 0 : arr.length) + ". No sorting needed.");
            System.out.println("Result: " + Arrays.toString(arr));
            System.out.println("Total Comparisons: 0, Total Swaps: 0");
            return;
        }

        int comparisons = 0;
        int swaps = 0;
        int n = arr.length;

        System.out.println("Initial Array: " + Arrays.toString(arr));

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swaps++;
            }

            System.out.println("Round " + (i + 1) + " -> start: " + i + ", minIndex: " + minIndex + ", array: " + Arrays.toString(arr));
        }

        System.out.println("Final Sorted Array: " + Arrays.toString(arr));
        System.out.println("Total Comparisons: " + comparisons + ", Total Swaps: " + swaps);
    }
}
