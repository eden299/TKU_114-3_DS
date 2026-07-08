package day0707;

import java.util.Scanner;

public class ScoreMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入姓名：");

        String name = scanner.next();
        System.out.print("請輸入 Java 成績：");
        double javaScore = scanner.nextDouble();

        System.out.print("請輸入 English 成績：");
        double englishScore = scanner.nextDouble();

        System.out.print("請輸入 Math 成績：");
        double mathScore = scanner.nextDouble();

        double average = (javaScore + englishScore + mathScore) / 3.0;

        String status;
        if (average >= 60) {
            status = "及格";
        } else {
            status = "不及格";
        }

        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        int choice = -1;

        while (choice != 0) {
            System.out.println("\n--- 產生成績選單 ---");
            System.out.println("1 : 顯示平均分數");
            System.out.println("2 : 顯示及格狀態");
            System.out.println("3 : 顯示等第");
            System.out.println("0 : 離開");
            System.out.print("請選擇功能 (0-3)：");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n[結果] " + name + " 的平均分數為：" + average);
                    break;
                case 2:
                    System.out.println("\n[結果] " + name + " 的及格狀態為：" + status);
                    break;
                case 3:
                    System.out.println("\n[結果] " + name + " 的等第為：" + grade);
                    break;
                case 0:
                    System.out.println("\n離開選單，程式結束！");
                    break;
                default:
                    System.out.println("\n[錯誤] 輸入無效，請重新選擇 0~3 之間。");
                    break;
            }
        }

        scanner.close();
    }
}
