package day0728;

public class RecursiveDigitSumPractice {
    public static int digitSum(int number) {
        if (number < 10) {
            return number;
        }

        return (number % 10) + digitSum(number / 10);
    }

    public static void main(String[] args) {
        int[] testNumbers = {0, 5729, 9, 12345, 987654321};

        System.out.println("=== 課堂實作題一：遞迴計算各位數總和測試 ===");
        for (int num : testNumbers) {
            int result = digitSum(num);
            System.out.println("數字: " + num + " -> 各位數總和: " + result);
        }
    }
}
