package day0728;

public class SearchEfficiencyReport {
    public static int sequentialSearchCount(int[] data, int target) {
        int count = 0;
        for (int val : data) {
            count++;
            if (val == target) {
                break;
            }
        }
        return count;
    }

    public static int binarySearchCount(int[] data, int target) {
        int count = 0;
        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            count++;
            int mid = low + (high - low) / 2;

            if (data[mid] == target) {
                break;
            } else if (data[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return count;
    }

    public static void analyze(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = (i + 1) * 10;
        }

        int first = data[0];
        int last = data[size - 1];
        int notFound = -999;

        System.out.println("=== Data Size: " + size + " ===");
        System.out.println("Target: First Element (" + first + ")");
        System.out.println("  Sequential Search Comparisons: " + sequentialSearchCount(data, first));
        System.out.println("  Binary Search Comparisons:     " + binarySearchCount(data, first));

        System.out.println("Target: Last Element (" + last + ")");
        System.out.println("  Sequential Search Comparisons: " + sequentialSearchCount(data, last));
        System.out.println("  Binary Search Comparisons:     " + binarySearchCount(data, last));

        System.out.println("Target: Not Found (" + notFound + ")");
        System.out.println("  Sequential Search Comparisons: " + sequentialSearchCount(data, notFound));
        System.out.println("  Binary Search Comparisons:     " + binarySearchCount(data, notFound));
        System.out.println();
    }

    public static void main(String[] args) {
        int[] sizes = {16, 128, 1024};

        for (int size : sizes) {
            analyze(size);
        }

        System.out.println("=== Observations & Analysis ===");
        System.out.println("1. Sequential Search comparison count grows linearly O(N). Worst case requires N comparisons.");
        System.out.println("2. Binary Search comparison count grows logarithmically O(log N). Worst case requires log2(N) + 1 comparisons.");
        System.out.println("3. For small arrays (e.g. 16), Sequential Search can be faster if target is at index 0, but Binary Search is far superior on large datasets (1024 elements requires max ~11 comparisons vs 1024).");
    }
}
