package day0730;

import java.util.ArrayList;
import java.util.List;

public class OrderAlgorithms {
    public static void mergeSortByAmountDesc(Order[] orders, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortByAmountDesc(orders, left, mid);
        mergeSortByAmountDesc(orders, mid + 1, right);
        merge(orders, left, mid, right);
    }

    private static void merge(Order[] orders, int left, int mid, int right) {
        Order[] leftArr = new Order[mid - left + 1];
        Order[] rightArr = new Order[right - mid];

        for (int i = 0; i < leftArr.length; i++) leftArr[i] = orders[left + i];
        for (int j = 0; j < rightArr.length; j++) rightArr[j] = orders[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i].getAmount() >= rightArr[j].getAmount()) {
                orders[k++] = leftArr[i++];
            } else {
                orders[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) orders[k++] = leftArr[i++];
        while (j < rightArr.length) orders[k++] = rightArr[j++];
    }

    public static List<Order> searchByCustomerName(Order[] orders, String name) {
        List<Order> result = new ArrayList<>();
        if (orders == null || name == null) return result;

        for (Order order : orders) {
            if (order != null && order.getCustomerName().equalsIgnoreCase(name)) {
                result.add(order);
            }
        }
        return result;
    }
}
