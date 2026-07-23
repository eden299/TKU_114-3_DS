package day0721;

import java.util.ArrayList;
import java.util.Scanner;

public class NameListManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<>();

        while (true) {
            System.out.println("\n=== 名單管理系統 ===");
            System.out.println("1. 新增姓名");
            System.out.println("2. 搜尋姓名");
            System.out.println("3. 修改姓名");
            System.out.println("4. 刪除姓名");
            System.out.println("5. 列出全部姓名");
            System.out.println("6. 離開系統");
            System.out.print("請選擇操作 (1-6): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addName(scanner, nameList);
                    break;
                case "2":
                    searchName(scanner, nameList);
                    break;
                case "3":
                    updateName(scanner, nameList);
                    break;
                case "4":
                    deleteName(scanner, nameList);
                    break;
                case "5":
                    listAllNames(nameList);
                    break;
                case "6":
                    System.out.println("感謝使用，系統已結束。");
                    scanner.close();
                    return;
                default:
                    System.out.println("【錯誤】無效選項，請重新選擇！");
            }
        }
    }

    private static void addName(Scanner scanner, ArrayList<String> nameList) {
        System.out.print("請輸入要新增的姓名: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("【錯誤】不得加入空白姓名！");
        } else {
            nameList.add(name);
            System.out.println("成功新增姓名: " + name);
        }
    }

    private static void searchName(Scanner scanner, ArrayList<String> nameList) {
        System.out.print("請輸入要搜尋的姓名: ");
        String query = scanner.nextLine().trim();
        
        boolean found = false;
        for (int i = 0; i < nameList.size(); i++) {
            if (nameList.get(i).equalsIgnoreCase(query)) {
                System.out.println("找到姓名：「" + nameList.get(i) + "」，位於位置 [" + (i + 1) + "]");
                found = true;
            }
        }
        if (!found) {
            System.out.println("找不到姓名: " + query);
        }
    }

    private static void updateName(Scanner scanner, ArrayList<String> nameList) {
        System.out.print("請輸入要修改的原姓名: ");
        String oldName = scanner.nextLine().trim();

        int index = -1;
        for (int i = 0; i < nameList.size(); i++) {
            if (nameList.get(i).equalsIgnoreCase(oldName)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("【修改失敗】找不到姓名: " + oldName);
        } else {
            System.out.print("請輸入新的姓名: ");
            String newName = scanner.nextLine().trim();
            if (newName.isEmpty()) {
                System.out.println("【錯誤】新姓名不得為空白！");
            } else {
                String targetName = nameList.get(index);
                nameList.set(index, newName);
                System.out.println("成功將 「" + targetName + "」 修改為 「" + newName + "」");
            }
        }
    }

    private static void deleteName(Scanner scanner, ArrayList<String> nameList) {
        System.out.print("請輸入要刪除的姓名: ");
        String target = scanner.nextLine().trim();

        boolean removed = false;
        for (int i = 0; i < nameList.size(); i++) {
            if (nameList.get(i).equalsIgnoreCase(target)) {
                String removedName = nameList.remove(i);
                System.out.println("成功刪除姓名: " + removedName);
                removed = true;
                break; 
            }
        }

        if (!removed) {
            System.out.println("【刪除失敗】找不到姓名: " + target);
        }
    }

    private static void listAllNames(ArrayList<String> nameList) {
        if (nameList.isEmpty()) {
            System.out.println("目前名單為空。");
        } else {
            System.out.println("=== 目前名單清單 (" + nameList.size() + " 人) ===");
            for (int i = 0; i < nameList.size(); i++) {
                System.out.println((i + 1) + ". " + nameList.get(i));
            }
        }
    }
}
