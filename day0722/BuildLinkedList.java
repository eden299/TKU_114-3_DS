package day0722;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}
public class BuildLinkedList {
    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);

        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.print("鏈結串列內容: ");
        printList(head);

        int count = 0;
        int sum = 0;
        Node current = head;

        while (current != null) {
            count++;
            sum += current.val;
            current = current.next;
        }

        System.out.println("總節點數: " + count);
        System.out.println("節點總和: " + sum);

        System.out.print("\n[邊界測試] 空串列輸出: ");
        printList(null);
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
}
