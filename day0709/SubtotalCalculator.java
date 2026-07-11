package day0709;

public class SubtotalCalculator {
    public static void main(String[] args) {
        int total = calculateSubtotal(150, 3);

        System.out.println(total);
    }

    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }
}
