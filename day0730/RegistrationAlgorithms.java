package day0730;

import java.util.ArrayList;
import java.util.List;

public class RegistrationAlgorithms {
    public static void mergeSortByIdAsc(Registration[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortByIdAsc(arr, left, mid);
        mergeSortByIdAsc(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(Registration[] arr, int left, int mid, int right) {
        Registration[] leftArr = new Registration[mid - left + 1];
        Registration[] rightArr = new Registration[right - mid];

        for (int i = 0; i < leftArr.length; i++) leftArr[i] = arr[left + i];
        for (int j = 0; j < rightArr.length; j++) rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i].getId().compareTo(rightArr[j].getId()) <= 0) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    public static Registration binarySearchById(Registration[] sortedArr, String targetId) {
        if (sortedArr == null || targetId == null) return null;

        int left = 0;
        int right = sortedArr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = sortedArr[mid].getId().compareTo(targetId);

            if (cmp == 0) {
                return sortedArr[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static List<Registration> sequentialSearchByName(List<Registration> list, String targetName) {
        List<Registration> result = new ArrayList<>();
        if (list == null || targetName == null) return result;

        for (Registration reg : list) {
            if (reg != null && reg.getName().equalsIgnoreCase(targetName)) {
                result.add(reg);
            }
        }
        return result;
    }
}
