package day0721;

import java.util.ArrayList;
import java.util.Scanner;

public class EquipmentManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Equipment> equipmentList = new ArrayList<>();

        while (true) {
            System.out.println("\n=== 設備管理系統 ===");
            System.out.println("1. 新增設備");
            System.out.println("2. 依代碼搜尋設備");
            System.out.println("3. 借出設備");
            System.out.println("4. 歸還設備");
            System.out.println("5. 列出所有可借設備");
            System.out.println("6. 離開系統");
            System.out.print("請選擇操作 (1-6): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addEquipment(scanner, equipmentList);
                    break;
                case "2":
                    searchEquipment(scanner, equipmentList);
                    break;
                case "3":
                    borrowEquipment(scanner, equipmentList);
                    break;
                case "4":
                    returnEquipment(scanner, equipmentList);
                    break;
                case "5":
                    listAvailableEquipment(equipmentList);
                    break;
                case "6":
                    System.out.println("感謝使用設備管理系統！");
                    scanner.close();
                    return;
                default:
                    System.out.println("【錯誤】無效選項，請重新輸入！");
            }
        }
    }

    private static Equipment findById(String id, ArrayList<Equipment> list) {
        for (Equipment eq : list) {
            if (eq.getId().equalsIgnoreCase(id)) {
                return eq;
            }
        }
        return null;
    }

    private static void addEquipment(Scanner scanner, ArrayList<Equipment> list) {
        System.out.print("請輸入設備代碼: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("【錯誤】設備代碼不可為空白！");
            return;
        }

        if (findById(id, list) != null) {
            System.out.println("【錯誤】設備代碼 「" + id + "」 已存在，不可重複新增！");
            return;
        }

        System.out.print("請輸入設備名稱: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("【錯誤】設備名稱不可為空白！");
            return;
        }

        list.add(new Equipment(id, name));
        System.out.println("成功新增設備: " + name + " (代碼: " + id + ")");
    }

    private static void searchEquipment(Scanner scanner, ArrayList<Equipment> list) {
        System.out.print("請輸入要搜尋的設備代碼: ");
        String id = scanner.nextLine().trim();
        Equipment eq = findById(id, list);

        if (eq != null) {
            System.out.println("【搜尋結果】" + eq);
        } else {
            System.out.println("【搜尋結果】找不到代碼為 「" + id + "」 的設備。");
        }
    }

    private static void borrowEquipment(Scanner scanner, ArrayList<Equipment> list) {
        System.out.print("請輸入要借出的設備代碼: ");
        String id = scanner.nextLine().trim();
        Equipment eq = findById(id, list);

        if (eq == null) {
            System.out.println("【借出失敗】找不到該設備！");
        } else if (!eq.isAvailable()) {
            System.out.println("【借出失敗】設備 「" + eq.getName() + "」 目前已被借出中！");
        } else {
            eq.setAvailable(false);
            System.out.println("成功借出設備: " + eq.getName());
        }
    }

    private static void returnEquipment(Scanner scanner, ArrayList<Equipment> list) {
        System.out.print("請輸入要歸還的設備代碼: ");
        String id = scanner.nextLine().trim();
        Equipment eq = findById(id, list);

        if (eq == null) {
            System.out.println("【歸還失敗】找不到該設備！");
        } else if (eq.isAvailable()) {
            System.out.println("【歸還失敗】設備 「" + eq.getName() + "」 未被借出，無需歸還！");
        } else {
            eq.setAvailable(true);
            System.out.println("成功歸還設備: " + eq.getName());
        }
    }

    private static void listAvailableEquipment(ArrayList<Equipment> list) {
        System.out.println("\n=== 可借用設備清單 ===");
        boolean hasAvailable = false;
        for (Equipment eq : list) {
            if (eq.isAvailable()) {
                System.out.println(eq);
                hasAvailable = true;
            }
        }
        if (!hasAvailable) {
            System.out.println("目前沒有可借用的設備。");
        }
    }
}
