package day0730;

import java.util.Arrays;
import java.util.Random;

public class AlgorithmComparisonReport {
    private static long comparisonCount = 0;

    public static long selectionSort(int[] arr) {
        long comparisons = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        return comparisons;
    }

    public static long insertionSort(int[] arr) {
        long comparisons = 0;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
        return comparisons;
    }

    public static long mergeSort(int[] arr) {
        comparisonCount = 0;
        if (arr == null || arr.length <= 1) return 0;
        mergeSortRecursive(arr, 0, arr.length - 1);
        return comparisonCount;
    }

    private static void mergeSortRecursive(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortRecursive(arr, left, mid);
        mergeSortRecursive(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            comparisonCount++;
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    private static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i;
        return arr;
    }

    private static int[] generateReversedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = size - i;
        return arr;
    }

    private static int[] generateRandomArray(int size, long seed) {
        int[] arr = new int[size];
        Random rand = new Random(seed);
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size * 10);
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {16, 128, 1024};
        String[] dataTypes = {"Sorted", "Reversed", "Random"};

        System.out.printf("%-8s | %-10s | %-15s | %-15s | %-15s%n", "Size", "Data Type", "Selection Sort", "Insertion Sort", "Merge Sort");
        System.out.println("-----------------------------------------------------------------------------");

        for (int size : sizes) {
            for (String dataType : dataTypes) {
                int[] baseData;
                if (dataType.equals("Sorted")) {
                    baseData = generateSortedArray(size);
                } else if (dataType.equals("Reversed")) {
                    baseData = generateReversedArray(size);
                } else {
                    baseData = generateRandomArray(size, 42);
                }

                int[] arr1 = baseData.clone();
                int[] arr2 = baseData.clone();
                int[] arr3 = baseData.clone();

                long selectionComps = selectionSort(arr1);
                long insertionComps = insertionSort(arr2);
                long mergeComps = mergeSort(arr3);

                System.out.printf("%-8d | %-10s | %-15d | %-15d | %-15d%n", size, dataType, selectionComps, insertionComps, mergeComps);
            }
            System.out.println("-----------------------------------------------------------------------------");
        }

        System.out.println("\n=== Algorithm Observations Conclusion ===");
        System.out.println("1. Selection Sort always performs O(N^2) comparisons regardless of initial data order.");
        System.out.println("2. Insertion Sort performs exceptionally well on sorted data O(N) comparisons, but degrades to O(N^2) on reversed data.");
        System.out.println("3. Merge Sort maintains consistent O(N log N) performance across all data distributions, outperforming O(N^2) algorithms significantly as N grows.");
    }
}
