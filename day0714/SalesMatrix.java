package day0714;

import java.util.Scanner;

public class SalesMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int[][] sales = new int[3][4];
 
        inputSales(sc, sales);

        displayMatrix(sales);

        calculateAndShowStatistics(sales);
        
        sc.close();
    }

    public static void inputSales(Scanner sc, int[][] matrix) {
        System.out.println("=== 請輸入銷售量資料 ===");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                while (true) {
                    System.out.print("請輸入 商品 " + (row + 1) + " 在 第 " + (col + 1) + " 天的銷售量: ");
                    if (sc.hasNextInt()) {
                        int value = sc.nextInt();
                        if (value >= 0) {
                            matrix[row][col] = value;
                            break;
                        }
                    } else {
                        sc.next(); 
                    }
                    System.out.println("【錯誤】銷售量不得小於 0 或輸入非法字元，請重新輸入！");
                }
            }
        }
    }

    public static void displayMatrix(int[][] matrix) {
        System.out.println("=== 銷售量完整報表 ===");

        System.out.printf("%-10s\t%-6s\t%-6s\t%-6s\t%-6s\n", "", "第1天", "第2天", "第3天", "第4天");
        
        for (int row = 0; row < matrix.length; row++) {
            System.out.printf("商品 %d\t", (row + 1));
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%-6d\t", matrix[row][col]);
            }
            System.out.println(); 
        }
    }

    public static void calculateAndShowStatistics(int[][] matrix) {
        System.out.println("=== 數據統計分析 ===");

        int[] productTotals = new int[matrix.length]; // 長度為 3
        int maxProductTotal = -1;
        int bestProductIndex = -1;

        for (int row = 0; row < matrix.length; row++) {
            int rowSum = 0;
            for (int col = 0; col < matrix[row].length; col++) {
                rowSum += matrix[row][col];
            }
            productTotals[row] = rowSum;
            System.out.println("商品 " + (row + 1) + " 的銷售總量: " + rowSum);

            if (rowSum > maxProductTotal) {
                maxProductTotal = rowSum;
                bestProductIndex = row;
            }
        }

        int totalCols = matrix[0].length;
        for (int col = 0; col < totalCols; col++) {
            int colSum = 0;
            for (int row = 0; row < matrix.length; row++) {
                colSum += matrix[row][col];
            }
            System.out.println("第 " + (col + 1) + " 天全部商品的銷售總量: " + colSum);
        }

        System.out.println("總銷售量最高的商品是: 商品 " + (bestProductIndex + 1) + " (總銷量: " + maxProductTotal + ")");
    }
}
