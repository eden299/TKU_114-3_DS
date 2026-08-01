package day0730;

import java.util.Arrays;

public class InventorySearchPractice {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
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
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] inventory = {1085, 1012, 1099, 1003, 1045, 1020, 1077, 1011, 1050, 1033, 1066, 1001, 1015};

        System.out.println("Original Inventory: " + Arrays.toString(inventory));

        mergeSort(inventory, 0, inventory.length - 1);
        System.out.println("Sorted Inventory:   " + Arrays.toString(inventory));
        System.out.println();

        int targetFirst = inventory[0];
        int idxFirst = binarySearch(inventory, targetFirst);
        System.out.println("Search First ID (" + targetFirst + ") -> Index: " + idxFirst);

        int targetLast = inventory[inventory.length - 1];
        int idxLast = binarySearch(inventory, targetLast);
        System.out.println("Search Last ID (" + targetLast + ") -> Index: " + idxLast);

        int targetNotExist = 9999;
        int idxNotExist = binarySearch(inventory, targetNotExist);
        System.out.println("Search Non-existent ID (" + targetNotExist + ") -> Index: " + idxNotExist);
    }
}
