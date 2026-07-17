package day0715;

import java.util.Scanner;

public class ProductDataManager {
    private static final int MAX_PRODUCTS = 100;

    private static String[] names = new String[MAX_PRODUCTS];
    private static int[] prices = new int[MAX_PRODUCTS];
    private static int[] stocks = new int[MAX_PRODUCTS];
    private static int productCount = 0;

    public static void main(String[] args) {
        String[] records = {
            "Keyboard,890,12",
            "Mouse,490,20",
            "Monitor,5200,5",
            "USB Cable,250,30",
            "Headset,1290,8"
        };

        for (String record : records) {
            addProduct(record);
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== 商品資料管理系統 =====");
            System.out.println("1. 顯示商品表格");
            System.out.println("2. 搜尋商品（完整或部分名稱）");
            System.out.println("3. 顯示低庫存商品（低於10件）");
            System.out.println("4. 顯示庫存總價值");
            System.out.println("5. 新增一筆新商品文字資料");
            System.out.println("6. 執行自動化 8 組測試案例 (功能 9)");
            System.out.println("0. 離開程式");
            System.out.print("請選擇功能: ");
            
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    displayProductTable();
                    break;
                case "2":
                    System.out.print("請輸入要搜尋的商品名稱: ");
                    String keyword = sc.nextLine();
                    searchProduct(keyword);
                    break;
                case "3":
                    displayLowStock(10); 
                case "4":
                    calculateTotalValue();
                    break;
                case "5":
                    System.out.print("請輸入商品文字資料 (格式如 Name,Price,Stock): ");
                    String inputRecord = sc.nextLine();
                    addProduct(inputRecord);
                    break;
                case "6":
                    runTestCases();
                    break;
                case "0":
                    System.out.println("系統已結束。");
                    sc.close();
                    return;
                default:
                    System.out.println("無效的選擇，請重新輸入！");
            }
        }
    }

    public static void addProduct(String record) {
        if (productCount >= MAX_PRODUCTS) {
            System.out.println("【新增失敗】系統庫存陣列已滿！");
            return;
        }

        try {
            if (record == null || record.trim().isEmpty()) {
                throw new IllegalArgumentException("輸入資料不能為空值或空白字串");
            }

            String[] tokens = record.split(",");

            if (tokens.length != 3) {
                throw new IllegalArgumentException("格式錯誤：必須剛好有 3 個由逗號分隔的欄位 (目前欄位數: " + tokens.length + ")");
            }

            String name = tokens[0].trim();
            if (name.isEmpty()) {
                throw new IllegalArgumentException("格式錯誤：商品名稱不能為空");
            }

            int price;
            try {
                price = Integer.parseInt(tokens[1].trim());
                if (price < 0) throw new IllegalArgumentException("價格不能為負數");
            } catch (NumberFormatException e) {
                throw new NumberFormatException("數字轉換錯誤：價格 \"" + tokens[1] + "\" 不是有效的整數");
            }

            int stock;
            try {
                stock = Integer.parseInt(tokens[2].trim());
                if (stock < 0) throw new IllegalArgumentException("庫存不能為負數");
            } catch (NumberFormatException e) {
                throw new NumberFormatException("數字轉換錯誤：庫存 \"" + tokens[2] + "\" 不是有效的整數");
            }

            names[productCount] = name;
            prices[productCount] = price;
            stocks[productCount] = stock;
            productCount++;
            System.out.println("【成功新增】" + name + " (價格: " + price + ", 庫存: " + stock + ")");

        } catch (Exception e) {

            System.out.println(" 發生錯誤而略過資料 -> 原因: " + e.getMessage());
        }
    }

    public static void displayProductTable() {
        System.out.println("\n------------------------------------------------");
        System.out.printf("%-5s | %-15s | %-10s | %-5s%n", "ID", "商品名稱", "價格", "庫存");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < productCount; i++) {
            System.out.printf("%-5d | %-15s | %-10d | %-5d%n", (i + 1), names[i], prices[i], stocks[i]);
        }
        System.out.println("------------------------------------------------");
    }

    public static void searchProduct(String keyword) {
        System.out.println("\n 搜尋關鍵字 \"" + keyword + "\" 的結果：");
        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            if (names[i].toLowerCase().contains(keyword.toLowerCase().trim())) {
                System.out.printf("-> 找到商品: %s | 價格: %d | 庫存: %d%n", names[i], prices[i], stocks[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println(" 找不到任何符合名稱的商品。");
        }
    }

    public static void displayLowStock(int threshold) {
        System.out.println("\n 低庫存警報 (庫存低於 " + threshold + " 件)：");
        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            if (stocks[i] < threshold) {
                System.out.printf("-> 警告！[%s] 庫存僅剩 %d 件 (價格: %d)%n", names[i], stocks[i], prices[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println(" 目前所有商品庫存水位安全。");
        }
    }

    public static void calculateTotalValue() {
        long totalValue = 0;
        for (int i = 0; i < productCount; i++) {
            totalValue += (long) prices[i] * stocks[i];
        }
        System.out.printf("%n 全店目前庫存總價值為: %,d 元%n", totalValue);
    }

    public static void runTestCases() {
        System.out.println("\n====== 開始執行 8 組測試案例 ======");
        
        String[] testCases = {
            "Speaker,1500,15",        
            "Type-C Hub, 790 , 25 ",  
            "Microphone,abc,10",      
            "Webcam,1200,xyz",        
            "Wireless Charger,990",  
            "Router,690,10,額外欄位",   
            ",800,10",                
            "Stylus Pen,-350,5"      
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("\n[測試案例 " + (i + 1) + "] 輸入字串: \"" + testCases[i] + "\"");
            addProduct(testCases[i]);
        }
        System.out.println("\n======  測試案例執行完畢，程式依然安全運行 ======");
    }
}
