package day0709;

import java.util.Scanner;

public class AtmMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 1000;

        while (true) {
            printMenu();

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("感謝您的使用");
                break;
            }

            switch (choice) {
                case 1:
                    checkBalance(balance);
                    break;

                case 2:
                    balance = deposit(scanner, balance);
                    break;

                case 3:
                    balance = withdraw(scanner, balance);
                    break;

                default:
                    System.out.println("無效選項，請輸入 0 ~ 3 的數字。");
                    break;
            }
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("=== ATM 選單 ===");
        System.out.println("1 : 查詢餘額");
        System.out.println("2 : 存款");
        System.out.println("3 : 提款");
        System.out.println("0 : 離開");
        System.out.print("請輸入選項：");
    }

    public static void checkBalance(int balance) {
        System.out.println("您的目前餘額為：" + balance + " 元");
    }

    public static int deposit(Scanner scanner, int balance) {
        int depositAmount = 0;
        while (true) {
            System.out.print("請輸入存款金額：");
            depositAmount = scanner.nextInt();
            
            if (depositAmount > 0) {
                break;
            } else {
                System.out.println("錯誤：存款金額必須大於 0，請重新輸入！");
            }
        }
        
        balance += depositAmount;
        System.out.println("存款成功！已存入 " + depositAmount + " 元。目前餘額：" + balance + " 元");
        return balance; 
    }

    public static int withdraw(Scanner scanner, int balance) {
        int withdrawAmount = 0;
        while (true) {
            System.out.print("請輸入提款金額：");
            withdrawAmount = scanner.nextInt();
            
            if (withdrawAmount <= 0) {
                System.out.println("錯誤：提款金額必須大於 0，請重新輸入");
            } else if (withdrawAmount > balance) {
                System.out.println("錯誤：您的餘額不足！目前餘額為 " + balance + " 元，請重新輸入！");
            } else {
                break; 
            }
        }

        balance -= withdrawAmount;
        System.out.println("提款成功！已領取 " + withdrawAmount + " 元。目前餘額：" + balance + " 元");
        return balance; 
    }
}
