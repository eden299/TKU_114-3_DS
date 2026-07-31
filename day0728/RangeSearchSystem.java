package day0728;

import java.util.Arrays;

public class RangeSearchSystem {
    public static int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                result = mid;
                high = mid - 1; // Keep searching left
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static int findLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                result = mid;
                low = mid + 1; // Keep searching right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        if (first == -1) {
            return new int[]{-1, -1};
        }
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 20, 20, 30, 40, 50, 50, 60};

        int[] targets = {20, 50, 10, 99};

        System.out.println("Sorted Array: " + Arrays.toString(nums));
        System.out.println();

        for (int target : targets) {
            int[] range = searchRange(nums, target);
            System.out.println("Target: " + target);
            System.out.println("  Index Range: " + Arrays.toString(range));
            if (range[0] != -1) {
                int count = range[1] - range[0] + 1;
                System.out.println("  Occurrences: " + count);
            } else {
                System.out.println("  Occurrences: 0");
            }
            System.out.println();
        }
    }
}
