package day0729;

import java.util.Arrays;
import java.util.Random;

public class SortingExperiment {
    public static void main(String[] args) {
        int size = 10;
        
        int[] sortedData = new int[size];
        int[] reverseData = new int[size];
        for (int i = 0; i < size; i++) {
            sortedData[i] = (i + 1) * 10;
            reverseData[i] = (size - i) * 10;
        }

        int[] randomData = new int[size];
        Random rand = new Random(42);
        for (int i = 0; i < size; i++) {
            randomData[i] = rand.nextInt(100) + 1;
        }

        runExperiment("Sorted Data", sortedData);
        runExperiment("Reverse Sorted Data", reverseData);
        runExperiment("Random Data", randomData);
    }

    public static void runExperiment(String label, int[] original) {
        System.out.println("==========================================");
        System.out.println("Dataset: " + label);
        System.out.println("Original Array: " + Arrays.toString(original));
        System.out.println("------------------------------------------");

        int[] selectionCopy = original.clone();
        runSelectionSort(selectionCopy);

        int[] insertionCopy = original.clone();
        runInsertionSort(insertionCopy);

        printObservation(label);
        System.out.println();
    }

    public static void runSelectionSort(int[] arr) {
        int comparisons = 0;
        int swaps = 0;
        int moves = 0;
        int n = arr.length;

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
                moves += 3;
            }
        }

        System.out.println("[Selection Sort]");
        System.out.println("Result: " + Arrays.toString(arr));
        System.out.println("Comparisons: " + comparisons + " | Swaps: " + swaps + " | Element Moves: " + moves);
    }

    public static void runInsertionSort(int[] arr) {
        int comparisons = 0;
        int shifts = 0;
        int moves = 0;
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            moves++;
            int j = i - 1;

            while (j >= 0) {
                comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    moves++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
            moves++;
        }

        System.out.println("[Insertion Sort]");
        System.out.println("Result: " + Arrays.toString(arr));
        System.out.println("Comparisons: " + comparisons + " | Shifts: " + shifts + " | Element Moves: " + moves);
    }

    public static void printObservation(String label) {
        System.out.println("\n[Observation Conclusion]");
        if (label.equals("Sorted Data")) {
            System.out.println("Insertion Sort performs best on already sorted data with min comparisons and 0 shifts.");
            System.out.println("Selection Sort still performs O(N^2) comparisons regardless of initial data order.");
        } else if (label.equals("Reverse Sorted Data")) {
            System.out.println("Insertion Sort reaches its worst-case scenario with max comparisons and shifts.");
            System.out.println("Selection Sort makes fewer moves than Insertion Sort, but comparisons remain high.");
        } else {
            System.out.println("Insertion Sort usually requires fewer comparisons than Selection Sort on average random data.");
            System.out.println("Selection Sort keeps swap count low (at most N-1 swaps).");
        }
    }
}
