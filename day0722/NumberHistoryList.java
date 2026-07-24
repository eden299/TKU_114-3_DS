package day0722;
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}
public class NumberHistoryList {
    private Node head;

    public NumberHistoryList() {
        this.head = null;
    }

    public void addFirst(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        System.out.println("前端新增: " + val);
    }

    public void addLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        System.out.println("尾端新增: " + val);
    }

    public boolean contains(int target) {
        Node curr = head;
        while (curr != null) {
            if (curr.val == target) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public boolean remove(int target) {
        if (head == null) {
            System.out.println("刪除失敗 (串列為空): " + target);
            return false;
        }

        if (head.val == target) {
            head = head.next;
            System.out.println("成功刪除頭節點: " + target);
            return true;
        }

        Node curr = head;
        while (curr.next != null && curr.next.val != target) {
            curr = curr.next;
        }

        if (curr.next == null) {
            System.out.println("刪除失敗 (找不到資料): " + target);
            return false;
        }

        curr.next = curr.next.next;
        System.out.println("成功刪除節點: " + target);
        return true;
    }

    public void printList() {
        System.out.print("串列內容: ");
        if (head == null) {
            System.out.println("空串列");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public void printStats() {
        if (head == null) {
            System.out.println("[統計結果] Size: 0 | 總和: 0 | 最大值: 無 | 最小值: 無 (串列為空)");
            return;
        }

        int size = 0;
        long sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        Node curr = head;
        while (curr != null) {
            size++;
            sum += curr.val;
            if (curr.val > max) max = curr.val;
            if (curr.val < min) min = curr.val;
            curr = curr.next;
        }

        System.out.println("[統計結果] Size: " + size + " | 總和: " + sum + " | 最大值: " + max + " | 最小值: " + min);
    }

    public static void main(String[] args) {
        NumberHistoryList list = new NumberHistoryList();

        System.out.println("--- 操作 1: 測試初始空串列統計 ---");
        list.printList();
        list.printStats();

        System.out.println("\n--- 操作 2: 前端新增 20 ---");
        list.addFirst(20);
        list.printList();

        System.out.println("\n--- 操作 3: 前端新增 10 ---");
        list.addFirst(10);
        list.printList();

        System.out.println("\n--- 操作 4: 尾端新增 50 ---");
        list.addLast(50);
        list.printList();

        System.out.println("\n--- 操作 5: 尾端新增 30 ---");
        list.addLast(30);
        list.printList();
        list.printStats();

        System.out.println("\n--- 操作 6: 搜尋測試 ---");
        System.out.println("搜尋 50: " + list.contains(50));
        System.out.println("搜尋 99: " + list.contains(99));

        System.out.println("\n--- 操作 7: 刪除中間節點 (50) ---");
        list.remove(50);
        list.printList();

        System.out.println("\n--- 操作 8: 刪除找不到的資料 (100) ---");
        list.remove(100);
        list.printList();

        System.out.println("\n--- 操作 9: 刪除頭節點 (10) 並印出最終統計 ---");
        list.remove(10);
        list.printList();
        list.printStats();
    }
}
