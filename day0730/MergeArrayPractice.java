package day0730;

import java.util.Arrays;

public class MergeArrayPractice {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null) arr1 = new int[0];
        if (arr2 == null) arr2 = new int[0];

        int i = 0;
        int j = 0;
        int k = 0;

        int[] temp = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length) {
            int val;
            if (arr1[i] < arr2[j]) {
                val = arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                val = arr2[j++];
            } else {
                val = arr1[i];
                i++;
                j++;
            }

            if (k == 0 || temp[k - 1] != val) {
                temp[k++] = val;
            }
        }

        while (i < arr1.length) {
            int val = arr1[i++];
            if (k == 0 || temp[k - 1] != val) {
                temp[k++] = val;
            }
        }

        while (j < arr2.length) {
            int val = arr2[j++];
            if (k == 0 || temp[k - 1] != val) {
                temp[k++] = val;
            }
        }

        int[] result = new int[k];
        System.arraycopy(temp, 0, result, 0, k);
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {-5, -1, 3, 3, 7, 9, 12};
        int[] arr2 = {-3, -1, 4, 7, 10};
        System.out.println("Test 1 Result: " + Arrays.toString(mergeSortedArrays(arr1, arr2)));

        int[] emptyArr = {};
        int[] normalArr = {-2, 0, 5};
        System.out.println("Test 2 (Empty) Result: " + Arrays.toString(mergeSortedArrays(emptyArr, normalArr)));

        int[] dupArr1 = {-1, -1, -1};
        int[] dupArr2 = {-1, 2, 2};
        System.out.println("Test 3 (Duplicates) Result: " + Arrays.toString(mergeSortedArrays(dupArr1, dupArr2)));
    }
}
