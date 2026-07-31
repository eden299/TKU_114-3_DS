package day0728;

public class RecursiveDigitCounter {
    public static int countDigit(int number, int target) {
        if (target < 0 || target > 9) {
            return 0;
        }

        number = Math.abs(number);

        if (number < 10) {
            return (number == target) ? 1 : 0;
        }

        int currentDigit = number % 10;
        int match = (currentDigit == target) ? 1 : 0;

        return match + countDigit(number / 10, target);
    }

    public static void main(String[] args) {
        System.out.println("Test 1 (77277, target 7): " + countDigit(77277, 7));
        System.out.println("Test 2 (12345, target 9): " + countDigit(12345, 9));
        System.out.println("Test 3 (0, target 0): " + countDigit(0, 0));
        System.out.println("Test 4 (10008, target 0): " + countDigit(10008, 0));
        System.out.println("Test 5 (55555, target 5): " + countDigit(55555, 5));
        System.out.println("Test 6 (-8828, target 8): " + countDigit(-8828, 8));
    }
}
