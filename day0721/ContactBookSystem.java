package day0721;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactBookSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();

        while (true) {
            System.out.println("\n=== 聯絡人管理系統 ===");
            System.out.println("1. 新增聯絡人");
            System.out.println("2. 搜尋聯絡人 (代碼/姓名)");
            System.out.println("3. 修改電話");
            System.out.println("4. 刪除聯絡人");
            System.out.println("5. 列出完整清單");
            System.out.println("6. 離開系統");
            System.out.print("請選擇功能選項 (1-6): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addContact(scanner, contacts);
                    break;
                case "2":
                    searchContact(scanner, contacts);
                    break;
                case "3":
                    updatePhone(scanner, contacts);
                    break;
                case "4":
                    deleteContact(scanner, contacts);
                    break;
                case "5":
                    listAllContacts(contacts);
                    break;
                case "6":
                    System.out.println("感謝使用聯絡人管理系統，再見！");
                    scanner.close();
                    return;
                default:
                    System.out.println("【錯誤】無效選項，請重新選擇！");
            }
        }
    }

    public static Contact findById(String id, ArrayList<Contact> contacts) {
        for (Contact c : contacts) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    public static void addContact(Scanner scanner, ArrayList<Contact> contacts) {
        System.out.print("請輸入聯絡人代碼: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("【錯誤】代碼不得為空白！");
            return;
        }

        if (findById(id, contacts) != null) {
            System.out.println("【錯誤】代碼 「" + id + "」 已存在，無法重複新增！");
            return;
        }

        System.out.print("請輸入姓名: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("【錯誤】空白姓名不可加入！");
            return;
        }

        System.out.print("請輸入電話: ");
        String phone = scanner.nextLine().trim();

        System.out.print("請輸入電子郵件: ");
        String email = scanner.nextLine().trim();

        contacts.add(new Contact(id, name, phone, email));
        System.out.println("成功新增聯絡人: " + name);
    }

    public static void searchContact(Scanner scanner, ArrayList<Contact> contacts) {
        System.out.print("請輸入要搜尋的代碼或姓名: ");
        String keyword = scanner.nextLine().trim();

        boolean found = false;
        for (Contact c : contacts) {
            if (c.getId().equalsIgnoreCase(keyword) || c.getName().equalsIgnoreCase(keyword)) {
                System.out.println("【找到結果】" + c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("找不到符合條件 「" + keyword + "」 的聯絡人。");
        }
    }

    public static void updatePhone(Scanner scanner, ArrayList<Contact> contacts) {
        System.out.print("請輸入要修改電話的聯絡人代碼: ");
        String id = scanner.nextLine().trim();
        Contact contact = findById(id, contacts);

        if (contact == null) {
            System.out.println("【修改失敗】找不到該代碼的聯絡人！");
        } else {
            System.out.println("當前聯絡人: " + contact.getName() + "，原電話: " + contact.getPhone());
            System.out.print("請輸入新電話: ");
            String newPhone = scanner.nextLine().trim();
            contact.setPhone(newPhone);
            System.out.println("成功更新 「" + contact.getName() + "」 的電話為: " + newPhone);
        }
    }

    public static void deleteContact(Scanner scanner, ArrayList<Contact> contacts) {
        System.out.print("請輸入要刪除的聯絡人代碼: ");
        String id = scanner.nextLine().trim();
        Contact contact = findById(id, contacts);

        if (contact == null) {
            System.out.println("【刪除失敗】找不到該代碼的聯絡人！");
        } else {
            contacts.remove(contact);
            System.out.println("成功刪除聯絡人: " + contact.getName());
        }
    }

    public static void listAllContacts(ArrayList<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("目前沒有任何聯絡人資料。");
        } else {
            System.out.println("\n=== 完整聯絡人清單 (" + contacts.size() + " 筆) ===");
            for (Contact c : contacts) {
                System.out.println(c);
            }
        }
    }
}
