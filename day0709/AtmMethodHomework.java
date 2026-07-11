package day0709;

import java.util.Scanner;

public class AtmMethodHomework {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int balance = 1000;

        while (true) {
            printMenu();
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("感謝您的使用");
                break;
            }

            switch (choice) {
                case 1:
                    printBalance(balance);
                    break;

                case 2:
                    int depositAmount = readPositiveAmount(sc, "請輸入存款金額：");
                    
                    balance = deposit(balance, depositAmount);
                    System.out.println("存款成功！已存入 " + depositAmount + " 元。目前餘額：" + balance + " 元");
                    break;

                case 3:
                    int withdrawAmount = readPositiveAmount(sc, "請輸入提款金額：");

                    if (withdrawAmount > balance) {
                        System.out.println("錯誤：您的餘額不足！目前餘額為 " + balance + " 元。");
                    } else {
                        balance = withdraw(balance, withdrawAmount);
                        System.out.println("提款成功！已領取 " + withdrawAmount + " 元。目前餘額：" + balance + " 元");
                    }
                    break;

                default:
                    System.out.println("無效選項，請輸入 0 ~ 3 的數字。");
                    break;
            }
        }

        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n=== ATM 選單 ===");
        System.out.println("1 : 查詢餘額");
        System.out.println("2 : 存款");
        System.out.println("3 : 提款");
        System.out.println("0 : 離開");
        System.out.print("請輸入選項：");
    }

    public static int readPositiveAmount(Scanner sc, String message) {
        int amount = 0;
        while (true) {
            System.out.print(message);
            amount = sc.nextInt();
            
            if (amount > 0) {
                break;
            } else {
                System.out.println("錯誤：金額必須大於 0，請重新輸入！");
            }
        }
        return amount;
    }

    public static int deposit(int balance, int amount) {
        return balance + amount;
    }

    public static int withdraw(int balance, int amount) {
        return balance - amount;
    }

    public static void printBalance(int balance) {
        System.out.println("您的目前餘額為：" + balance + " 元");
    }
}
