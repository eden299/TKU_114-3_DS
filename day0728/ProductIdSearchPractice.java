package day0728;

import java.util.Scanner;

public class ProductIdSearchPractice {
    public static void main(String[] args) {
        int[] productIds = {105, 302, 888, 101, 555, 920, 204, 777};

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 課堂實作題二：商品編號循序搜尋 ===");
        System.out.print("現有商品編號列表: ");
        for (int id : productIds) {
            System.out.print(id + " ");
        }
        System.out.println("\n");

        System.out.print("請輸入要搜尋的商品編號: ");
        int target = scanner.nextInt();

        int foundIndex = -1;
        int compareCount = 0; 

        for (int i = 0; i < productIds.length; i++) {
            compareCount++;
            if (productIds[i] == target) {
                foundIndex = i;
                break;
            }
        }

        System.out.println("\n--- 搜尋結果 ---");
        if (foundIndex != -1) {
            System.out.println("成功找到商品！索引位置 (Index): " + foundIndex);
        } else {
            System.out.println("查無此商品！編號 " + target + " 不存在於列表中。");
        }

        System.out.println("實際比較次數: " + compareCount + " 次");

        scanner.close();
    }
}
