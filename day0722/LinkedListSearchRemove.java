package day0722;

public class LinkedListSearchRemove {
    public static boolean contains(Node head, int target) {
        if (head == null) {
            return false;
        }
        Node curr = head;
        while (curr != null) {
            if (curr.val == target) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public static Node removeValue(Node head, int target) {
        if (head == null) {
            System.out.println("串列為空，無法刪除！");
            return null;
        }

        if (head.val == target) {
            System.out.println("成功刪除頭節點: " + target);
            return head.next;
        }

        Node curr = head;
        while (curr.next != null && curr.next.val != target) {
            curr = curr.next;
        }

        if (curr.next == null) {
            System.out.println("找不到欲刪除的數值: " + target);
            return head; // 鏈結不變，回傳原 head
        }

        System.out.println("成功刪除節點: " + target);
        curr.next = curr.next.next;

        return head;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("串列為空 (Empty List)");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.print("初始鏈結串列: ");
        printList(head);
        System.out.println("====================================");

        System.out.println("是否包含 30? " + contains(head, 30));
        System.out.println("是否包含 99? " + contains(head, 99));
        System.out.println("====================================");

        head = removeValue(head, 30);
        System.out.print("刪除後串列: ");
        printList(head);
        System.out.println();

        head = removeValue(head, 40);
        System.out.print("刪除後串列: ");
        printList(head);
        System.out.println();

        head = removeValue(head, 10);
        System.out.print("刪除後串列: ");
        printList(head);
        System.out.println();

        head = removeValue(head, 99);
        System.out.print("刪除後串列: ");
        printList(head);
        System.out.println();

        head = removeValue(head, 20);
        System.out.print("刪除後串列: ");
        printList(head);
        System.out.println();

        System.out.println("空串列搜尋 10: " + contains(head, 10));
        head = removeValue(head, 10);
    }
}
