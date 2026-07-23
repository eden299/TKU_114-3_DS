package day0721;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<CartItem> cart = new ArrayList<>();

        while (true) {
            System.out.println("\n=== 購物車系統 ===");
            System.out.println("1. 加入商品 (或增加數量)");
            System.out.println("2. 修改商品數量");
            System.out.println("3. 移除商品");
            System.out.println("4. 檢視購物車與計算總額");
            System.out.println("5. 離開系統");
            System.out.print("請選擇操作 (1-5): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addItem(scanner, cart);
                    break;
                case "2":
                    updateQuantity(scanner, cart);
                    break;
                case "3":
                    removeItem(scanner, cart);
                    break;
                case "4":
                    viewCart(cart);
                    break;
                case "5":
                    System.out.println("感謝使用購物車系統！");
                    scanner.close();
                    return;
                default:
                    System.out.println("【錯誤】無效選項，請重新選擇！");
            }
        }
    }

    private static CartItem findById(String id, ArrayList<CartItem> cart) {
        for (CartItem item : cart) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }

    private static void addItem(Scanner scanner, ArrayList<CartItem> cart) {
        System.out.print("請輸入商品代碼: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("【錯誤】商品代碼不可為空白！");
            return;
        }

        CartItem existingItem = findById(id, cart);

        if (existingItem != null) {
            System.out.println("商品已在購物車中 (目前數量: " + existingItem.getQuantity() + ")");
            System.out.print("請輸入要增加的數量: ");
            int addQty = readPositiveInt(scanner);
            if (addQty > 0) {
                existingItem.setQuantity(existingItem.getQuantity() + addQty);
                System.out.println("成功更新！「" + existingItem.getName() + "」 最新數量為: " + existingItem.getQuantity());
            } else {
                System.out.println("【錯誤】增加數量必須大於 0！");
            }
        } else {
            System.out.print("請輸入商品名稱: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("【錯誤】商品名稱不可為空白！");
                return;
            }

            System.out.print("請輸入商品單價: ");
            double price = readPositiveDouble(scanner);
            if (price <= 0) {
                System.out.println("【錯誤】單價必須大於 0！");
                return;
            }

            System.out.print("請輸入商品數量: ");
            int quantity = readPositiveInt(scanner);
            if (quantity <= 0) {
                System.out.println("【錯誤】數量必須大於 0！");
                return;
            }

            cart.add(new CartItem(id, name, price, quantity));
            System.out.println("成功加入商品: " + name);
        }
    }

    private static void updateQuantity(Scanner scanner, ArrayList<CartItem> cart) {
        System.out.print("請輸入要修改數量的商品代碼: ");
        String id = scanner.nextLine().trim();
        CartItem item = findById(id, cart);

        if (item == null) {
            System.out.println("【修改失敗】購物車中找不到該商品！");
            return;
        }

        System.out.println("當前商品: " + item.getName() + "，目前數量: " + item.getQuantity());
        System.out.print("請輸入新的數量: ");
        int newQty = readPositiveInt(scanner);

        if (newQty <= 0) {
            System.out.println("【修改失敗】數量必須大於 0，不接受此更新！");
        } else {
            item.setQuantity(newQty);
            System.out.println("成功將 「" + item.getName() + "」 的數量修改為: " + newQty);
        }
    }

    private static void removeItem(Scanner scanner, ArrayList<CartItem> cart) {
        System.out.print("請輸入要移除的商品代碼: ");
        String id = scanner.nextLine().trim();
        CartItem item = findById(id, cart);

        if (item == null) {
            System.out.println("【移除失敗】購物車中找不到該商品！");
        } else {
            cart.remove(item);
            System.out.println("已成功從購物車中移除: " + item.getName());
        }
    }

    private static void viewCart(ArrayList<CartItem> cart) {
        if (cart.isEmpty()) {
            System.out.println("購物車目前是空的。");
            return;
        }

        System.out.println("\n=== 購物車清單 ===");
        double total = 0.0;
        for (CartItem item : cart) {
            System.out.println(item);
            total += item.getSubtotal();
        }
        System.out.println("------------------------------------------");
        System.out.printf("購物車總金額: %.1f 元\n", total);
    }

    private static int readPositiveInt(Scanner scanner) {
        try {
            int val = Integer.parseInt(scanner.nextLine().trim());
            return val;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static double readPositiveDouble(Scanner scanner) {
        try {
            double val = Double.parseDouble(scanner.nextLine().trim());
            return val;
        } catch (NumberFormatException e) {
            return -1.0;
        }
    }
}
