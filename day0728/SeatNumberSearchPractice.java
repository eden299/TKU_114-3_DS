package day0728;

import java.util.Scanner;

public class SeatNumberSearchPractice {
    public static int binarySearch(int[] seats, int target) {
        int low = 0;
        int high = seats.length - 1;
        int step = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println("Round " + step + " -> low: " + low + ", mid: " + mid + ", high: " + high);

            if (seats[mid] == target) {
                return mid;
            } else if (seats[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            step++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] seats = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter seat number: ");
        int target = scanner.nextInt();

        int result = binarySearch(seats, target);

        if (result != -1) {
            System.out.println("Found at index: " + result);
        } else {
            System.out.println("Seat not found.");
        }

        scanner.close();
    }
}
