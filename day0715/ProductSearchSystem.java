package day0715;

import java.util.Scanner;

public class ProductSearchSystem {
     static String[] productNames = {
            "Apple", "Banana", "Milk",
            "Coffee", "Notebook", "Keyboard",
            "Mouse", "Chocolate"
    };

    static int[] prices = {
            30, 20, 80, 150, 50, 900, 450, 60
    };

    static int[] stocks = {
            50, 80, 40, 20, 100, 15, 25, 60
    };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== 商品搜尋系統 =====");
            System.out.println("1. 顯示全部商品");
            System.out.println("2. 完整名稱搜尋");
            System.out.println("3. 部分名稱搜尋");
            System.out.println("4. 顯示名稱最長的商品");
            System.out.println("5. 搜尋關鍵字第一次出現的位置");
            System.out.println("6. 結束");
            System.out.print("請選擇：");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    showAllProducts();
                    break;

                case 2:
                    System.out.print("請輸入完整商品名稱：");
                    searchFullName(sc.nextLine());
                    break;

                case 3:
                    System.out.print("請輸入部分名稱：");
                    searchPartName(sc.nextLine());
                    break;

                case 4:
                    showLongestName();
                    break;

                case 5:
                    System.out.print("請輸入搜尋關鍵字：");
                    firstPosition(sc.nextLine());
                    break;

                case 6:
                    System.out.println("程式結束！");
                    break;

                default:
                    System.out.println("請輸入1~6");
            }

        } while (choice != 6);

        sc.close();
    }

    public static void showAllProducts() {

        System.out.println("\n商品名稱\t價格\t庫存");

        for (int i = 0; i < productNames.length; i++) {
            System.out.println(productNames[i] + "\t"
                    + prices[i] + "\t"
                    + stocks[i]);
        }
    }

    public static void searchFullName(String keyword) {

        keyword = keyword.trim();

        boolean found = false;

        for (int i = 0; i < productNames.length; i++) {

            if (productNames[i].equalsIgnoreCase(keyword)) {

                System.out.println("找到商品：");
                System.out.println(productNames[i]
                        + " 價格：" + prices[i]
                        + " 庫存：" + stocks[i]);

                found = true;
            }
        }

        if (!found) {
            System.out.println("查無商品！");
        }
    }

    public static void searchPartName(String keyword) {

        keyword = keyword.trim().toLowerCase();

        boolean found = false;

        for (int i = 0; i < productNames.length; i++) {

            if (productNames[i].toLowerCase().contains(keyword)) {

                System.out.println(productNames[i]
                        + " 價格：" + prices[i]
                        + " 庫存：" + stocks[i]);

                found = true;
            }
        }

        if (!found) {
            System.out.println("查無符合商品！");
        }
    }

    public static void showLongestName() {

        String longest = productNames[0];

        for (String name : productNames) {

            if (name.length() > longest.length()) {
                longest = name;
            }
        }

        System.out.println("名稱最長商品：" + longest);
    }

    public static void firstPosition(String keyword) {

        keyword = keyword.toLowerCase();

        boolean found = false;

        for (String name : productNames) {

            int index = name.toLowerCase().indexOf(keyword);

            if (index != -1) {
                System.out.println(name + " 第一次出現位置：" + index);
                found = true;
            }
        }

        if (!found) {
            System.out.println("沒有找到關鍵字！");
        }
    }
}

/*
==================== 測試案例 ====================

【測試1】顯示全部商品
輸入：
1
結果：
列出全部商品、價格、庫存。

【測試2】完整名稱搜尋（大小寫不同）
輸入：
2
apple
結果：
找到 Apple。

【測試3】完整名稱搜尋（前後空白）
輸入：
2
   Coffee
結果：
找到 Coffee。

【測試4】部分名稱搜尋
輸入：
3
oo
結果：
找到 Coffee。

【測試5】名稱最長商品
輸入：
4
結果：
顯示名稱最長商品（例如 Chocolate 或 Keyboard）。

【測試6】搜尋第一次出現位置
輸入：
5
oo
結果：
Coffee 第一次出現位置：1
=================================================
*/