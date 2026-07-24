package day0722;
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}
public class LinkedListReverse {
    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev; 
            prev = curr;
            curr = next;
        }

        return prev;
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
        System.out.println("=== 3. 測試：空串列 ===");
        Node emptyHead = null;
        System.out.print("反轉前: ");
        printList(emptyHead);
        emptyHead = reverse(emptyHead);
        System.out.print("反轉後: ");
        printList(emptyHead);

        System.out.println("\n=== 3. 測試：單一節點 ===");
        Node singleHead = new Node(100);
        System.out.print("反轉前: ");
        printList(singleHead);
        singleHead = reverse(singleHead);
        System.out.print("反轉後: ");
        printList(singleHead);

        System.out.println("\n=== 3. 測試：多節點 (10 -> 20 -> 30 -> 40) ===");
        Node multiHead = new Node(10);
        multiHead.next = new Node(20);
        multiHead.next.next = new Node(30);
        multiHead.next.next.next = new Node(40);

        System.out.print("反轉前: ");
        printList(multiHead);
        multiHead = reverse(multiHead);
        System.out.print("反轉後: ");
        printList(multiHead);
    }
}
