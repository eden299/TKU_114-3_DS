package day0708;

import java.util.Scanner;

public class OrderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalAmount = 0; 
        int totalCount = 0;  

        while (true) {
            System.out.println("點餐選單 ");
            System.out.println("1. Black tea  $30");
            System.out.println("2. Green tea  $35");
            System.out.println("3. Coffee     $50");
            System.out.println("0. Checkout   結帳");
            System.out.print("請輸入商品選項: ");

            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            int price = 0;
            String itemName = "";

            switch (choice) {
                case 1:
                    itemName = "Black tea";
                    price = 30;
                    break;
                case 2:
                    itemName = "Green tea";
                    price = 35;
                    break;
                case 3:
                    itemName = "Coffee";
                    price = 50;
                    break;
                default:
                    System.out.println("無效的選項，請重新輸入");
                    continue; 
}
            int quantity = 0;
            while (true) {
                System.out.print("請輸入數量 (< 0): ");
                quantity = scanner.nextInt();
                
                if (quantity > 0) {
                    break; 
                } else {
                    System.out.println("數量錯誤！請重新輸入");
                }
            }

            int subtotal = price * quantity;
            System.out.println("點購成功: " + itemName + " x " + quantity + ", 小計: " + subtotal);

            totalCount += quantity;
            totalAmount += subtotal;
        }

        System.out.println("最後總數量 (Total Count): " + totalCount);
        System.out.println("最後總金額 (Total Amount): " + totalAmount);

        scanner.close();
    }
}
