package day0714;

import java.util.Scanner;

public class ProductArraySystem {
    static String[] names = {"Keyboard", "Mouse", "Monitor", "USB Cable", "Headset"};
    static int[] prices = {890, 490, 5200, 250, 1290};
    static int[] stocks = {12, 20, 5, 30, 8};
    static Scanner scanner = new Scanner(System.in);

    static int totalPurchaseCount = 0;
    static int totalRestockCount = 0;

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            System.out.print("請輸入選項 (1-7): ");
            int choice = scanner.nextInt();
            System.out.println("----------------------------------------");

            switch (choice) {
                case 1:
                    showAllProducts();
                    break;
                case 2:
                    queryProductById();
                    break;
                case 3:
                    purchaseProduct();
                    break;
                case 4:
                    restockProduct();
                    break;
                case 5:
                    showLowStockProducts();
                    break;
                case 6:
                    showTotalStockValue();
                    break;
                case 7:
                    exitAndShowSummary();
                    running = false;
                    break;
                default:
                    System.out.println("無效的選項，請重新輸入！");
            }
            System.out.println("----------------------------------------\n");
        }
    }

    public static void showMenu() {
        System.out.println("=== 商品陣列管理系統 ===");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 依商品編號查詢");
        System.out.println("3. 購買商品並扣除庫存");
        System.out.println("4. 補充商品庫存");
        System.out.println("5. 顯示低庫存商品 (庫存 < 10)");
        System.out.println("6. 顯示全部庫存總價值");
        System.out.println("7. 結束並顯示操作摘要");
    }

    public static void showAllProducts() {
        System.out.println("編號\t商品名稱\t\t價格\t庫存");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d\t%-15s\t%d\t%d\n", (i + 1), names[i], prices[i], stocks[i]);
        }
    }

    public static void queryProductById() {
        System.out.print("請輸入要查詢的商品編號 (1-" + names.length + "): ");
        int id = scanner.nextInt();
        int index = id - 1;

        if (index >= 0 && index < names.length) {
            System.out.println("【查詢結果】");
            System.out.println("商品名稱: " + names[index]);
            System.out.println("商品價格: " + prices[index] + " 元");
            System.out.println("目前庫存: " + stocks[index] + " 個");
        } else {
            System.out.println("錯誤：找不到該商品編號！");
        }
    }

    public static void purchaseProduct() {
        System.out.print("請輸入要購買的商品編號 (1-" + names.length + "): ");
        int id = scanner.nextInt();
        int index = id - 1;

        if (index >= 0 && index < names.length) {
            System.out.print("請輸入購買數量: ");
            int quantity = scanner.nextInt();

            if (quantity <= 0) {
                System.out.println("錯誤：購買數量必須大於 0！");
            } else if (quantity > stocks[index]) {
                System.out.println("錯誤：庫存不足！目前庫存僅剩 " + stocks[index] + " 個。");
            } else {
                stocks[index] -= quantity;
                totalPurchaseCount += quantity;
                System.out.println("購買成功！已扣除庫存。您購買了 " + quantity + " 個 " + names[index]);
            }
        } else {
            System.out.println("錯誤：找不到該商品編號！");
        }
    }

    public static void restockProduct() {
        System.out.print("請輸入要補充的商品編號 (1-" + names.length + "): ");
        int id = scanner.nextInt();
        int index = id - 1;

        if (index >= 0 && index < names.length) {
            System.out.print("請輸入補充數量: ");
            int quantity = scanner.nextInt();

            if (quantity > 0) {
                stocks[index] += quantity;
                totalRestockCount += quantity;
                System.out.println("補貨成功！" + names[index] + " 目前新庫存為: " + stocks[index] + " 個");
            } else {
                System.out.println("錯誤：補貨數量必須大於 0！");
            }
        } else {
            System.out.println("錯誤：找不到該商品編號！");
        }
    }

    public static void showLowStockProducts() {
        System.out.println("【低庫存商品清單 (庫存 < 10)】");
        System.out.println("編號\t商品名稱\t\t目前庫存");
        boolean hasLowStock = false;
        
        for (int i = 0; i < names.length; i++) {
            if (stocks[i] < 10) { 
                System.out.printf("%d\t%-15s\t%d\n", (i + 1), names[i], stocks[i]);
                hasLowStock = true;
            }
        }
        
        if (!hasLowStock) {
            System.out.println("目前沒有商品的庫存低於 10。");
        }
    }

    public static void showTotalStockValue() {
        int totalValue = 0;
        for (int i = 0; i < names.length; i++) {
            totalValue += prices[i] * stocks[i];
        }
        System.out.println("系統中所有商品的庫存總價值為: " + totalValue + " 元");
    }

    public static void exitAndShowSummary() {
        System.out.println("感謝使用商品陣列管理系統！");
        System.out.println("=== 今日操作摘要 ===");
        System.out.println("總計購買商品數量: " + totalPurchaseCount + " 個");
        System.out.println("總計補充商品數量: " + totalRestockCount + " 個");
        System.out.println("系統已安全關閉。");
    }
}