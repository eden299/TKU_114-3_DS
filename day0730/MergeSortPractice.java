package day0730;

import java.util.Arrays;

public class MergeSortPractice {
    public static void mergeSort(int[] arr, int left, int right) {
        if (arr == null || left >= right) {
            return;
        }

        System.out.println("Divide range: [" + left + " .. " + right + "]");

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }

        System.out.print("Merged range [" + left + " .. " + right + "]: ");
        for (int m = left; m <= right; m++) {
            System.out.print(arr[m] + (m == right ? "" : ", "));
        }
        System.out.println();
    }

    public static void runTest(String testName, int[] input) {
        System.out.println("=== " + testName + " ===");
        if (input == null) {
            System.out.println("Array is null.");
            return;
        }
        System.out.println("Original: " + Arrays.toString(input));
        if (input.length > 0) {
            mergeSort(input, 0, input.length - 1);
        }
        System.out.println("Sorted: " + Arrays.toString(input));
        System.out.println();
    }

    public static void main(String[] args) {
        int[] target = {41, 12, 35, 8, 27, 19, 50, 3};
        runTest("Target Array Test", target);

        runTest("Empty Array Test", new int[]{});
        runTest("Single Element Test", new int[]{42});
        runTest("Already Sorted Test", new int[]{1, 2, 3, 4, 5});
        runTest("Reverse Sorted Test", new int[]{9, 7, 5, 3, 1});
    }
}
