package day0728;

public class RecursiveNameSearchPractice {
    public static int search(String[] names, String target, int index) {
        if (names == null || index >= names.length) {
            return -1;
        }

        if (names[index] != null && names[index].equals(target)) {
            return index;
        }

        return search(names, target, index + 1);
    }

    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Emma"};
        String[] emptyArray = {};

        System.out.println("1. Test Empty Array: " + search(emptyArray, "Alice", 0));
        System.out.println("2. Test First Item ('Alice'): " + search(names, "Alice", 0));
        System.out.println("3. Test Last Item ('Emma'): " + search(names, "Emma", 0));
        System.out.println("4. Test Non-existent Item ('Frank'): " + search(names, "Frank", 0));
    }
}
