package day0708;

import java.util.Scanner;

public class OrderSystem_demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalAmount = 0; 
        int totalItems = 0;  

        while (true) {
            System.out.println("=== Order Menu ===");
            System.out.println("1. Black tea  $30");
            System.out.println("2. Green tea  $35");
            System.out.println("3. Coffee     $50");
            System.out.println("0. Checkout");
            System.out.print("請輸入選項：");

            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            int price = 0;

            switch (choice) {
                case 1:
                    price = 30;
                    break;
                case 2:
                    price = 35;
                    break;
                case 3:
                    price = 50;
                    break;
                default:
                    System.out.println("無效的選項，請重新選擇");
                    continue; 
            }

            int quantity = 0;
            while (true) {
                System.out.print("請輸入數量：");
                quantity = scanner.nextInt();

                if (quantity > 0) {
                    break; 
                } else {
                    System.out.println("數量必須大於 0，請重新輸入");
                }
            }

            int subtotal = price * quantity;
            System.out.println("Subtotal: " + subtotal);
            System.out.println(); 

            totalItems += quantity;  
            totalAmount += subtotal; 
        }

        System.out.println();
        System.out.println("=== Receipt ===");
        System.out.println("Total items: " + totalItems);
        System.out.println("Total amount: " + totalAmount);

        scanner.close();
    }
}
