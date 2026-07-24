package day0722;

public class TaskLinkedList {
    private TaskNode head;

    public TaskLinkedList() {
        this.head = null;
    }

    public void addUrgentTask(String id, String description) {
        TaskNode newNode = new TaskNode(id, description);
        newNode.next = head;
        head = newNode;
        System.out.println("新增【緊急工作】至前端: [" + id + "] " + description);
    }

    public void addNormalTask(String id, String description) {
        TaskNode newNode = new TaskNode(id, description);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        System.out.println("新增【一般工作】至尾端: [" + id + "] " + description);
    }

    public boolean completeTask(String id) {
        TaskNode curr = head;
        while (curr != null) {
            if (curr.id.equals(id)) {
                curr.isCompleted = true;
                System.out.println("成功完成工作: [" + id + "] " + curr.description);
                return true;
            }
            curr = curr.next;
        }
        System.out.println("操作失敗：找不到工作代碼 [" + id + "]");
        return false;
    }

    public boolean removeTask(String id) {
        if (head == null) {
            System.out.println("刪除失敗：工作清單為空！");
            return false;
        }

        if (head.id.equals(id)) {
            System.out.println("成功刪除頭部工作: [" + head.id + "] " + head.description);
            head = head.next;
            return true;
        }

        TaskNode curr = head;
        while (curr.next != null && !curr.next.id.equals(id)) {
            curr = curr.next;
        }

        if (curr.next == null) {
            System.out.println("刪除失敗：找不到工作代碼 [" + id + "]");
            return false;
        }

        System.out.println("成功刪除工作: [" + curr.next.id + "] " + curr.next.description);
        curr.next = curr.next.next;
        return true;
    }

    public void printUnfinishedTasksAndStats() {
        int totalCount = 0;
        int unfinishedCount = 0;

        System.out.println("\n--- 未完成工作列表 ---");
        TaskNode curr = head;
        while (curr != null) {
            totalCount++;
            if (!curr.isCompleted) {
                unfinishedCount++;
                System.out.println("- [" + curr.id + "] " + curr.description);
            }
            curr = curr.next;
        }

        if (unfinishedCount == 0) {
            System.out.println("(無未完成工作)");
        }

        System.out.println("----------------------");
        System.out.println("工作總數: " + totalCount + " | 未完成數量: " + unfinishedCount);
    }
}
