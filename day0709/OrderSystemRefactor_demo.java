package day0709;

import java.util.Scanner;

public class OrderSystemRefactor_demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalAmount = 0; 
        int totalCount = 0;  

        while (true) {
            printMenu();

            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            int price = getPrice(choice);

            if (price == -1) {
                System.out.println("無效的選項，請重新輸入");
                continue; 
            }

            String itemName = getItemName(choice);

            int quantity = readValidQuantity(scanner);

            int subtotal = calculateSubtotal(price, quantity);
            
            System.out.println("點購成功: " + itemName + " x " + quantity + ", 小計: " + subtotal);

            totalCount += quantity;
            totalAmount += subtotal;
        }

        printReceipt(totalCount, totalAmount);

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("點餐選單 ");
        System.out.println("1. Black tea  $30");
        System.out.println("2. Green tea  $35");
        System.out.println("3. Coffee     $50");
        System.out.println("0. Checkout   結帳");
        System.out.print("請輸入商品選項: ");
    }

    public static int getPrice(int option) {
        switch (option) {
            case 1: return 30;  
            case 2: return 35;  
            case 3: return 50;  
            default: return -1; 
        }
    }

    public static String getItemName(int option) {
        switch (option) {
            case 1: return "Black tea";
            case 2: return "Green tea";
            case 3: return "Coffee";
            default: return "";
        }
    }

    public static int readValidQuantity(Scanner sc) {
        int qty = 0;
        while (true) {
            System.out.print("請輸入數量 (需大於 0): ");
            qty = sc.nextInt();

            if (qty > 0) {
                break; 
            } else {
                System.out.println("數量錯誤！請重新輸入");
            }
        }
        return qty;
    }

    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }

    public static void printReceipt(int totalItems, int totalAmount) {
        System.out.println("最後總數量 (Total Count): " + totalItems);
        System.out.println("最後總金額 (Total Amount): " + totalAmount);
    }
}
